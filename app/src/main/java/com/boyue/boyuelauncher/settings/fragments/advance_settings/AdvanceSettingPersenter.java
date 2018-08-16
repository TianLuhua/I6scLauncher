package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LogUtils;

import static com.boyue.boyuelauncher.Config.PassWordKey.REQUST_SYSTEM_CACULATER_PASSWORD;
import static com.boyue.boyuelauncher.Config.PassWordKey.REQUST_SYSTEM_SETITNGS_PASSWORD;


public class AdvanceSettingPersenter extends AbstractPresenter<AdvanceSettingView> {


    private AdvanceSettingMode mode;
    private Context mcontext;

    public AdvanceSettingPersenter(Context mcontext) {
        this.mcontext = mcontext;
        this.mode = new AdvanceSettingMode(new AdvanceSettingMode.CallBack() {

            @Override
            public void setSystemParameter(String capacity, String deviceModle, String firmwareVersion, boolean hasUpdateVersion) {
                AdvanceSettingView view = getView();
                if (view == null) return;
                view.setSystemParameter(capacity, deviceModle, firmwareVersion, hasUpdateVersion);
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

    //启动系统设置密码配对，初始密码：0001
    public boolean matchRequstSystemSettingPassword(String pwd) {
        boolean result = false;
        if (REQUST_SYSTEM_SETITNGS_PASSWORD.equals(pwd))
            result = true;
        return result;
    }


    //启动系统原生设置
    public void startSystemSettings() {
        LogUtils.e("tlh", "startSystemSettings");
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mcontext.startActivity(intent);
    }


    //启动计算器密码配对，初始密码：0002
    public boolean matchRequstSystemCaculaterPassword(String pwd) {
        boolean result = false;
        if (REQUST_SYSTEM_CACULATER_PASSWORD.equals(pwd))
            result = true;
        return result;
    }

    public void startSystemCaculater() {
        LogUtils.e("tlh", "startSystemCaculater");
        Intent intent = new Intent();
        intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mcontext.startActivity(intent);
    }

}
