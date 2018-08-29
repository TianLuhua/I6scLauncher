package com.boyue.boyuelauncher;

import android.Manifest;

/**
 * Created by Tianluhua on 2018/05/23
 */

public class Config {


    public static class BoYueUrl {
        //意见反馈地址。
        public static final String FEEDBACK_URL = "https://cloud.alilo.com.cn/baby/api/feedback";
    }

    /**
     * 启动相关Activity的Action
     */
    public static class BoYueAction {
        public static final String ACTIVITY_ACTION_CLEANCACHE = "com.boyue.boyuelauncher.activity.action.cleancache";

        //这个action不能随便修改，第三方的apk也要使用可能。
        public static final String ACTIVITY_ACTION_WIFIMANAGER = "com.boyue.boyuelauncher.activity.action.wifimanager";
        public static final String ACTIVITY_ACTION_SETTINGS = "com.boyue.boyuelauncher.activity.action.settings";
        public static final String ACTIVITY_ACTION_HHT_ZJYY = "com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_zjyy";
        public static final String ACTIVITY_ACTION_HHT_ZJXT = "com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_zjxt";
        public static final String ACTIVITY_ACTION_HHT_KLOK = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.HHT_klok";
        public static final String ACTIVITY_ACTION_HHT_YSPY = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy";
        public static final String ACTIVITY_ACTION_HHT_YSPY_HTCZ = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.htcz";
        public static final String ACTIVITY_ACTION_HHT_YSPY_SYZL = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.syzl";
        public static final String ACTIVITY_ACTION_HHT_YSPY_ZQYY = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.zqyy";
        public static final String ACTIVITY_ACTION_HHT_YZYX = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yzyx";
        public static final String ACTIVITY_ACTION_FCMLOCKSCREEN = "com.boyue.boyuelauncher.FCMlockscreen";
        public static final String ACTIVITY_ACTION_PROTECTEYELOCKSCREEN = "com.boyue.boyuelauncher.ProtectEyeLockScreen";
        public static final String ACTIVITY_ACTION_KLOK = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.activity";
        //固件升级界面
        public static final String ACTIVITY_SYSTEM_UPDATE = "com.boyue.boyuelauncher.settings.fragments.advance_settings.system_update";

        //在线卡通
        public static final String ACTIVITY_ACTION_ZXBX_CARTOON = "com.boyue.boyuelauncher.main.fragments.hht_bx_fragment.cartoon";

        //自定义连接usb充电的Action
        public static final String COM_BOYUE_ACTION_POWER_CONNECTED = "com.boyue.action.action_power_connected";
        //自定义连接Ｕ盘挂载的Action
        public static final String COM_BOYUE_ACTION_USB_MOUNTED = "com.boyue.action.usb.mounted";
        //话筒插入和拔出广播
        public static final String ACTION_MIC_IN = "android.intent.action.MIC_IN";//Intent.ACTION_MIC_IN
        public static final String ACTION_MIC_OUT = "android.intent.action.MIC_OUT";//Intent.ACTION_MIC_OUT

        //耳灯开关广播
        public static final String COLOR_EAR_OFF = "com.boyue.color_ear.off";
        public static final String COLOR_EAR_ON = "com.boyue.color_ear.on";

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
        public static final String UNACTIVITY_FIFTEEN_MIN = "android.intent.action.IDLE_FIFTEEN_MIN";//Intent.UNACTIVITY_SIXTY_MIN
        public static final String UNACTIVITY_THIRTY_MIN = "android.intent.action.IDLE_THIRTY_MIN";//Intent.UNACTIVITY_THIRTY_MIN
        public static final String UNACTIVITY_SIXTY_MIN = "android.intent.action.IDLE_SIXTY_MIN";//Intent.UNACTIVITY_SIXTY_MIN

        //播放器Action
        public static final String BOOYUE_MEDIAPLAYER_VIDEO_ACTION = "com.booyue.android.mediaplayer.video";

        //控制系统音量相关
        public static final String BOOYUE_STREAMMAXVOLUME_ACTION = "com.booyue.android.stream.max";
        public static final String BOOYUE_STREAMMAXVOLUME_KEY = "maxVolume";

        //用于保存开机音量的key
        public static final String BOOT_VOLUME = "persist.sys.bootvol";

        //用于启动播放背景音乐的Action
        public static final String PLAYAUDIO = "com.boyue.boyuelauncher.service.playaudio";

    }

    /**
     * Handler相关的what值
     */
    public static class HandlerGlod {

