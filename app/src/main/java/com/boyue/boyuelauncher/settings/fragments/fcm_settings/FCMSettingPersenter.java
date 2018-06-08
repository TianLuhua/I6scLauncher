package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import com.boyue.boyuelauncher.base.AbstractPresenter;

public class FCMSettingPersenter extends AbstractPresenter<FCMSettingView> {

    private FCMSettingMode mode;

    public FCMSettingPersenter() {
        this.mode = new FCMSettingMode(new FCMSettingMode.CallBack() {
            @Override
            public void setSystmStatus(boolean pwdIsEnable, boolean pwdFcmIsEnable) {
                FCMSettingView view = getView();
                if (view == null) return;
                view.setSystmStatus(pwdIsEnable, pwdFcmIsEnable);
            }
        });
    }

    public void getSystmStatus() {
        if (mode == null) return;
        mode.getSystmStatus();

    }


    public void disAbleFcmPassWord(boolean isEnable) {
        if (mode == null) return;
        mode.disAbleFcmPassWord(isEnable);


    }

    public void enAblePassword(boolean isEnable) {
        if (mode == null) return;
        mode.enAblePassword(isEnable);
    }

    public boolean matchingPwd(String pwd) {

        if (mode == null) return false;

        return mode.matchingPwd(pwd);
    }

    public boolean saveingPwd(String pwd) {

        if (mode == null) return false;
        return mode.saveingPwd(pwd);

    }
}
