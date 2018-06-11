package com.boyue.boyuelauncher.settings;

import com.boyue.boyuelauncher.base.AbstractPresenter;

public abstract class SettingsPersenter extends AbstractPresenter<SettingsView> {

    abstract void getIndicatorItems();

    abstract boolean matchingPwd(String pwd);

    public abstract boolean hasEnablePWD();

}