        //播放背景音乐所用到的flag
        public static final int HHT_XT = 0X00000;//火火兔学堂
        public static final int HHT_AR = 0X00001;//火火兔AR
        public static final int HHT_LY = 0X00002; //火火兔乐园
        public static final int HHT_ZXBX = 0X00003;//在线宝箱
        public static final int HHT_PROTECT_EYE = 0X00004;//护眼


        public static final int ACTIVITY_CLEANCACHE_START_CLEANCACHE = 0X00005;
        public static final int ACTIVITY_CLEANCACHE_END_CLEANCACHE = 0X00006;
        public static final int ACTIVITY_PROTECTEYELOCKSCREENACTIVITY_DELAY = 0X00007;
    }

    /**
     * DialogFragment相关的tag
     */
    public static class DialogGlod {
        public static final String SETTING_REGULARREST_NOTICE = "setting_regularrest_time";
        public static final String SETTING_ENABLE_FCM_PASSWORD = "setting_enable_fcm_password";
        public static final String SETTING_FCM_CHANGEPASSWORD = "setting_fcm_changepassword";
        public static final String SETTING_FACTORY_SETTING = "Setting_Factory_Setting";
        public static final String REQUST_SYSTEM_SETTINGS = "requst_system_settings";
    }

    /**
     * 系统涉及到的敏感权限申请,可能升级到Android M
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
     * 屏幕亮度相关参数
     */
    public static class Screen {
        public static final int SCREEN_BRIGHTNESS_MIN = 125;
        public static final int SCREEN_BRIGHTNESS_MAX = 255;
        ////默认激活护眼的屏幕亮度为20
        public static final int DEFAULT_BRIGHTNESS = 20;

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
        public static final int VALUE_1M = 60000;
        //                public static final int VALUE_1M = 1000;
        public static final int VALUE_5M = VALUE_1M * 5;
        public static final int VALUE_10M = VALUE_1M * 10;
        public static final int VALUE_15M = VALUE_1M * 15;
        public static final int VALUE_20M = VALUE_1M * 20;
        public static final int VALUE_30M = VALUE_1M * 30;
        public static final int VALUE_40M = VALUE_1M * 40;
        public static final int VALUE_60M = VALUE_1M * 60;
        public static final int VALUE_120M = VALUE_1M * 120;
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
        //用于保存自动关机的时间 key
        public static final String AUTO_SHUTDOWN_KEY = "auto_shutdown_key";
        //用于保存定时锁定的时间 key
        public static final String TIMING_LOCKING_KEY = "timing_locking_key";
        //用于保存定时关机的时间 key
        public static final String ONTIME_SHUTDOWN_KEY = "ontime_shutdown_key";

        //用于保存护眼传感器的状态
        public static final String PROTECT_EYE_SENSOR_ENABLE_KEY = "protect_eye_sensor_enable_key";

        //用于保存耳灯
        public static final String DEFAULT_LED_KEY = "default_led_key";


        //用于保存启动的：火火兔乐园---卡拉ok 加载的是哪个页面的数据
        public static final String HHTLY_KLOK_PAGE_KEY = "page";

        //用于保存 主界面切换时候，播放对应音频的key
        public static final String HHTLY_AUDIO_KEY = "audio_item";

        //重置密码的点击次数
        public static int RESET_PASSWORD_CLICK_NUMBER = 8;
        //连续点击，调出系统Settings、计算器
        public static int REQUST_SYSTEM_SETITNGS_CLICK_NUMBER = 8;
        public static String REQUST_SYSTEM_SETITNGS_PASSWORD = "0001";
        public static String REQUST_SYSTEM_CACULATER_PASSWORD = "0002";

    }

    //Launcher中需要用到的资源
    public static class BoYueLauncherResource {
        /*----------------------------------小学课堂-----------------------------------------------*/
        public static final String HHT_XXKT_PACKAGE = "com.wyt.hht7.xx";
        public static final String HHT_XXKT_LAUNCHER = "com.wyt.hengke.huohuotu.MainActivity";

