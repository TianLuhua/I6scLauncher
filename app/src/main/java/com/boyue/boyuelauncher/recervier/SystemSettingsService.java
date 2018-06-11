package com.boyue.boyuelauncher.recervier;

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
            case Config.BoYueAction.ACTION_SHUTDOWN:
                LogUtils.e("tlh", "ACTION_SHUTDOWN");
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_PROTECTEYELOCKSCREEN);
                break;
            case Config.BoYueAction.ACTION_REST:
                LogUtils.e("tlh", "ACTION_REST");
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