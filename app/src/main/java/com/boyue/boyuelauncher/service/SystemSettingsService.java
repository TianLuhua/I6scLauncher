package com.boyue.boyuelauncher.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ScreenUtils;
import com.boyue.boyuelauncher.utils.ShutDownUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.io.IOException;
import java.lang.ref.WeakReference;

import static android.hardware.SensorManager.SENSOR_DELAY_NORMAL;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_AR;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_LY;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_PROTECT_EYE;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_XT;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_ZXBX;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_AUDIO_KEY;
import static com.boyue.boyuelauncher.Config.Screen.DEFAULT_BRIGHTNESS;


/**
 * 主要用来定时休息和自动关机、护眼传感器的响应
 */
public class SystemSettingsService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    public static String TAG = SystemSettingsService.class.getSimpleName();

    public final static int PROTECT_EYE_OFF = 0X000;
    public final static int PROTECT_EYE_ON = 0X005;
    public final static int PROTECT_EYE_DELAY = 1000;


    private SensorManager mSensorMgr;
    //定义一个护眼传感器（实际为距离感应器）
    private Sensor mGnPSensor;
    //定义监听器
    private SensorEventListener mGnPSensorEventListener;
    //激活距离感应器
    private final float PROXIMITY_ON = 0.0f;
    //释放距离感应器
    private final float PROXIMITY_OFF = 5.0f;
    //激活护眼感应器前，屏幕亮度值
    private int systemScreenBrightness;

    private PowerManager powerManager;


    //播放背景音乐相关
    private MediaPlayer mediaPlayer;

    private Handler mHandler = new SystemSettingsServiceHandle(this);


    @Override
    public void onCreate() {
        super.onCreate();
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        switch (intent.getAction()) {
            case Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION:
                LogUtils.e("tlh", "ONTIME_LOCKSCREEN_ACTION");
                //启动定时锁屏
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_PROTECTEYELOCKSCREEN);
                break;
            case Config.BoYueAction.ONTIME_REST_ACTION:
                LogUtils.e("tlh", "ONTIME_REST_ACTION");
                //启动防沉迷锁屏
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_FCMLOCKSCREEN);
                break;
            case Config.BoYueAction.ONTIME_SHUTDOWN_ACTION:
                LogUtils.e("tlh", "ONTIME_SHUTDOWN_ACTION");
                //执行关机
                ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
                    @Override
                    public void run() {
                        ShutDownUtils.shutDownWithAction();
                    }
                });

                break;
            case Config.BoYueAction.PROTECTSENSOR_ACTION_OPEN:
                LogUtils.e("tlh", "PROTECTSENSOR_ACTION_OPEN");
                //获取传感器管理类及距离传感器
                if (mSensorMgr == null)
                    mSensorMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                if (mGnPSensor == null)
                    mGnPSensor = mSensorMgr.getDefaultSensor(Sensor.TYPE_PROXIMITY);
                if (mGnPSensorEventListener == null)
                    mGnPSensorEventListener = new SensorEventListener() {
                        @Override
                        public void onSensorChanged(SensorEvent event) {
                            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                                Message message = mHandler.obtainMessage();
                                mHandler.removeMessages(PROTECT_EYE_OFF);
                                mHandler.removeMessages(PROTECT_EYE_ON);
                                float distance = event.values[0];
                                if (distance == PROXIMITY_ON) {
                                    LogUtils.e("tlh", "SystemSettingsService---getDistance:" + distance);
                                    //获取护眼前屏幕的亮度，用户取消护眼时候恢复屏幕亮度
                                    systemScreenBrightness = ScreenUtils.getScreenBrightness();
                                    message.what = PROTECT_EYE_OFF;
                                    mHandler.sendMessageDelayed(message, PROTECT_EYE_DELAY);
                                } else if (distance == PROXIMITY_OFF) {
                                    LogUtils.e("tlh", "SystemSettingsService---getDistance:" + distance);
                                    message.what = PROTECT_EYE_ON;
                                    mHandler.sendMessageDelayed(message, 0);
                                }

                            }
                        }

                        @Override
                        public void onAccuracyChanged(Sensor sensor, int accuracy) {

                        }

                    };
                //在传感器管理类中注册距离传感器的监听器
                mSensorMgr.registerListener(mGnPSensorEventListener, mGnPSensor, SENSOR_DELAY_NORMAL);
                break;
            case Config.BoYueAction.PROTECTSENSOR_ACTION_CLOSE:

                //取消SensorManager的监听
                if (mSensorMgr != null) {
                    LogUtils.e("tlh", "PROTECTSENSOR_ACTION_CLOSE");
                    mSensorMgr.unregisterListener(mGnPSensorEventListener);
                    mGnPSensorEventListener = null;
                    mGnPSensor = null;
                    mSensorMgr = null;
                }
                break;

            //播放背景音乐：在线宝箱、护眼提示音
            case Config.BoYueAction.PLAYAUDIO:
                if (mediaPlayer == null) {
                    LogUtils.e("tlh", "mediaPlayer == null");
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                }
                stopPlayer();
                switch (intent.getIntExtra(HHTLY_AUDIO_KEY, -1)) {
                    case HHT_XT:
                        //火火兔学堂
                        break;
                    //火火兔AR
                    case HHT_AR:
                        break;
                    //火火兔乐园
                    case HHT_LY:
                        break;
                    //在线宝箱
                    case HHT_ZXBX:
                        try {
                            mediaPlayer.setDataSource(getApplication(), Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hht_zxbx));
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    //护眼提示音
                    case HHT_PROTECT_EYE:
                        try {
                            mediaPlayer.setDataSource(getApplication(), Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hht_protext_eye));
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                }

                break;

        }
        return START_STICKY;


    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 播放选中界面的音频文件
     *
     * @param position
     */
    private void startPlayAudio(int position) {
        Intent intent = new Intent(Config.BoYueAction.PLAYAUDIO);
        intent.putExtra(HHTLY_AUDIO_KEY, position);
        startService(intent);
    }


    private void stopPlayer() {
        if (mediaPlayer == null) return;
        if (mediaPlayer.isPlaying()) {
            LogUtils.e("tlh", "isPlaying");
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        //stopSelf();
        LogUtils.e("tlh", "onCompletion");
        if (mediaPlayer == null) return;
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        LogUtils.e("tlh", "onPrepared");
        if (mediaPlayer == null) return;
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e("tlh", "onDestroy");

    }

    /**
     * 系统建议写成static类型
     */
    static class SystemSettingsServiceHandle extends Handler {

        private WeakReference<SystemSettingsService> wfSystemSettingsService;

        public SystemSettingsServiceHandle(SystemSettingsService systemSettingsService) {
            this.wfSystemSettingsService = new WeakReference<>(systemSettingsService);
        }

        @Override
        public void handleMessage(Message msg) {
            SystemSettingsService ss = wfSystemSettingsService.get();
            if (ss == null)
                return;
            switch (msg.what) {
                case PROTECT_EYE_OFF:
                    //播放提示音(息屏的情况下不激活);如何在视屏通话的话，护眼也不生效
                    String currentActivity = ActivityUtils.getTopActivity(ss);
                    LogUtils.e("tlh", "SystemSettingsService---PROTECT_EYE_OFF-----currentActivity:" + currentActivity);
                    if (ss.powerManager.isScreenOn() && !Config.ActivityName.BOOYUE_VIDEOCHATACTIVITY.equals(currentActivity)) {
                        ss.startPlayAudio(HHT_PROTECT_EYE);
                        //默认激活护眼的屏幕亮度为20
                        ScreenUtils.setScreenBrightness(DEFAULT_BRIGHTNESS);
                    }
                    break;

                case PROTECT_EYE_ON:
                    if (ScreenUtils.getScreenBrightness() <= ss.systemScreenBrightness) {
                        ScreenUtils.setScreenBrightness(ss.systemScreenBrightness);
                    }
                    break;
            }
        }
    }


}