package com.boyue.boyuelauncher.ProtectEyeLockScreen;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.service.SystemSettingsService;
import com.boyue.boyuelauncher.utils.LockScreenUtils;
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

    public void cancleRegularRestAlarm(String action) {
        LogUtils.e("tlh", "cancleRegularRestAlarm");
        LockScreenUtils.cancleLockScreen(action);

    }


    public void startRegularRestAlarm(String action) {
        int time = spUtils.getInt((Config.PWDKey.REGULAR_REST_KEY));
        if (time == Config.Settings.VALUE_NEVER) return;
        LockScreenUtils.startLockScreen(action);
    }
}
