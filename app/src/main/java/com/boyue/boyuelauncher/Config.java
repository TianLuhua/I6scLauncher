package com.boyue.boyuelauncher;

import android.Manifest;

/**
 * Created by Tianluhua on 2018/05/23
 */

public class Config {


    /**
     * 启动相关Activity的Action
     */
    public static class BoYueAction {
        public static final String ACTIVITY_ACTION_CLEANCACHE = "com.boyue.boyurlauncher.activity.action.cleancache";
        public static final String ACTIVITY_ACTION_WIFIMANAGER = "com.boyue.boyurlauncher.activity.action.wifimanager";
        public static final String ACTIVITY_ACTION_SETTINGS = "com.boyue.boyurlauncher.activity.action.settings";


    }

    /**
     * Handler相关的what值
     */
    public static class HandlerGlod {
        public static final int ACTIVITY_CLEANCACHE_START_CLEANCACHE = 0X00001;
        public static final int ACTIVITY_CLEANCACHE_END_CLEANCACHE = 0X00002;

    }

    /**
     * DialogFragment相关的tag
     */
    public static class DialogGlod {
        public static final String SETTING_REGULARREST_NOTICE = "setting_regularrest_time";
        public static final String SETTING_ENABLE_FCM_PASSWORD = "setting_enable_fcm_password";

    }

    /**
     * 系统涉及到的敏感权限申请
     */
    public static class Permission {
        public static final String LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    }


    /**
     * 挂载外设路径
     */
    public static class MountPath {
        public static final String USB_PATH = "/mnt/uhost";
        public static final String SD_PATH = "/mnt/sd-ext";

    }

    /**
     * 屏幕相关参数
     */
    public static class Screen {
        public static final int SCREEN_BRIGHTNESS_MIN = 125;
        public static final int SCREEN_BRIGHTNESS_MAX = 255;
    }

}
