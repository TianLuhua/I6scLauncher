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
        public static final String ACTIVITY_ACTION_HHT_ZJYY = "com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_zjyy";
        public static final String ACTIVITY_ACTION_HHT_ZJXT = "com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_zjxt";
        public static final String ACTIVITY_ACTION_HHT_KLOK = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.HHT_klok";
        public static final String ACTIVITY_ACTION_HHT_YSPY = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy";
        public static final String ACTIVITY_ACTION_HHT_YSPY_HTCZ = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.htcz";
        public static final String ACTIVITY_ACTION_HHT_YSPY_SYZL = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.syzl";
        public static final String ACTIVITY_ACTION_HHT_YSPY_ZQYY = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.zqyy";
        public static final String ACTIVITY_ACTION_HHT_YZYX = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yzyx";
        public static final String ACTIVITY_ACTION_HHT_LY_YWEG = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg";
        public static final String ACTIVITY_ACTION_FCMLOCKSCREEN = "com.boyue.boyuelauncher.FCMlockscreen";
        public static final String ACTIVITY_ACTION_PROTECTEYELOCKSCREEN = "com.boyue.boyuelauncher.ProtectEyeLockScreen";

        //自定义连接usb充电的Action
        public static final String COM_BOYUE_ACTION_POWER_CONNECTED = "com.boyue.action.action_power_connected";
        //自定义连接Ｕ盘挂载的Action
        public static final String COM_BOYUE_ACTION_USB_MOUNTED = "com.boyue.action.usb.mounted";
        //话筒插入和拔出广播
        public static final String ACTION_MIC_IN = "com.boyue.action.mac.in";//Intent.ACTION_MIC_IN
        public static final String ACTION_MIC_OUT = "com.boyue.action.mac.out";//Intent.ACTION_MIC_OUT


        //定时休息Action
        public static final String ONTIME_LOCKSCREEN_ACTION = "ontime_lockscreen_action";
        //定时锁定Action
        public static final String ONTIME_REST_ACTION = "ontime_rest_action";
        //定时关机Action
        public static final String ONTIME_SHUTDOWN_ACTION = "ontime_shutdown_action";

        //通知SystemSettingsService开启和关闭护眼传感器
        public static final String PROTECTSENSOR_ACTION_OPEN = "protectsensor_action_open";
        public static final String PROTECTSENSOR_ACTION_CLOSE = "protectsensor_action_close";

        //一段时间内没有操作的广播
        public static final String UNACTIVITY_FIFTEEN_MIN = "protectsensor_action_close";//Intent.UNACTIVITY_SIXTY_MIN
        public static final String UNACTIVITY_THIRTY_MIN = "protectsensor_action_close";//Intent.UNACTIVITY_THIRTY_MIN
        public static final String UNACTIVITY_SIXTY_MIN = "protectsensor_action_close";//Intent.UNACTIVITY_SIXTY_MIN

        //
    }

    /**
     * Handler相关的what值
     */
    public static class HandlerGlod {
        public static final int ACTIVITY_CLEANCACHE_START_CLEANCACHE = 0X00001;
        public static final int ACTIVITY_CLEANCACHE_END_CLEANCACHE = 0X00002;
        public static final int ACTIVITY_PROTECTEYELOCKSCREENACTIVITY_DELAY = 0X00003;

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
     * 系统涉及到的敏感权限申请,可能升级见到Android M
     */
    public static class Permission {
        public static final String LOCATION_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
        //WiFi权限请求code
        public static final int REQUEST_CODE = 0X11000;
    }


    /**
     * 挂载外设路径
     */
    public static class MountPath {
        public static final String USB_PATH = "/mnt/usbhost1";
        public static final String SD_PATH = "/mnt/extsd";
    }

    /**
     * 屏幕相关参数
     */
    public static class Screen {
        public static final int SCREEN_BRIGHTNESS_MIN = 125;
        public static final int SCREEN_BRIGHTNESS_MAX = 255;
    }

    /**
     * 键盘数字
     */
    public static class Number {
        public static final int PWD_LENGTH = 4;
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
    }

    /**
     * 系统时间置相关
     */
    public static class Settings {
        public static final int VALUE_NEVER = Integer.MAX_VALUE;
        //        public static final int VALUE_1M = 60000;
        public static final int VALUE_1M = 1000;
        public static final int VALUE_5M = VALUE_1M * 5;
        public static final int VALUE_10M = VALUE_1M * 10;
        public static final int VALUE_15M = VALUE_1M * 15;
        public static final int VALUE_20M = VALUE_1M * 20;
        public static final int VALUE_30M = VALUE_1M * 30;
        public static final int VALUE_40M = VALUE_1M * 40;
        public static final int VALUE_60M = VALUE_1M * 60;
        public static final int VALUE_120M = VALUE_1M * 12;
    }

    /**
     * 系统密码相关
     */
    public static class PassWordKey {
        //系统SharedPreferences 名称
        public static final String SPNMAE = "com_boyue_boyuelauncher";
        //默认密码
        public static final String DEFAULT_BOOTPWD = "0000";

        //是否启用密码 key
        public static final String PWD_IS_ENABLE = "pwd_is_enable";
        //存储开机密码 key
        public static final String BOOT_PWD_NAME = "boot_pwd";
        //存储防沉迷密码 key
        public static final String FCM_PWD_NAME = "fcm_pwd_enable";

        //用于保存定时休息的时间 key
        public static final String REGULAR_REST_KEY = "regular_rest_key";
        //用于保存定时锁定的时间 key
        public static final String TIMING_LOCKING_KEY = "timing_locking_key";
        //用于保存定时关机的时间 key
        public static final String ONTIME_SHUTDOWN_KEY = "ontime_shutdown_key";

        //用于保存护眼传感器的状态
        public static final String PROTECT_EYE_SENSOR_ENABLE_KEY = "protect_eye_sensor_enable_key";
    }

    //Launcher中需要用到的资源
    public static class BoYueLauncherResource {
        //火火兔学堂
        public static final String HHT_XT_ZJYY = "";
        public static final String HHT_XT_ZJXT = "";
        public static final String HHT_XT_MATH_LOGIC = "";
        public static final String HHT_XT_TRANDITIONAL_GX = "";
        public static final String HHT_XT_DY_INTELLIGENCE = "";
        public static final String HHT_XT_SAFE_KNOWLEDGE = "";

        //火火兔AR
        public static final String HHT_AR_ENGLISH = "";
        public static final String HHT_AR_MATH = "";
        public static final String HHT_AR_LAND_ANIMAL = "";
        public static final String HHT_AR_OCEAN_ANIMAL = "";
        public static final String HHT_AR_DINOSAUR = "";
        public static final String HHT_AR_3D_MAGIC = "";

        //火火兔乐园
        public static final String HHT_LY_KLOK = "";
        public static final String HHT_LY_ENGLISH_SING = "";
        public static final String HHT_LY_KING_STORY = "";
        public static final String HHT_LY_ART_TRAIN = "";
        public static final String HHT_LY_YZ_GAME = "";
        public static final String HHT_LY_BABY_CAMERA = "";

        //在线宝箱
        public static final String HHT_ZXBX_HHT_SCHOOL = "";
        public static final String HHT_ZXBX_AIQIYI_CHILDNER = "";
        public static final String HHT_ZXBX_BABY_BUS = "";
        public static final String HHT_ZXBX_MEDIA_CHAT = "";
        public static final String HHT_ZXBX_WECHAT = "";
        public static final String HHT_ZXBX_MY_APPLICATION = "";

    }


}
