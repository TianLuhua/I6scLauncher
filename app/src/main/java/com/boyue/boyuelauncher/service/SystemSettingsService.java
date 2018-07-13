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
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ScreenUtils;
import com.boyue.boyuelauncher.utils.ShutDownUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.io.IOException;

import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_AR;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_LY;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_PROTECT_EYE;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_XT;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_ZXBX;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_AUDIO_KEY;


/**
 * 主要用来定时休息和自动关机、护眼传感器的响应
 */
public class SystemSettingsService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    public static String TAG = SystemSettingsService.class.getSimpleName();

    private SensorManager mSensorMgr;
    private Sensor mGnPSensor;
    //定义监听器
    private SensorEventListener mGnPSensorEventListener;


    //播放背景音乐相关
    private MediaPlayer mediaPlayer;


    @Override
    public void onCreate() {
        super.onCreate();


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

                LogUtils.e("tlh", "PROTECTSENSOR_ACTION");
                //获取传感器管理类及距离传感器
                mSensorMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                mGnPSensor = mSensorMgr.getDefaultSensor(Sensor.TYPE_PROXIMITY);

                mGnPSensorEventListener = new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent event) {
                        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                            getDistance(event);
                        }
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }

                };
                //在传感器管理类中注册距离传感器的监听器
                mSensorMgr.registerListener(mGnPSensorEventListener, mGnPSensor, 12000);
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
     * 根据距离感应器的数据，操作屏幕的亮度
     *
     * @param event
     */
    private void getDistance(SensorEvent event) {
        float distance = event.values[0];
        LogUtils.e("tlh", "SystemSettingsService---getDistance:" + distance);
        if (distance == 0.0)
            //播放提示音
            startPlayAudio(HHT_PROTECT_EYE);
        ScreenUtils.setScreenBrightness(20);
        if (distance == 5.0)
            ScreenUtils.setScreenBrightness(200);
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
            Log.e("tlh", "isPlaying");
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        //stopSelf();
        Log.e("tlh", "onCompletion");
        if (mediaPlayer == null) return;
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.e("tlh", "onPrepared");
        if (mediaPlayer == null) return;
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("tlh", "onDestroy");

    }
}