        /*----------------------------------火火兔学堂-----------------------------------------------*/
        //早教英语 ----邦尼英语
        public static final String HHT_XT_ZJYY_BANGNI_ROOT_PATH = "/system/videos/xuetang/zaojiaoyingyu/bangni/";
        public static final String HHT_XT_ZJYY_BANGNI_01 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a0Hello_how_are_you" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_02 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a1Where_is_Bunny" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_03 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a2Boy_and_girl" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_04 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a3Stand_up_sit_down" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_05 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a4Wash_your_hands" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_06 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a5Nice_food" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_07 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a6I_see" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_08 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a7Whats_this" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_09 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a8A_candy_for_you" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_10 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "a9One_potato" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_11 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b0Happy" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_12 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b1Shake" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_13 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b2Which_one_do_you_like" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_14 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b3Who_can_do_it" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_15 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b4I_want" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_16 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b5Traffic_lights" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_17 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b6How_do_you_feel" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_18 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b7Mid_Autumn_Day" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_19 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b8Taste" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_20 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "b9What_are_you_wearing" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_21 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c0I_see_you" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_22 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c1Music_man" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_23 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c2Rain" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_24 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c3Merry_Christmas" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_25 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c4What_shape_is_it" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_26 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c5Numbers" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_27 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c6Fly_a_kite" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_28 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c7Is_it_yours" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_29 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c8Three_bears" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_30 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "c9At_home" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_31 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d0Its_too_hot" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_32 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d1Who_is_coming" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_33 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d2A_busy_day" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_34 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d3Little_rabbits" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_35 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d4Can_i_help_you" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_36 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d5Three_little_pigs" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_37 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d6I_am_a_bus" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_38 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d7Bingo" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_39 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d8Five_little_monkeys" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_40 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "d9Chinese_new_year" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_41 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e0Fun_to_play" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_42 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e1Rabbit_and_tortoise" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_43 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e2What_is_your_favorite_sport" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_44 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e3Bears_teeth" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_45 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e4Happy_mothers_day" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_46 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e5A_big_radish_in_the_hole" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_47 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e6The_muffin_man" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BANGNI_48 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "e7Goodbye" + MediaFromart.MP4;
        //早教英语 ----多纳英语
        public static final String HHT_XT_ZJYY_DUONA_ROOT_PATH = "/system/videos/xuetang/zaojiaoyingyu/duona/";
        public static final String HHT_XT_ZJYY_DUONA_01 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a0zaoshanghao" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_02 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a1woshi" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_03 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a2meiweishuiguo" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_04 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a3rangwomenshuyishu" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_05 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a4shitoujiandaobu" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_06 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a5zhuomicang" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_07 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a6chuanshangyifu" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_08 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a7shangrikuaile" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_09 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a8wotule" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_10 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "a9moxojiamshenmeyanse" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_11 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "b0qudongwuyuan" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_DUONA_12 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "b1keaidedongwu" + MediaFromart.MP4;
        //早教英语 ----宝狄英语
        public static final String HHT_XT_ZJYY_BAODI_ROOT_PATH = "/system/videos/xuetang/zaojiaoyingyu/baodi/";
        public static final String HHT_XT_ZJYY_BAODI_01 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a0Bodhis_ABC" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_02 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a1A_Day_at_Cafe_Sambolo_1" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_03 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a2All_These_Shapes1" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_04 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a3America_Song" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_05 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a4Around_My_Rooms" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_06 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a5Asia_Song" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_07 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a6Better_Weather" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_08 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a7Body_Bop" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_09 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a8Check_out_my_toy" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_10 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "a9City_Life_City_Lights" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_11 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b0Clean_and_Green" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_12 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b1Colourful_Party" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_13 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b2Count_on_You" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_14 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b3Count_with_Bodhi" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_15 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b4Day_and_Night" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_16 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b5Dream_Team" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_17 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b6Dress_You_Up" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_18 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b7Everyday_Heroes" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_19 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b8Face_It" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_20 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "b9Family" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_21 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c0Food" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_22 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c1Friends_Forever" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_23 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c2Full_Circle" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_24 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c3Fun_Family_Day" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_25 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c4Future_of_the_World" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_26 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c5Good_Food_Good_for_You" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_27 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c6I_Can_Do_It" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_28 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c7I_Love_Food" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_29 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c8Imagine" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_30 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "c9In_Our_Neighbourhood" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_31 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d0Its_a_New_Day" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_32 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d1Lets_Get_Fit" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_33 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d2Lets_Go_to_School" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_34 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d3Lets_Have_a_Good_Time" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_35 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d4Lets_Take_It_from_123" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_36 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d5Lets_play_ball" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_37 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d6Make_This_the_Best_Day" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_38 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d7Meet_Our_Families" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_39 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d8Mix_and_Match" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_40 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "d9Move_Our_Bodies" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_41 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e0My_Heart" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_42 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e1My_Home" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_43 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e2No_Place_Like_Home" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_44 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e3Pat_Your_Pet" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_45 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e4Pet_Sounds" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_46 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e5Push_Through_Dont_Stop" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_47 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e6Rainbow_Shining" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_48 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e7Reap_What_You_Sow" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_49 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e8School_Days" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_50 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "e9See_you_later" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_51 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f0Sharing_is_Caring" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_52 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f1Sing_Along_with_Bodhi_and_Friends" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_53 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f2So_Much_to_Do" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_54 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f3Thats_What_We_Like" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_55 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f4The_Face_Song" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_56 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f5The_Greetings_Song" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_57 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f6The_Hello_Song" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_58 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f7The_Name_of_the_Game" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_59 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f8The_Sounds_of_the_Farm" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_60 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "f9The_time_is_now" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_61 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g0Things_That_Go" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_62 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g1Together" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_63 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g2Toys_toys_everywhere" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_64 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g3We_Are_on_the_Go" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_65 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g4We_Can_Be_Anything" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_66 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g5We_ll_Be_Your_Shelter" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_67 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g6Weather_Ready" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_68 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g7Welcome_to_Our_World" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_69 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g8Welcome_to_the_Farm" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_70 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "g9When_I_Grow_Up" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_71 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "h0With_My_Eyes" + MediaFromart.MP4;
        public static final String HHT_XT_ZJYY_BAODI_72 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "h1Work_Hard_Get_Smart" + MediaFromart.MP4;

