package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ScreenUtils;

public class ProtectEyeMode implements BaseMode {

    private CallBack callBack;
    private SPUtils spUtils;

    public ProtectEyeMode(SPUtils spUtils, CallBack callBack) {
        this.spUtils = spUtils;
        this.callBack = callBack;
    }


    @Override

    public void onDestroy() {

    }

    public void initView() {
        int screenBrightness = getScreenBrightness();
        boolean isOpenProtectSener = getOpenProtectSenerSatus();
        int regularRestTime = getRegularRestTime();
        if (callBack == null) return;
        callBack.setInitView(screenBrightness, isOpenProtectSener, regularRestTime);
    }

    //获取当前屏幕亮度
    private int getScreenBrightness() {
        return ScreenUtils.getScreenBrightness() - Config.Screen.SCREEN_BRIGHTNESS_MIN;
    }

    //获取当前护眼传感器状态
    private boolean getOpenProtectSenerSatus() {
        return false;
    }

    //获取当前定时休息的时间
    private int getRegularRestTime() {
        return spUtils.getInt((Config.PWDKey.REGULAR_REST_KEY));
    }

    public static interface CallBack {
        //初始化界面数据回调方法
        void setInitView(int screenBrightness, boolean isOpenProtectSener, int regularRestTime);
    }
}
