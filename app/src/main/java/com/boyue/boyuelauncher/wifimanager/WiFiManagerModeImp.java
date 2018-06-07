package com.boyue.boyuelauncher.wifimanager;

import android.content.Context;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class WiFiManagerModeImp implements WiFiManagerMode {


    private Context mContext;
    private Callback callback;

    public WiFiManagerModeImp(Context mContext, Callback callback) {
        this.mContext = mContext;
        this.callback = callback;
    }

    @Override
    public void onDestroy() {

    }


    public static interface Callback{

    }

}
