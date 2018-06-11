package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.SPUtils;

public class ProtectEyePersenter extends AbstractPresenter<ProtectEyeView> {

    private SPUtils spUtils;

    public ProtectEyePersenter() {
        this.spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
    }

    //返回系统是否开启了密码设置
    public boolean hasePassWord() {

        return spUtils.getBoolean(Config.PWDKey.PWD_IS_ENABLE);
    }

    public void setRegularRestTime(int time) {


    }

    public void setRegularRestPassWord() {

    }
}
