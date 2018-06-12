package com.boyue.boyuelauncher.fcmlockscreen;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LockScreenUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;

import javax.crypto.spec.IvParameterSpec;

public class FcmLockScreenPersenter extends AbstractPresenter<FcmLockScreenView> {


    private SPUtils spUtils;
    private FcmLockScreenMode mode;

    public FcmLockScreenPersenter(Context mContext) {
        this.spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
        this.mode = new FcmLockScreenMode(mContext, new FcmLockScreenMode.CallBack() {
            @Override
            public void setUpdateClock(String date, String week, int time_0_Leve, int time_1_Leve, int time_2_Leve, int time_3_Leve) {
                FcmLockScreenView view = getView();
                if (view == null) return;
                view.setUpdateClock(date, week, time_0_Leve, time_1_Leve, time_2_Leve, time_3_Leve);
            }
        });
    }


    boolean matchingPwd(String pwd) {
        boolean isMactch = false;
        if (pwd.equals(spUtils.getString(Config.PWDKey.BOOT_PWD_NAME))) {
            isMactch = true;
        }
        return isMactch;
    }

    public void cancleLockScreen(String action) {
        LogUtils.e("tlh", "cancleRegularRestAlarm");
        LockScreenUtils.cancleLockScreen(action);

    }


    public void startLockScreen(String action) {
        int time = spUtils.getInt((Config.PWDKey.TIMING_LOCKING_KEY));
        if (time == Config.Settings.VALUE_NEVER) return;
        LockScreenUtils.startLockScreen(action, time);
    }


    public void updateClock() {
        if (mode == null) return;
        mode.updateClock();

    }

    public void registerReceiver() {

        if (mode == null) return;
        mode.registerReceiver();

    }

    public void unregisterReceiver() {
        if (mode == null) return;
        mode.unregisterReceiver();

    }
}
