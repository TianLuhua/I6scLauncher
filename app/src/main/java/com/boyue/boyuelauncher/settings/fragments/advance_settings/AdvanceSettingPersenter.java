package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import android.content.Context;
import android.content.Intent;

import com.boyue.boyuelauncher.base.AbstractPresenter;

public class AdvanceSettingPersenter extends AbstractPresenter<AdvanceSettingView> {


    private AdvanceSettingMode mode;
    private Context mcontext;

    public AdvanceSettingPersenter(Context mcontext) {
        this.mcontext = mcontext;
        this.mode = new AdvanceSettingMode(new AdvanceSettingMode.CallBack() {

            @Override
            public void setSystemParameter(String capacity, String deviceModle, String firmwareVersion,boolean hasUpdateVersion) {
                AdvanceSettingView view = getView();
                if (view == null) return;
                view.setSystemParameter(capacity, deviceModle, firmwareVersion,hasUpdateVersion);
            }
        });
    }

    public void getSystemParameter() {
        if (mode == null) return;
        mode.getSystemParameter();
    }

    public void startFactorySetting() {
        //恢复出厂设置
        mcontext.sendBroadcast(new Intent(
                "android.intent.action.MASTER_CLEAR"));
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mode != null)
            mode = null;
        if (mcontext != null)
            mcontext = null;
    }
}
