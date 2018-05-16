package com.boyue.boyuelauncher;

import android.Manifest;

/**
 * Created by Tianluhua on 2017/10/16
 */

public class Config {


    public static class BoYueAction {
        public static final String ACTIVITY_ACTION_CLEANCACHE = "com.boyue.boyurlauncher.activity.action.cleancache";
        public static final String ACTIVITY_ACTION_WIFIMANAGER = "com.boyue.boyurlauncher.activity.action.wifimanager";

    }

    public static class HandlerGlod {
        public static final int ACTIVITY_CLEANCACHE_START_CLEANCACHE = 0X00001;
        public static final int ACTIVITY_CLEANCACHE_END_CLEANCACHE = 0X00002;

    }

    public static class Permission {
        public static final String LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    }


}
