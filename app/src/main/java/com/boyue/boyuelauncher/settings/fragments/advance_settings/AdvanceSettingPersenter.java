package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import com.boyue.boyuelauncher.base.AbstractPresenter;

public class AdvanceSettingPersenter extends AbstractPresenter<AdvanceSettingView> {


    private AdvanceSettingMode mode;

    public AdvanceSettingPersenter() {
        this.mode = new AdvanceSettingMode(new AdvanceSettingMode.CallBack() {

            @Override
            public void setSystemParameter(String capacity, String deviceModle, String firmwareVersion) {
                AdvanceSettingView view = getView();
                if (view == null) return;
                view.setSystemParameter(capacity, deviceModle, firmwareVersion);
            }
        });
    }

    public void getSystemParameter() {
        if (mode == null) return;
        mode.getSystemParameter();
    }
}
