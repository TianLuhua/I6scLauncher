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
        this.spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
    }

    public void getSystmStatus() {

        if (callback == null) return;
        boolean pwdIsEnable = spUtils.getBoolean(Config.PWDKey.PWD_IS_ENABLE);
        boolean pwdFcmIsEnable = spUtils.getBoolean(Config.PWDKey.FCM_PWD_NAME);
        callback.setSystmStatus(pwdIsEnable, pwdFcmIsEnable);

    }


    public void disAbleFcmPassWord(boolean isEnable) {
        LogUtils.e("tlh", "disAbleFcmPassWord:" + isEnable);
        spUtils.put(Config.PWDKey.FCM_PWD_NAME, isEnable);
    }

    public void enAblePassword(boolean isEnable) {
        LogUtils.e("tlh", "enAblePassword:" + isEnable);
        spUtils.put(Config.PWDKey.PWD_IS_ENABLE, isEnable);
    }


    @Override
    public void onDestroy() {
        if (callback != null)
            callback = null;
        if (spUtils != null)
            spUtils = null;

    }

    public boolean matchingPwd(String pwd) {
        boolean isMactch = false;

        if (pwd.equals(spUtils.getString(Config.PWDKey.BOOT_PWD_NAME))) {
            isMactch = true;
        }

        return isMactch;
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

            spUtils.put(Config.PWDKey.BOOT_PWD_NAME, pwd);

            return true;
        }
        return false;
    }

    public static interface CallBack {
        void setSystmStatus(boolean pwdIsEnable, boolean pwdFcmIsEnable);
    }
}
