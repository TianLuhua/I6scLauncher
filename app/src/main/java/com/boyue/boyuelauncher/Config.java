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

        //重置密码的点击次数
        public static int RESET_PASSWORD_CLICK_NUMBER = 8;

        //连续点击，调出系统Settings
        public static int REQUST_SYSTEM_SETITNGS_CLICK_NUMBER = 8;
        public static String REQUST_SYSTEM_SETITNGS_PASSWORD = "0001";

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
        public static final int VALUE_1M = 60000;
        //        public static final int VALUE_1M = 1000;
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

    }

    //Launcher中需要用到的资源
    public static class BoYueLauncherResource {
        /*----------------------------------小学课堂-----------------------------------------------*/
        public static final String HHT_XXKT_PACKAGE = "com.wyt.hht7.xx";
        public static final String HHT_XXKT_LAUNCHER = "com.wyt.hengke.huohuotu.MainActivity";

        /*----------------------------------火火兔学堂-----------------------------------------------*/
        //早教英语 ----邦尼英语
        public static final String HHT_XT_ZJYY_BANGNI_ROOT_PATH = "/system/videos/xuetang/zaojiaoyingyu/bangni/";
        public static final String HHT_XT_ZJYY_BANGNI_01 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Hello_how_are_you.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_02 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Where_is_Bunny.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_03 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Boy_and_girl.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_04 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Stand_up_sit_down.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_05 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Wash_your_hands.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_06 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Nice_food.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_07 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "I_see.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_08 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Whats_this.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_09 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "A_candy_for_you.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_10 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "One_potato.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_11 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Happy.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_12 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Shake.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_13 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Which_one_do_you_like.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_14 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Who_can_do_it.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_15 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "I_want.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_16 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Traffic_lights.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_17 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "How_do_you_feel.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_18 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Mid_Autumn_Day.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_19 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Taste.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_20 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "What_are_you_wearing.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_21 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "I_see_you.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_22 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Music_man.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_23 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Rain.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_24 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Merry_Christmas.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_25 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "What_shape_is_it.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_26 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Numbers.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_27 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Fly_a_kite.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_28 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Is_it_yours.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_29 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Three_bears.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_30 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "At_home.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_31 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Its_too_hot.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_32 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Who_is_coming.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_33 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "A_busy_day.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_34 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Little_rabbits.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_35 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Can_i_help_you.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_36 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Three_little_pigs.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_37 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "I_am_a_bus.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_38 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Bingo.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_39 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Five_little_monkeys.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_40 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Chinese_new_year.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_41 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Fun_to_play.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_42 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Rabbit_and_tortoise.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_43 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "What_is_your_favorite_sport.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_44 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Bears_teeth.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_45 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Happy_mothers_day.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_46 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "A_big_radish_in_the_hole.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_47 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "The_muffin_man.mp4";
        public static final String HHT_XT_ZJYY_BANGNI_48 = HHT_XT_ZJYY_BANGNI_ROOT_PATH + "Goodbye.mp4";
        //早教英语 ----多纳英语
        public static final String HHT_XT_ZJYY_DUONA_ROOT_PATH = "/system/videos/xuetang/zaojiaoyingyu/duona/";
        public static final String HHT_XT_ZJYY_DUONA_01 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "zaoshanghao.mp4";
        public static final String HHT_XT_ZJYY_DUONA_02 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "woshi.mp4";
        public static final String HHT_XT_ZJYY_DUONA_03 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "meiweishuiguo.mp4";
        public static final String HHT_XT_ZJYY_DUONA_04 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "rangwomenshuyishu.mp4";
        public static final String HHT_XT_ZJYY_DUONA_05 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "shitoujiandaobu.mp4";
        public static final String HHT_XT_ZJYY_DUONA_06 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "zhuomicang.mp4";
        public static final String HHT_XT_ZJYY_DUONA_07 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "chuanshangyifu.mp4";
        public static final String HHT_XT_ZJYY_DUONA_08 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "shangrikuaile.mp4";
        public static final String HHT_XT_ZJYY_DUONA_09 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "wotule.mp4";
        public static final String HHT_XT_ZJYY_DUONA_10 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "moxojiamshenmeyanse.mp4";
        public static final String HHT_XT_ZJYY_DUONA_11 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "qudongwuyuan.mp4";
        public static final String HHT_XT_ZJYY_DUONA_12 = HHT_XT_ZJYY_DUONA_ROOT_PATH + "keaidedongwu.mp4";
        //早教英语 ----宝狄英语
        public static final String HHT_XT_ZJYY_BAODI_ROOT_PATH = "/system/videos/xuetang/zaojiaoyingyu/baodi/";
        public static final String HHT_XT_ZJYY_BAODI_01 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Bodhis_ABC.mp4";
        public static final String HHT_XT_ZJYY_BAODI_02 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "A_Day_at_Cafe_Sambolo_1.mp4";
        public static final String HHT_XT_ZJYY_BAODI_03 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "All_These_Shapes1.mp4";
        public static final String HHT_XT_ZJYY_BAODI_04 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "America_Song.mp4";
        public static final String HHT_XT_ZJYY_BAODI_05 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Around_My_Rooms.mp4";
        public static final String HHT_XT_ZJYY_BAODI_06 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Asia_Song.mp4";
        public static final String HHT_XT_ZJYY_BAODI_07 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Better_Weather.mp4";
        public static final String HHT_XT_ZJYY_BAODI_08 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Body_Bop.mp4";
        public static final String HHT_XT_ZJYY_BAODI_09 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Check_out_my_toy.mp4";
        public static final String HHT_XT_ZJYY_BAODI_10 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "City_Life_City_Lights.mp4";
        public static final String HHT_XT_ZJYY_BAODI_11 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Clean_and_Green.mp4";
        public static final String HHT_XT_ZJYY_BAODI_12 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Colourful_Party.mp4";
        public static final String HHT_XT_ZJYY_BAODI_13 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Count_on_You.mp4";
        public static final String HHT_XT_ZJYY_BAODI_14 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Count_with_Bodhi.mp4";
        public static final String HHT_XT_ZJYY_BAODI_15 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Day_and_Night.mp4";
        public static final String HHT_XT_ZJYY_BAODI_16 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Dream_Team.mp4";
        public static final String HHT_XT_ZJYY_BAODI_17 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Dress_You_Up.mp4";
        public static final String HHT_XT_ZJYY_BAODI_18 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Everyday_Heroes.mp4";
        public static final String HHT_XT_ZJYY_BAODI_19 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Face_It.mp4";
        public static final String HHT_XT_ZJYY_BAODI_20 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Family.mp4";
        public static final String HHT_XT_ZJYY_BAODI_21 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Food.mp4";
        public static final String HHT_XT_ZJYY_BAODI_22 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Friends_Forever.mp4";
        public static final String HHT_XT_ZJYY_BAODI_23 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Full_Circle.mp4";
        public static final String HHT_XT_ZJYY_BAODI_24 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Fun_Family_Day.mp4";
        public static final String HHT_XT_ZJYY_BAODI_25 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Future_of_the_World.mp4";
        public static final String HHT_XT_ZJYY_BAODI_26 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Good_Food_Good_for_You.mp4";
        public static final String HHT_XT_ZJYY_BAODI_27 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "I_Can_Do_It.mp4";
        public static final String HHT_XT_ZJYY_BAODI_28 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "I_Love_Food.mp4";
        public static final String HHT_XT_ZJYY_BAODI_29 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Imagine.mp4";
        public static final String HHT_XT_ZJYY_BAODI_30 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "In_Our_Neighbourhood.mp4";
        public static final String HHT_XT_ZJYY_BAODI_31 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Its_a_New_Day.mp4";
        public static final String HHT_XT_ZJYY_BAODI_32 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Lets_Get_Fit.mp4";
        public static final String HHT_XT_ZJYY_BAODI_33 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Lets_Go_to_School.mp4";
        public static final String HHT_XT_ZJYY_BAODI_34 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Lets_Have_a_Good_Time.mp4";
        public static final String HHT_XT_ZJYY_BAODI_35 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Lets_Take_It_from_123.mp4";
        public static final String HHT_XT_ZJYY_BAODI_36 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Lets_play_ball.mp4";
        public static final String HHT_XT_ZJYY_BAODI_37 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Make_This_the_Best_Day.mp4";
        public static final String HHT_XT_ZJYY_BAODI_38 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Meet_Our_Families.mp4";
        public static final String HHT_XT_ZJYY_BAODI_39 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Mix_and_Match.mp4";
        public static final String HHT_XT_ZJYY_BAODI_40 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Move_Our_Bodies.mp4";
        public static final String HHT_XT_ZJYY_BAODI_41 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "My_Heart.mp4";
        public static final String HHT_XT_ZJYY_BAODI_42 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "My_Home.mp4";
        public static final String HHT_XT_ZJYY_BAODI_43 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "No_Place_Like_Home.mp4";
        public static final String HHT_XT_ZJYY_BAODI_44 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Pat_Your_Pet.mp4";
        public static final String HHT_XT_ZJYY_BAODI_45 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Pet_Sounds.mp4";
        public static final String HHT_XT_ZJYY_BAODI_46 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Push_Through_Dont_Stop.mp4";
        public static final String HHT_XT_ZJYY_BAODI_47 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Rainbow_Shining.mp4";
        public static final String HHT_XT_ZJYY_BAODI_48 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Reap_What_You_Sow.mp4";
        public static final String HHT_XT_ZJYY_BAODI_49 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "School_Days.mp4";
        public static final String HHT_XT_ZJYY_BAODI_50 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "See_you_later.mp4";
        public static final String HHT_XT_ZJYY_BAODI_51 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Sharing_is_Caring.mp4";
        public static final String HHT_XT_ZJYY_BAODI_52 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Sing_Along_with_Bodhi_and_Friends.mp4";
        public static final String HHT_XT_ZJYY_BAODI_53 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "So_Much_to_Do.mp4";
        public static final String HHT_XT_ZJYY_BAODI_54 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Thats_What_We_Like.mp4";
        public static final String HHT_XT_ZJYY_BAODI_55 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "The_Face_Song.mp4";
        public static final String HHT_XT_ZJYY_BAODI_56 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "The_Greetings_Song.mp4";
        public static final String HHT_XT_ZJYY_BAODI_57 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "The_Hello_Song.mp4";
        public static final String HHT_XT_ZJYY_BAODI_58 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "The_Name_of_the_Game.mp4";
        public static final String HHT_XT_ZJYY_BAODI_59 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "The_Sounds_of_the_Farm.mp4";
        public static final String HHT_XT_ZJYY_BAODI_60 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "The_time_is_now.mp4";
        public static final String HHT_XT_ZJYY_BAODI_61 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Things_That_Go.mp4";
        public static final String HHT_XT_ZJYY_BAODI_62 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Together.mp4";
        public static final String HHT_XT_ZJYY_BAODI_63 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Toys_toys_everywhere.mp4";
        public static final String HHT_XT_ZJYY_BAODI_64 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "We_Are_on_the_Go.mp4";
        public static final String HHT_XT_ZJYY_BAODI_65 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "We_Can_Be_Anything.mp4";
        public static final String HHT_XT_ZJYY_BAODI_66 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "We_ll_Be_Your_Shelter.mp4";
        public static final String HHT_XT_ZJYY_BAODI_67 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Weather_Ready.mp4";
        public static final String HHT_XT_ZJYY_BAODI_68 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Welcome_to_Our_World.mp4";
        public static final String HHT_XT_ZJYY_BAODI_69 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Welcome_to_the_Farm.mp4";
        public static final String HHT_XT_ZJYY_BAODI_70 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "When_I_Grow_Up.mp4";
        public static final String HHT_XT_ZJYY_BAODI_71 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "With_My_Eyes.mp4";
        public static final String HHT_XT_ZJYY_BAODI_72 = HHT_XT_ZJYY_BAODI_ROOT_PATH + "Work_Hard_Get_Smart.mp4";

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
        public static final String HHT_LY_KALAOK_JDEG_ITEM_01 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "fenshuajiang03.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_02 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "yifenqian09.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_03 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "woniuyuhuangliniao07.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_04 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "lingerxiangdingdang04.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_05 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "maliyouzhixiaoyanggao19.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_06 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "liangzhilaohu10.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_07 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "shishangzhiyoumamahao05.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_08 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "shuyazi06.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_09 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "aiwojiubaobaowo18.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_10 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "baluobo15.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_11 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "chuntianzainali01.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_12 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "lanjinling02.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_13 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "shijianzaishuohua17.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_14 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "woyouyigejia13.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_15 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "xiaolongren12.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_16 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "xiaoxingxing08.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_17 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "xiaoyanzi11.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_18 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "zhaopengyou14.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_19 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "zhongtaiyang20.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ITEM_20 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "zhuoniqiu16.mkv";

        //火火兔乐园---- 卡拉ok ---兔兔MTV
        public static final String HHT_LY_KALAOK_TTMTV_ROOT_PATH = "/system/videos/leyuan/kalaOK/yuanchuang/";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_01 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "daxiongmao01.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_02 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "chunyu02.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_03 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "chaojiyingxiong03.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_04 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "zhuqingting04.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_05 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "shangyuanzhuzhici05.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_06 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "shuyazi06.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_07 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "yinghuoweiguang07.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_08 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "bahe08.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_09 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "hello09.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_10 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "gongfuxiaozi10.mp4";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_11 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "xunyinzhibuyu11.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_12 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "xiaoxiaobinggan12.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_13 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "xiaohuajia13.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_14 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "shancunyonghuai14.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_15 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "gongxifacai15.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_16 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "mingnong16.mp4";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_17 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "jinglige17.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_18 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "chuntianzainali18.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_19 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "zhishuge19.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_20 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "aixiliangshi20.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_21 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "hua21.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_22 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "qiuyinong22.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_23 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "meilitianye23.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_24 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "laoshukaihui24.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_25 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "wuyixiang25.mkv";
        public static final String HHT_LY_KALAOK_TTMTV_ITEM_26 = HHT_LY_KALAOK_TTMTV_ROOT_PATH + "daguonian26.mkv";

        //火火兔乐园---- 卡拉ok ----酷我K歌
        public static final String HHT_LY_KALAOK_KUWOKGE_PACKAGE = "cn.kuwo.sing.tv";//cn.kuwo.sing.tv/.activity.WelcomeActivity

        //火火兔乐园---- 卡拉ok ----火火兔唱古诗
        public static final String HHT_LY_KALAOK_HHTCGS_ROOT_PATH = "/system/videos/leyuan/kalaOK/hhtcgs/";
        public static final String HHT_LY_KALAOK_HHTCGS_01 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "ye01.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_02 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "jys02.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_03 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "yr03.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_04 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "lzc04.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_05 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "cs05.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_06 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "bdd06.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_07 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "glyx07.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_08 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "fdgyclb08.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_09 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "xyzby09.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_10 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "xc10.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_11 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "sx11.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_12 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "jhzs12.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_13 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "zfbdc13.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_14 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "zccsb14.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_15 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "cyxy15.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_16 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "cx16.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_17 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "wlspb17.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_18 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "fqyb18.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_19 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "jpdbxh19.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_20 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "jx20.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_21 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "yzy21.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_22 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "dgql22.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_23 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "jj23.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_24 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "cgx24.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_25 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "cgx24.mp4";
        public static final String HHT_LY_KALAOK_HHTCGS_26 = HHT_LY_KALAOK_HHTCGS_ROOT_PATH + "cgx24.mp4";

        //火火兔乐园---- 卡拉ok ---英文儿歌
        public static final String HHT_LY_KALAOK_YWEG_ROOT_PATH = "/system/videos/leyuan/yingwenerge/";
        public static final String HHT_LY_KALAOK_YWEG_01 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Green_and_Speckled_Frogs_song.mp4";
        public static final String HHT_LY_KALAOK_YWEG_02 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Little_Pumpkins_Sitting_On_aGate.mp4";
        public static final String HHT_LY_KALAOK_YWEG_03 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Ants_go_marching_one_by_one_song.mp4";
        public static final String HHT_LY_KALAOK_YWEG_04 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Ballet_Song_for_Kids_Down_at_the_Ballet.mp4";
        public static final String HHT_LY_KALAOK_YWEG_05 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Clap_Your_Hands_Song_for_Kids.mp4";
        public static final String HHT_LY_KALAOK_YWEG_06 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Count_to_100_Song_for_Kindergarten.mp4";
        public static final String HHT_LY_KALAOK_YWEG_07 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Dinosaur_Stomp_Song_for_Kids_Party.mp4";
        public static final String HHT_LY_KALAOK_YWEG_08 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Five_Little_Bunnies_Easter_Bunny_Song.mp4";
        public static final String HHT_LY_KALAOK_YWEG_09 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Five_Little_Monkeys_Jumping_on_the_Bed.mp4";
        public static final String HHT_LY_KALAOK_YWEG_10 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Freeze_Dance_for_Kids_Party_Music.mp4";
        public static final String HHT_LY_KALAOK_YWEG_11 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Freeze_Dance_Game_North_Pole_Christmas.mp4";
        public static final String HHT_LY_KALAOK_YWEG_12 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Funky_Monkey_Dance_Song_for_Kids_1.mp4";
        public static final String HHT_LY_KALAOK_YWEG_13 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Halloween_songs5_Little_Pumpkins_Sitting.mp4";
        public static final String HHT_LY_KALAOK_YWEG_14 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Im_a_Little_Snowman_Song_for_Children.mp4";
        public static final String HHT_LY_KALAOK_YWEG_15 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Skeleton_Dance_Shake_Demo_Halloween.mp4";
        public static final String HHT_LY_KALAOK_YWEG_16 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Ten_in_the_Bed_song_for_children.mp4";
        public static final String HHT_LY_KALAOK_YWEG_17 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Tooty_Ta_Dr_Jean_Tooty_Ta_with_Lyrics.mp4";
        public static final String HHT_LY_KALAOK_YWEG_18 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Walking_Walking_Song_Hop_Hop.mp4";
        public static final String HHT_LY_KALAOK_YWEG_19 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Wiggle_It_Wiggle_Dance_Wiggles_Songs.mp4";
        public static final String HHT_LY_KALAOK_YWEG_20 = HHT_LY_KALAOK_YWEG_ROOT_PATH + "Winter_Hokey_Pokey_Song_for_Kids.mp4";

        //火火兔乐园---- 艺术培养 ---智趣音乐
        public static final String HHT_LY_YSPY_ZQYY_01 = "";
        public static final String HHT_LY_YSPY_ZQYY_02 = "";
        public static final String HHT_LY_YSPY_ZQYY_03 = "";
        public static final String HHT_LY_YSPY_ZQYY_04 = "";
        public static final String HHT_LY_YSPY_ZQYY_05 = "";
        public static final String HHT_LY_YSPY_ZQYY_06 = "";
        public static final String HHT_LY_YSPY_ZQYY_07 = "";
        //火火兔乐园---- 艺术培养 ---画图创作
        public static final String HHT_LY_YSPY_HTCZ_01 = "";
        public static final String HHT_LY_YSPY_HTCZ_02 = "";
        public static final String HHT_LY_YSPY_HTCZ_03 = "";
        public static final String HHT_LY_YSPY_HTCZ_04 = "";
        public static final String HHT_LY_YSPY_HTCZ_05 = "";
        public static final String HHT_LY_YSPY_HTCZ_06 = "";
        public static final String HHT_LY_YSPY_HTCZ_07 = "";
        public static final String HHT_LY_YSPY_HTCZ_08 = "";
        public static final String HHT_LY_YSPY_HTCZ_09 = "";

        //火火兔乐园---- 艺术培养 ---艺术之旅
        public static final String HHT_LY_YSPY_YSZL_ROOT_PATH = "/system/videos/leyuan/yishupeiyang/yishuzhilv/";
        public static final String HHT_LY_YSPY_YSZL_01 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh1.mp4";
        public static final String HHT_LY_YSPY_YSZL_02 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh2.mp4";
        public static final String HHT_LY_YSPY_YSZL_03 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh3.mp4";
        public static final String HHT_LY_YSPY_YSZL_04 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh4.mp4";
        public static final String HHT_LY_YSPY_YSZL_05 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh5.mp4";
        public static final String HHT_LY_YSPY_YSZL_06 = HHT_LY_YSPY_YSZL_ROOT_PATH + "zmds.mp4";

        //火火兔乐园---- 艺术培养 ---小小画家
        public static final String HHT_LY_YSPY_XXHJ_ROOT_PATH = "/system/videos/leyuan/yishupeiyang/xiaoxiaohuajia/";
        public static final String HHT_LY_YSPY_XXHJ_01 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaopangxie01.mp4";
        public static final String HHT_LY_YSPY_XXHJ_02 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaomifeng02.mp4";
        public static final String HHT_LY_YSPY_XXHJ_03 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaomuji03.mp4";
        public static final String HHT_LY_YSPY_XXHJ_04 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaoniunai04.mp4";
        public static final String HHT_LY_YSPY_XXHJ_05 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaoyu05.mp4";
        public static final String HHT_LY_YSPY_XXHJ_06 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaohouzi06.mp4";
        public static final String HHT_LY_YSPY_XXHJ_07 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaozhu07.mp4";
        public static final String HHT_LY_YSPY_XXHJ_08 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "xiaohuamao08.mp4";
        public static final String HHT_LY_YSPY_XXHJ_09 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "changjinglu09.mp4";
        public static final String HHT_LY_YSPY_XXHJ_10 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "jijiubao10.mp4";
        public static final String HHT_LY_YSPY_XXHJ_11 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "qingwa11.mp4";
        public static final String HHT_LY_YSPY_XXHJ_12 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "luantuluanhua12.mp4";
        public static final String HHT_LY_YSPY_XXHJ_13 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "caihong13.mp4";
        public static final String HHT_LY_YSPY_XXHJ_14 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "aihusongling14.mp4";
        public static final String HHT_LY_YSPY_XXHJ_15 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "shuomohua15.mp4";
        public static final String HHT_LY_YSPY_XXHJ_16 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "woxiangyaozhangda16.mp4";
        public static final String HHT_LY_YSPY_XXHJ_17 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "yuzhou17.mp4";
        public static final String HHT_LY_YSPY_XXHJ_18 = HHT_LY_YSPY_XXHJ_ROOT_PATH + "dagongji18.mp4";

        //火火兔乐园---- 艺术培养 ---律动儿歌
        public static final String HHT_LY_YSPY_LDEG_ROOT_PATH = "/system/videos/leyuan/yishupeiyang/lvdongerge/";
        public static final String HHT_LY_YSPY_ldeg_01 = HHT_LY_YSPY_LDEG_ROOT_PATH + "lingerxiangdingdang01.mp4";
        public static final String HHT_LY_YSPY_ldeg_02 = HHT_LY_YSPY_LDEG_ROOT_PATH + "bingtanghulu02.mp4";
        public static final String HHT_LY_YSPY_ldeg_03 = HHT_LY_YSPY_LDEG_ROOT_PATH + "paizhaopian03.mp4";
        public static final String HHT_LY_YSPY_ldeg_04 = HHT_LY_YSPY_LDEG_ROOT_PATH + "yinghuoweiguang04.mp4";
        public static final String HHT_LY_YSPY_ldeg_05 = HHT_LY_YSPY_LDEG_ROOT_PATH + "gongxifacai05.mp4";
        public static final String HHT_LY_YSPY_ldeg_06 = HHT_LY_YSPY_LDEG_ROOT_PATH + "gudonglaile06.mp4";
        public static final String HHT_LY_YSPY_ldeg_07 = HHT_LY_YSPY_LDEG_ROOT_PATH + "zhiqingting07.mp4";
        public static final String HHT_LY_YSPY_ldeg_08 = HHT_LY_YSPY_LDEG_ROOT_PATH + "chaojiyingxiong08.mp4";
        public static final String HHT_LY_YSPY_ldeg_09 = HHT_LY_YSPY_LDEG_ROOT_PATH + "xuanzhuanmuma09.mp4";
        public static final String HHT_LY_YSPY_ldeg_10 = HHT_LY_YSPY_LDEG_ROOT_PATH + "yundongge10.mp4";
        public static final String HHT_LY_YSPY_ldeg_11 = HHT_LY_YSPY_LDEG_ROOT_PATH + "shuyazi11.mp4";
        public static final String HHT_LY_YSPY_ldeg_12 = HHT_LY_YSPY_LDEG_ROOT_PATH + "naozhongxiangdingdang12.mp4";
        public static final String HHT_LY_YSPY_ldeg_13 = HHT_LY_YSPY_LDEG_ROOT_PATH + "huanlehht13.mp4";

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
        public static final String HHT_ZXBX_BABY_BUS_06 = "com.sinyee.babybus.birtypartyhda";//com.sinyee.babybus.birtypartyhda/com.babybus.plugin.videoview.activity.BoxVideoActivity
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
        public static final String HHT_ZXBX_MY_ROBOTE = "com.aispeech.t6";//com.aispeech.t6/.MainActivity


        //文件管理器
        public static final String FILE_MANGER_PACKAGE = "com.softwinner.explore";
        public static final String FILE_MANGER_LAUNCHER = "com.softwinner.explore.Main";

    }


}
