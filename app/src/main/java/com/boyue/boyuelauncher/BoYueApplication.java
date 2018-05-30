package com.boyue.boyuelauncher;

import android.app.Application;

import com.boyue.boyuelauncher.utils.Utils;

/**
 * Created by tianluhua on 2018/5/11.
 */

public class BoYueApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
