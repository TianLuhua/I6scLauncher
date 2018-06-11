package com.boyue.boyuelauncher.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.service.SystemSettingsService;


public class LockScreenUtils {

    //开启定时休息锁屏功能
    public static void startLockScreen(String action) {
        int time = SPUtils.getInstance(Config.PWDKey.SPNMAE).getInt((Config.PWDKey.REGULAR_REST_KEY));
        if (time == Config.Settings.VALUE_NEVER) return;
        LogUtils.e("tlh", "LockScreenUtils---starRegularRestAlarm---time:" + time);
        AlarmManager am = (AlarmManager) Utils.getApp().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Utils.getApp(), SystemSettingsService.class);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(Utils.getApp(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, time + SystemClock.elapsedRealtime(), time, pendingIntent);
    }

    //取消定时休息锁屏功能
    public static void cancleLockScreen(String action) {
        LogUtils.e("tlh", "LockScreenUtils---cancleRegularRestAlarm");
        AlarmManager am = (AlarmManager) Utils.getApp().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(Utils.getApp(), SystemSettingsService.class);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(Utils.getApp(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        am.cancel(pendingIntent);
    }


}
