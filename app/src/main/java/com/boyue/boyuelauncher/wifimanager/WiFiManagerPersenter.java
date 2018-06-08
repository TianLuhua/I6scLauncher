package com.boyue.boyuelauncher.wifimanager;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public abstract class WiFiManagerPersenter extends AbstractPresenter<WiFiManagerView> {

    public abstract void igonreNetwork(WifiModel data);

    public abstract void addNetwork();

    public abstract void registerReceiver();

    public abstract void unregisterReceiver();

    public abstract void checkPermission();

    public abstract void setWifiEnabled(boolean isEnable);
}
