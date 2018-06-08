package com.boyue.boyuelauncher.wifimanager;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

import java.util.ArrayList;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public interface WiFiManagerMode extends BaseMode {

    //注册wifi相关广播
    void registerReceiver();

    //取消wifi相关广播
    void unregisterReceiver();

    //开始扫描
    void startScnner();


}
