package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import android.opengl.GLSurfaceView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;

public class ProtectEyePersenter extends AbstractPresenter<ProtectEyeView> {

    private SPUtils spUtils;
    private ProtectEyeMode mode;

    public ProtectEyePersenter() {
        this.spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
        this.mode = new ProtectEyeMode(spUtils,new ProtectEyeMode.CallBack() {
            @Override
            public void setInitView(int screenBrightness, boolean isOpenProtectSener, int regularRestTime) {
                ProtectEyeView view = getView();
                if (view == null) return;
                view.setInitView(screenBrightness, isOpenProtectSener, regularRestTime);
            }
        });
    }

    //返回系统是否开启了密码设置
    public boolean hasePassWord() {

        return spUtils.getBoolean(Config.PWDKey.PWD_IS_ENABLE);
    }

    //保存定时休息的时间
    public void setRegularRestTime(int time) {
        LogUtils.e("tlh", "ProtectEyePersenter---setRegularRestTime----time:" + time);

        spUtils.put(Config.PWDKey.REGULARREST_KEY, time);

    }


    public void initView() {
        if (mode == null) return;
        mode.initView();

    }
}
