package com.boyue.boyuelauncher.wifimanager;

import android.net.wifi.WifiInfo;

import com.boyue.boyuelauncher.base.BaseView;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

import java.util.ArrayList;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public interface WiFiManagerView extends BaseView {
    //回调当前wifi是否可用
    void wifiDisable(boolean disAble);

    //回调当前wifi正在扫描状态
    void scnnering();

    //回调当前wifi扫描结果
    void scnnered(ArrayList<WifiModel> dataList);

    //回调当前连接的wifi
    void currentConnected(WifiInfo wifiInfo);

    //回调当前连接失败的结果
    void connectFail();

}