        //早教学堂
        public static final String HHT_XT_ZJXT_300WORDS_PACKAGE = "air.RabbitRead";//air.RabbitRead/.AppEntry
        public static final String HHT_XT_ZJXT_300WORDS_LAUNCHER = "air.RabbitRead.AppEntry";
        public static final String HHT_XT_ZJXT_PINYIN_PACKAGE = "air.RabbitAlpha";//air.RabbitAlpha/.AppEntry
        public static final String HHT_XT_ZJXT_PINYIN_LAUNCHER = "air.RabbitAlpha.AppEntry";
        public static final String HHT_XT_ZJXT_ENGLISH_PACKAGE = "air.RabbitEng";// air.RabbitEng/.AppEntry
        public static final String HHT_XT_ZJXT_ENGLISH_LAUNCHER = "air.RabbitEng.AppEntry";
        public static final String HHT_XT_ZJXT_MATH_PACKAGE = "air.RabbitMath";//air.RabbitMath/.AppEntry
        public static final String HHT_XT_ZJXT_MATH_PACKAGE_LAUNCHER = "air.RabbitMath.AppEntry";
        public static final String HHT_XT_ZJXT_KONWLEGE_PACKAGE = "air.RabbitKnow";//air.RabbitKnow/.AppEntry
        public static final String HHT_XT_ZJXT_KONWLEGE_LAUNCHER = "air.RabbitKnow.AppEntry";
        public static final String HHT_XT_ZJXT_POETRY_PACKAGE = "air.RabbitPoem";//air.RabbitPoem/.AppEntry
        public static final String HHT_XT_ZJXT_POETRY_LAUNCHER = "air.RabbitPoem.AppEntry";
        public static final String HHT_XT_ZJXT_HEALTH_PACKAGE = "air.RabbitHealth";//air.RabbitHealth/.AppEntry
        public static final String HHT_XT_ZJXT_HEALTH_LAUNCHER = "air.RabbitHealth.AppEntry";


        //火火兔学堂：数学逻辑   传统国学    多元智能   安全知识
        public static final String HHT_XT_MATH_LOGIC = "数学逻辑";
        public static final String HHT_XT_TRANDITIONAL_GX = "传统国学";
        public static final String HHT_XT_DY_INTELLIGENCE = "多元智能";
        public static final String HHT_XT_SAFE_KNOWLEDGE = "安全知识";
        /*----------------------------------火火兔学堂-----------------------------------------------*/
        //火火兔AR
        public static final String HHT_AR_ENGLISH = "com.ti.letter";//com.ti.letter/.APPBridge
        public static final String HHT_AR_MATH = "com.xwb.shuzi";// com.xwb.shuzi/.APPBridge
        public static final String HHT_AR_LAND_ANIMAL = "com.o2design.animal";
        public static final String HHT_AR_OCEAN_ANIMAL = "com.o2design.animalofocean";
        public static final String HHT_AR_DINOSAUR = "com.o2design.Dinosaurs";
        public static final String HHT_AR_3D_MAGIC = "com.simon.MH3D";


        /*----------------------------------火火兔乐园-----------------------------------------------*/
        public static final String HHT_LY_KING_STORY = "故事王国";
        public static final String HHT_LY_BABY_CAMERA = "com.android.camera2";// com.android.camera2/com.android.camera.CameraLauncher

