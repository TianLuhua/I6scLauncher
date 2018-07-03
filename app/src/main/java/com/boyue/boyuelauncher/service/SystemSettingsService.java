package com.boyue.boyuelauncher.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ScreenUtils;
import com.boyue.boyuelauncher.utils.ShutDownUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;


/**
 * 主要用来定时休息和自动关机、护眼传感器的响应
 */
public class SystemSettingsService extends Service {

    public static String TAG = SystemSettingsService.class.getSimpleName();

    private SensorManager mSensorMgr;
    private Sensor mGnPSensor;
    //定义监听器
    private SensorEventListener mGnPSensorEventListener;


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
            ScreenUtils.setScreenBrightness(20);
        if (distance == 5.0)
            ScreenUtils.setScreenBrightness(200);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}