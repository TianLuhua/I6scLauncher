package com.boyue.boyuelauncher.wifimanager;

import android.net.wifi.WifiInfo;

import com.boyue.boyuelauncher.base.BaseView;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

import java.util.ArrayList;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public interface WiFiManagerView extends BaseView {

    //wifi关闭
    void closeWifi();

    //开始扫描
    void startScnner();

    //回调当前wifi扫描结果
    void scnnered(ArrayList<WifiModel> dataList);

    //回调当前连接的wifi
    void currentConnected(WifiInfo wifiInfo);

    //回调当前连接失败的结果
    void connectFail();

    //初始化Ui后，回调回来的状态，用于更新界面
    void setInitUI(boolean wifiEnable);


}