        //火火兔乐园---- 卡拉ok ---经典儿歌
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH = "/system/videos/leyuan/kalaOK/jingdian/";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_01 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a0fenshuajiang03" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_02 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a1yifenqian09" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_03 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a2woniuyuhuangliniao07" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_04 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a3lingerxiangdingdang04" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_05 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a4maliyouzhixiaoyanggao19" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_06 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a5liangzhilaohu10" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_07 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a6shishangzhiyoumamahao05" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_08 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a7shuyazi06" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_09 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a8aiwojiubaobaowo18" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_10 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "a9baluobo15" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_11 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b0chuntianzainali01" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_12 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b1lanjinling02" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_13 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b2shijianzaishuohua17" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_14 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b3woyouyigejia13" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_15 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b4xiaolongren12" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_16 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b5xiaoxingxing08" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_17 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b6xiaoyanzi11" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_18 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b7zhaopengyou14" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_19 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b8zhongtaiyang20" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_JDEG_ITEM_20 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "b9zhuoniqiu16" + MediaFromart.MKV;

        //火火兔乐园---- 卡拉ok ---原创儿歌
        public static final String HHT_LY_KALAOK_TTMTV_ROOT_PATH = "/system/videos/leyuan/kalaOK/yuanchuang/";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_01 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a0daxiongmao01" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_02 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a1chunyu02" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_03 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a2chaojiyingxiong03" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_04 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a3zhuqingting04" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_05 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a4shangyuanzhuzhici05" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_06 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a5shuyazi06" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_07 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a6yinghuoweiguang07" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_08 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a7bahe08" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_09 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a8hello09" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_10 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "a9gongfuxiaozi10" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_11 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b0xunyinzhibuyu11" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_12 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b1xiaoxiaobinggan12" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_13 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b2xiaohuajia13" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_14 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b3shancunyonghuai14" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_15 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b4gongxifacai15" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_16 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b5mingnong16" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_17 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b6jinglige17" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_18 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b7chuntianzainali18" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_19 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b8zhishuge19" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_20 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "b9aixiliangshi20" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_21 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "c0hua21" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_22 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "c1qiuyinong22" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_23 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "c2meilitianye23" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_24 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "c3laoshukaihui24" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_25 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "c4wuyixiang25" + MediaFromart.MKV;
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_26 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "c5daguonian26" + MediaFromart.MKV;

        //火火兔乐园---- 卡拉ok ----酷我K歌
        public static final String HHT_LY_KALAOK_KUWOKGE_PACKAGE = "cn.kuwo.sing.tv";//cn.kuwo.sing.tv/.activity.WelcomeActivity

        //火火兔乐园---- 卡拉ok ----火火兔唱古诗
        public static final String HHT_LY_KALAOK_HHTCGS_ROOT_PATH = "/system/videos/leyuan/kalaOK/hhtcgs/";
        public static final String HHT_LY_KALAOK_HHTCGS_01 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a0ye01" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_02 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a1jys02" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_03 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a2yr03" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_04 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a3lzc04" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_05 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a4cs05" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_06 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a5bdd06" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_07 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a6glyx07" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_08 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a7fdgyclb08" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_09 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a8xyzby09" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_10 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "a9xc10" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_11 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b0sx11" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_12 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b1jhzs12" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_13 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b2zfbdc13" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_14 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b3zccsb14" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_15 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b4cyxy15" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_16 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b5cx16" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_17 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b6wlspb17" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_18 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b7fqyb18" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_19 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b8jpdbxh19" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_20 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "b9jx20" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_21 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "c0yzy21" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_22 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "c1dgql22" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_23 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "c2jj23" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_HHTCGS_24 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "c3cgx24" + MediaFromart.MP4;

