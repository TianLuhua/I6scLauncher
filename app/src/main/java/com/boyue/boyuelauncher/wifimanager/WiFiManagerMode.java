package com.boyue.boyuelauncher.wifimanager;

import com.boyue.boyuelauncher.base.BaseMode;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public interface WiFiManagerMode extends BaseMode {

    //注册wifi相关广播
    void registerReceiver();

    //取消wifi相关广播
    void unregisterReceiver();

    //开始扫描
    void startScnner();


}
