package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import com.boyue.boyuelauncher.base.BaseView;

public interface ProtectEyeView extends BaseView {

    //初始化界面数据回调方法
    void setInitView(int screenBrightness, boolean isOpenProtectSener, int regularRestTime);
}
