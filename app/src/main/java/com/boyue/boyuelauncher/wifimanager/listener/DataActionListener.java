package com.boyue.boyuelauncher.wifimanager.listener;

import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

/**
 * 数据列表操作监听
 * Created by Tianluhua on 2018/6/11.
 */
public interface DataActionListener {

    void onIgnore(WifiModel data, int position);
}
