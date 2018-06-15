package com.boyue.boyuelauncher.wifimanager;

import android.app.Activity;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public abstract class WiFiManagerPersenter extends AbstractPresenter<WiFiManagerView> {

    //忽略网络
    public abstract void igonreNetwork(WifiModel data, int position);

    //手动添加网络
    public abstract void addNetwork(String SSID, String password, int wifiType);

    //广播注册
    public abstract void registerReceiver();

    //取消注册
    public abstract void unregisterReceiver();

    //wifi开关
    public abstract void setWifiEnabled(boolean isEnable);

    //初始化界面UI
    public abstract void checkWifiStatus();

    public abstract void connectWifi(WifiModel data, Activity activity);
}
