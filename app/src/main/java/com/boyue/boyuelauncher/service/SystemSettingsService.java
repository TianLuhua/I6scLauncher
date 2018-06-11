package com.boyue.boyuelauncher.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;


/**
 * 主要用来定时休息和自动关机
 */
public class SystemSettingsService extends Service {

    public static String TAG = SystemSettingsService.class.getSimpleName();


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        switch (intent.getAction()) {
            case Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION:
                LogUtils.e("tlh", "ACTION_SHUTDOWN");
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_PROTECTEYELOCKSCREEN);
                break;
            case Config.BoYueAction.ONTIME_REST_ACTION:
                LogUtils.e("tlh", "ACTION_REST");
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_FCMLOCKSCREEN);
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