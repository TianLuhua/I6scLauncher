package com.boyue.boyuelauncher;

import android.Manifest;

import com.boyue.boyuelauncher.widget.dialogfragment.Setting_Factory_SettingDialog;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

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
        public static final String ACTIVITY_ACTION_HHT_ZJYY = "com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_zjyy";
        public static final String ACTIVITY_ACTION_HHT_ZJXT = "com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_zjxt";
        public static final String ACTIVITY_ACTION_HHT_KLOK = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.HHT_klok";

        public static final String ACTIVITY_ACTION_HHT_YSPY = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy";
        public static final String ACTIVITY_ACTION_HHT_YSPY_HTCZ = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.htcz";
        public static final String ACTIVITY_ACTION_HHT_YSPY_SYZL = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.syzl";
        public static final String ACTIVITY_ACTION_HHT_YSPY_ZQYY = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.zqyy";

        public static final String ACTIVITY_ACTION_HHT_YZYX = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yzyx";


        public static final String ACTIVITY_REQUEST_SHUTDOWN = "com.android.internal.intent.action.REQUEST_SHUTDOWN";


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
        public static final String SETTING_FCM_CHANGEPASSWORD = "setting_fcm_changepassword";
        public static final String SETTING_FACTORY_SETTING = "Setting_Factory_Setting";


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

    public static class Number {
        public static final int Nuumber_0 = 0;
        public static final int Nuumber_1 = 1;
        public static final int Nuumber_2 = 2;
        public static final int Nuumber_3 = 3;
        public static final int Nuumber_4 = 4;
        public static final int Nuumber_5 = 5;
        public static final int Nuumber_6 = 6;
        public static final int Nuumber_7 = 7;
        public static final int Nuumber_8 = 8;
        public static final int Nuumber_9 = 9;

        public static final int PWD_LENGTH = 4;

    }

    public static class Settings {
        public static final int SCREEN_TIMEOUT_VALUE_NEVER = Integer.MAX_VALUE;
        public static final int SCREEN_TIMEOUT_VALUE_1M = 60000;
        public static final int SCREEN_TIMEOUT_VALUE_5M = SCREEN_TIMEOUT_VALUE_1M * 5;
        public static final int SCREEN_TIMEOUT_VALUE_10M = SCREEN_TIMEOUT_VALUE_1M * 10;
        public static final int SCREEN_TIMEOUT_VALUE_15M = SCREEN_TIMEOUT_VALUE_1M * 15;
        public static final int SCREEN_TIMEOUT_VALUE_30M = SCREEN_TIMEOUT_VALUE_1M * 30;
        public static final int SCREEN_TIMEOUT_VALUE_60M = SCREEN_TIMEOUT_VALUE_1M * 60;
        public static final int SCREEN_TIMEOUT_VALUE_120M = SCREEN_TIMEOUT_VALUE_1M * 12;
    }


}
