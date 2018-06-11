package com.boyue.boyuelauncher.wifimanager;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public abstract class WiFiManagerPersenter extends AbstractPresenter<WiFiManagerView> {

    public abstract void igonreNetwork(WifiModel data);

    public abstract void addNetwork();

    //广播注册
    public abstract void registerReceiver();

    //取消注册
    public abstract void unregisterReceiver();

    //wifi开关
    public abstract void setWifiEnabled(boolean isEnable);

    //初始化界面UI
    public abstract void initUI();
}
