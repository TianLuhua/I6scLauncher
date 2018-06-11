package com.boyue.boyuelauncher.ProtectEyeLockScreen;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.recervier.SystemSettingsService;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;


public class ProtectEyeLockScreenPersenter extends AbstractPresenter<ProtectEyeLockScreenView> {

    private Context mContext;
    private SPUtils spUtils;

    public ProtectEyeLockScreenPersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
    }

    boolean matchingPwd(String pwd) {
        boolean isMactch = false;
        if (pwd.equals(spUtils.getString(Config.PWDKey.BOOT_PWD_NAME))) {
            isMactch = true;
        }
        return isMactch;
    }

    public void cancleRegularRestAlarm() {
        LogUtils.e("tlh", "cancleRegularRestAlarm");
        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mContext, SystemSettingsService.class);
        intent.setAction(Config.BoYueAction.ACTION_SHUTDOWN);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        am.cancel(pendingIntent);
    }


    public void startRegularRestAlarm() {
        int time = spUtils.getInt((Config.PWDKey.REGULARREST_KEY));
        if (time == Config.Settings.VALUE_NEVER) return;
        LogUtils.e("tlh", "starRegularRestAlarm---time:" + time);
        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mContext, SystemSettingsService.class);
        intent.setAction(Config.BoYueAction.ACTION_SHUTDOWN);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, time + SystemClock.elapsedRealtime(), time, pendingIntent);
    }
}
