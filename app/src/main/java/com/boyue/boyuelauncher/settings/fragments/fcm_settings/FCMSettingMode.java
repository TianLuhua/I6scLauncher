package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;


public class FCMSettingMode implements BaseMode {

    private CallBack callback;
    private SPUtils spUtils;

    public FCMSettingMode(CallBack callback) {
        this.callback = callback;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
    }

    public void getSystmStatus() {

        if (callback == null) return;
        boolean pwdIsEnable = spUtils.getBoolean(Config.PassWordKey.PWD_IS_ENABLE);
        boolean pwdFcmIsEnable = spUtils.getBoolean(Config.PassWordKey.FCM_PWD_NAME);
        int timingTime = spUtils.getInt(Config.PassWordKey.TIMING_LOCKING_KEY);
        callback.setSystmStatus(pwdIsEnable, pwdFcmIsEnable,  timingTime);

    }


    public void disAbleFcmPassWord(boolean isEnable) {
        LogUtils.e("tlh", "disAbleFcmPassWord:" + isEnable);
        spUtils.put(Config.PassWordKey.FCM_PWD_NAME, isEnable);
    }

    public void enAblePassword(boolean isEnable) {
        LogUtils.e("tlh", "enAblePassword:" + isEnable);
        spUtils.put(Config.PassWordKey.PWD_IS_ENABLE, isEnable);
    }


    @Override
    public void onDestroy() {
        if (callback != null)
            callback = null;
        if (spUtils != null)
            spUtils = null;

    }

    public boolean matchingPwd(String pwd) {

        return pwd.equals(spUtils.getString(Config.PassWordKey.BOOT_PWD_NAME));
    }

    private String tempPwd;
    private boolean isfristInput = true;

    public boolean saveingPwd(String pwd) {

        if (isfristInput) {
            tempPwd = pwd;
            isfristInput = false;
            return false;
        }
        if (tempPwd.equals(pwd)) {

            spUtils.put(Config.PassWordKey.BOOT_PWD_NAME, pwd);

            return true;
        }
        return false;
    }

    public static interface CallBack {
        void setSystmStatus(boolean pwdIsEnable, boolean pwdFcmIsEnable,int timingTime);
    }
}
