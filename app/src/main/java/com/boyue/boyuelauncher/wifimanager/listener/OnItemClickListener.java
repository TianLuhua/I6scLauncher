package com.boyue.boyuelauncher.wifimanager.listener;

import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public interface OnItemClickListener {

    void onItemClick(WifiModel data, int position);

    void onItemLongClick(int position);
}