        //火火兔乐园---- 卡拉ok ---英文儿歌
        public static final String HHT_LY_KALAOK_YWEG_ROOT_PATH = "/system/videos/leyuan/yingwenerge/";
        public static final String HHT_LY_KALAOK_YWEG_01 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a0Green_and_Speckled_Frogs_song" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_02 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a1Little_Pumpkins_Sitting_On_aGate" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_03 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a2Ants_go_marching_one_by_one_song" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_04 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a3Ballet_Song_for_Kids_Down_at_the_Ballet" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_05 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a4Clap_Your_Hands_Song_for_Kids" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_06 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a5Count_to_100_Song_for_Kindergarten" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_07 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a6Dinosaur_Stomp_Song_for_Kids_Party" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_08 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a7Five_Little_Bunnies_Easter_Bunny_Song" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_09 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a8Five_Little_Monkeys_Jumping_on_the_Bed" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_10 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "a9Freeze_Dance_for_Kids_Party_Music" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_11 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b0Freeze_Dance_Game_North_Pole_Christmas" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_12 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b1Funky_Monkey_Dance_Song_for_Kids_1" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_13 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b2Halloween_songs5_Little_Pumpkins_Sitting" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_14 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b3Im_a_Little_Snowman_Song_for_Children" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_15 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b4Skeleton_Dance_Shake_Demo_Halloween" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_16 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b5Ten_in_the_Bed_song_for_children" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_17 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b6Tooty_Ta_Dr_Jean_Tooty_Ta_with_Lyrics" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_18 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b7Walking_Walking_Song_Hop_Hop" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_19 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b8Wiggle_It_Wiggle_Dance_Wiggles_Songs" + MediaFromart.MP4;
        public static final String HHT_LY_KALAOK_YWEG_20 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "b9Winter_Hokey_Pokey_Song_for_Kids" + MediaFromart.MP4;

        //火火兔乐园---- 艺术培养 ---智趣音乐
        /**
         * 宝宝认乐器 air.BabyInstrument/.AppEntry
         */
        public static final String HHT_LY_YSPY_ZQYY_01 = "air.BabyInstrument";
        /**
         * 宝宝爱伴奏 air.BabyAccompaniment/.AppEntry
         */
        public static final String HHT_LY_YSPY_ZQYY_02 = "air.BabyAccompaniment";
        /**
         * 乐器猜猜乐 air.BabyGuessInstru/.AppEntry
         */
        public static final String HHT_LY_YSPY_ZQYY_03 = "air.BabyGuessInstru";
        /**
         * 快乐弹弹弹  air.BabyPiano/.AppEntry
         */
        public static final String HHT_LY_YSPY_ZQYY_04 = "air.BabyPiano";
        /**
         * 跟我学乐谱 air.BabyLearnMusic/.AppEntry
         */
        public static final String HHT_LY_YSPY_ZQYY_05 = "air.BabyLearnMusic";
        /**
         * 小小钢琴家 air.BabyPianist/.AppEntry
         */
        public static final String HHT_LY_YSPY_ZQYY_06 = "air.BabyPianist";
        /**
         * 宝宝猜儿歌  air.BabyGuessSong/.AppEntry
         */
        public static final String HHT_LY_YSPY_ZQYY_07 = "air.BabyGuessSong";


        //火火兔乐园---- 艺术培养 ---画图创作
        /**
         * 宝宝学画画  air.BabyDraw/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_01 = "air.BabyDraw";
        /**
         * 场景涂色 air.BabySceneDraw/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_02 = "air.BabySceneDraw";
        /**
         * 飞机设计师 air.BabyPlane/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_03 = "air.BabyPlane";
        /**
         * 火火兔爱装扮 air.BabyDress/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_04 = "air.BabyDress";
        /**
         * 趣味涂涂乐 air.BabyFunnyDraw/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_05 = "air.BabyFunnyDraw";
        /**
         * 我的爸爸妈妈  air.BabyFamily/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_06 = "air.BabyFamily";
        /**
         * 童话天地  air.BabyDrawParty/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_07 = "air.BabyDrawParty";
        /**
         * 我画你猜    air.DrawAndGuess/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_08 = "air.DrawAndGuess";
        /**
         * 美味蛋糕  air.BabyMakeCake/.AppEntry
         */
        public static final String HHT_LY_YSPY_HTCZ_09 = "air.BabyMakeCake";


        //火火兔乐园---- 艺术培养 ---艺术之旅
        public static final String HHT_LY_YSPY_YSZL_ROOT_PATH = "/system/videos/leyuan/yishupeiyang/yishuzhilv/";
        public static final String HHT_LY_YSPY_YSZL_01 = HHT_LY_YSPY_YSZL_ROOT_PATH + "a0sjmh1" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_YSZL_02 = HHT_LY_YSPY_YSZL_ROOT_PATH + "a1sjmh2" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_YSZL_03 = HHT_LY_YSPY_YSZL_ROOT_PATH + "a2sjmh3" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_YSZL_04 = HHT_LY_YSPY_YSZL_ROOT_PATH + "a3sjmh4" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_YSZL_05 = HHT_LY_YSPY_YSZL_ROOT_PATH + "a4sjmh5" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_YSZL_06 = HHT_LY_YSPY_YSZL_ROOT_PATH + "a5zmds" + MediaFromart.MP4;

