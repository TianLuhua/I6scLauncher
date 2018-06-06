package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import com.boyue.boyuelauncher.base.BaseView;

public interface AdvanceSettingView extends BaseView {

    void setSystemParameter(String capacity, String deviceModle, String firmwareVersion);
}
