package com.boyue.boyuelauncher.wifimanager;

import android.net.wifi.WifiInfo;

import com.boyue.boyuelauncher.base.BaseView;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

import java.util.ArrayList;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public interface WiFiManagerView extends BaseView {

    //wifi关闭
    void closeWifi();

    //开始扫描
    void startScnner();

    //回调当前wifi扫描结果
    void scnnered(ArrayList<WifiModel> dataList);

    //初始化Ui后，回调回来的状态，用于更新界面
    void getWifiStatus(boolean wifiEnable);

    //验证失败
    void verificationFail();

    //回调验证过程
    void verificationing(String status);

    //验证成功
    void verificationSuceess(WifiInfo wifiInfo);

    //附近没有可用WIFI
    void notAvailableWifi();

    //断开连接
    void disconnected();
}