        //火火兔乐园---- 艺术培养 ---小小画家
        public static final String HHT_LY_YSPY_XXHJ_ROOT_PATH = "/system/videos/leyuan/yishupeiyang/xiaoxiaohuajia/";
        public static final String HHT_LY_YSPY_XXHJ_01 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a0xiaopangxie01" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_02 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a1xiaomifeng02" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_03 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a2xiaomuji03" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_04 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a3xiaoniunai04" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_05 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a4xiaoyu05" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_06 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a5xiaohouzi06" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_07 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a6xiaozhu07" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_08 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a7xiaohuamao08" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_09 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a8changjinglu09" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_10 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "a9jijiubao10" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_11 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b0qingwa11" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_12 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b1luantuluanhua12" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_13 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b2caihong13" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_14 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b3aihusongling14" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_15 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b4shuomohua15" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_16 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b5woxiangyaozhangda16" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_17 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b6yuzhou17" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_XXHJ_18 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "b7dagongji18" + MediaFromart.MP4;

        //火火兔乐园---- 艺术培养 ---律动儿歌
        public static final String HHT_LY_YSPY_LDEG_ROOT_PATH = "/system/videos/leyuan/yishupeiyang/lvdongerge/";
        public static final String HHT_LY_YSPY_ldeg_01 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a0lingerxiangdingdang01" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_02 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a1bingtanghulu02" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_03 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a2paizhaopian03" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_04 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a3yinghuoweiguang04" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_05 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a4gongxifacai05" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_06 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a5gudonglaile06" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_07 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a6zhiqingting07" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_08 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a7chaojiyingxiong08" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_09 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a8xuanzhuanmuma09" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_10 = HHT_LY_YSPY_LDEG_ROOT_PATH + "a9yundongge10" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_11 = HHT_LY_YSPY_LDEG_ROOT_PATH + "b0shuyazi11" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_12 = HHT_LY_YSPY_LDEG_ROOT_PATH + "b1naozhongxiangdingdang12" + MediaFromart.MP4;
        public static final String HHT_LY_YSPY_ldeg_13 = HHT_LY_YSPY_LDEG_ROOT_PATH + "b2huanlehht13" + MediaFromart.MP4;

        //火火兔乐园 ---- 益智游戏
        public static final String HHT_LY_YZYX_01 = "air.RabbitLine";// air.RabbitLine/.AppEntry
        public static final String HHT_LY_YZYX_02 = "air.RabbitPuzzle";//air.RabbitPuzzle/.AppEntry
        public static final String HHT_LY_YZYX_03 = "air.RabbitFindFruit";//air.RabbitFindFruit/.AppEntry
        public static final String HHT_LY_YZYX_04 = "air.RabbitRecogAnimal";//air.RabbitRecogAnimal/.AppEntry
        public static final String HHT_LY_YZYX_05 = "air.RabbitMouse";//air.RabbitMouse/.AppEntry
        public static final String HHT_LY_YZYX_06 = "air.RabbitDefend";//air.RabbitDefend/.AppEntry
        public static final String HHT_LY_YZYX_07 = "air.RabbitTarget";//air.RabbitTarget/.AppEntry
        public static final String HHT_LY_YZYX_08 = "air.RabbitXXL";//air.RabbitXXL/.AppEntry
        public static final String HHT_LY_YZYX_09 = "air.RabbitPiano";//air.RabbitPiano/.AppEntry
        public static final String HHT_LY_YZYX_10 = "air.RabbitDinner";//air.RabbitDinner/.AppEntry
        public static final String HHT_LY_YZYX_11 = "air.RabbitFlopModule";//air.RabbitFlopModule/.AppEntry
        public static final String HHT_LY_YZYX_12 = "air.RabbitTidyRoom";//air.RabbitTidyRoom/.AppEntry

        /*----------------------------------火火兔乐园-----------------------------------------------*/

        /*----------------------------------在线宝箱-----------------------------------------------*/
        //育儿
        public static final String HHT_ZXBX_HHT_BABY_SCHOOL = "com.booyue.l1_hht";//com.booyue.l1_hht/.MainActivity
        //爱奇艺少儿
        public static final String HHT_ZXBX_AIQIYI_CHILDNER = "com.qiyi.video.child";//com.qiyi.video.child/.WelcomeActivity
        //小企鹅乐园
        public static final String HHT_ZXBX_XIAOQIELEYUAN = "com.tencent.qqlivekid";//com.tencent.qqlivekid/.activity.HomeActivity
        //儿歌多多
        public static final String HHT_ZXBX_ERGEDUODUO = "com.duoduo.child.storyhd";//com.duoduo.child.storyhd/.tablet.TabletMainActivity

