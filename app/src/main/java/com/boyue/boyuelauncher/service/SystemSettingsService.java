package com.boyue.boyuelauncher.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ShutDownUtils;


/**
 * 主要用来定时休息和自动关机
 */
public class SystemSettingsService extends Service {

    public static String TAG = SystemSettingsService.class.getSimpleName();


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        switch (intent.getAction()) {
            case Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION:
                LogUtils.e("tlh", "ONTIME_LOCKSCREEN_ACTION");
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_PROTECTEYELOCKSCREEN);
                break;
            case Config.BoYueAction.ONTIME_REST_ACTION:
                LogUtils.e("tlh", "ONTIME_REST_ACTION");
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_FCMLOCKSCREEN);
                break;
            case Config.BoYueAction.ONTIME_SHUTDOWN_ACTION:
                LogUtils.e("tlh", "ONTIME_SHUTDOWN_ACTION");
                //执行关机
                ShutDownUtils.shutdown();
                break;

        }
        return super.onStartCommand(intent, flags, startId);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}