        //在线宝箱--宝宝巴士
        public static final String HHT_ZXBX_BABY_BUS_00 = "com.sinyee.babybus.animal";//com.sinyee.babybus.animal/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_01 = "com.sinyee.babybus.kindergarten";//com.sinyee.babybus.kindergarten/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_02 = "com.sinyee.babybus.number";//com.sinyee.babybus.number/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_03 = "com.sinyee.education.shape";//com.sinyee.education.shape/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_04 = "com.sinyee.babybus.abc";//com.sinyee.babybus.abc/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_05 = "com.sinyee.babybus.babyhospital";//com.sinyee.babybus.babyhospital/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_06 = "com.sinyee.babybus.birthdayparty";//com.sinyee.babybus.birthdayparty/com.sinyee.babybus.SplashAct
        public static final String HHT_ZXBX_BABY_BUS_07 = "com.sinyee.babybus.candy";//com.sinyee.babybus.candy/com.sinyee.babybus.Main
        public static final String HHT_ZXBX_BABY_BUS_08 = "com.sinyee.babybus.chef";//com.sinyee.babybus.chef/com.sinyee.babybus.Main
        public static final String HHT_ZXBX_BABY_BUS_09 = "com.sinyee.babybus.magichouse";//com.sinyee.babybus.magichouse/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_10 = "com.sinyee.babybus.organized";//com.sinyee.babybus.organized/com.sinyee.babybus.Main
        public static final String HHT_ZXBX_BABY_BUS_11 = "com.sinyee.babybus.seaworld";//com.sinyee.babybus.seaworld/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_12 = "com.sinyee.babybus.shopping";//com.sinyee.babybus.shopping/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_13 = "com.sinyee.babybus.travelsafety";//com.sinyee.babybus.travelsafety/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_14 = "com.sinyee.fruit.activity";//com.sinyee.fruit.activity/com.babybus.plugin.videoview.activity.BoxVideoActivity
        public static final String HHT_ZXBX_BABY_BUS_15 = "com.sinyee.babybus.food";//com.sinyee.babybus.food/com.babybus.plugin.videoview.activity.BoxVideoActivity

        //语音聊天
        public static final String HHT_ZXBX_MEDIA_CHAT = "com.tencent.devicedemo";// com.tencent.devicedemo/com.tencent.BooyueFriendListActivity
        //微信
        public static final String HHT_ZXBX_WECHAT = "com.tencent.mm";//com.tencent.mm/.app.WeChatSplashActivity

        //语音机器人
        public static final String HHT_ZXBX_MY_DAEMON = "com.aispeech.aios/.MainActivity";
        public static final String HHT_ZXBX_MY_DAEMON_PACKGE = "com.aispeech.aios";
        public static final String HHT_ZXBX_MY_DAEMON_LAUNCHER = "com.aispeech.aios.MainActivity";
        public static final String HHT_ZXBX_MY_ADAPTER = "com.aispeech.adapter/.MainActivity";
        public static final String HHT_ZXBX_MY_ADAPTER_PACKAGE = "com.aispeech.adapter";
        public static final String HHT_ZXBX_MY_ADAPTER_LAUNCHER = "com.aispeech.adapter.MainActivity";
        public static final String HHT_ZXBX_MY_ROBOTE = "com.aispeech.t6/.MainActivity";
        public static final String HHT_ZXBX_MY_ROBOTE_PACKGE = "com.aispeech.t6";
        public static final String HHT_ZXBX_MY_ROBOTE_LAUNCHER = "com.aispeech.t6.MainActivity";

        //文件管理器
        public static final String FILE_MANGER_PACKAGE = "com.softwinner.explore";
        public static final String FILE_MANGER_LAUNCHER = "com.softwinner.explore.Main";
        //系统充电
        public static final String CHARGER_PACKAGE = "com.example.administrator.charger";
        public static final String CHARGER_LAUNCHER = "com.example.administrator.changer.MainActivity";

    }

    //媒体文件格式
    public static final class MediaFromart {
        public static final String MP4 = ".mp4";
        public static final String MKV = ".mkv";
    }

    public static class ActivityName {
        //视屏通话的Activity
        public static final String BOOYUE_VIDEOCHATACTIVITY = "com.tencent.BooyueVideoChatActivitySF";
    }

    /**
     * Tencen Bugly相关参数
     */
    public static class Bugly {
        public static final String BUGLY_KEY = "0708b7aed2";
    }

}
