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
        public static final String ACTIVITY_ACTION_FCMLOCKSCREEN = "com.boyue.boyuelauncher.FCMlockscreen";
        public static final String ACTIVITY_ACTION_PROTECTEYELOCKSCREEN = "com.boyue.boyuelauncher.ProtectEyeLockScreen";
        public static final String ACTIVITY_ACTION_KLOK = "com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.activity";

        //重置密码的点击次数
        public static int RESET_PASSWORD = 8;

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
        public static final String USB_PATH = "/storage/usbhost1";
        public static final String SD_PATH = "/storage/extsd";
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


        //用于保存启动的：火火兔乐园---卡拉ok 加载的是哪个页面的数据
        public static final String HHTLY_KLOK_PAGE = "page";
    }

    //Launcher中需要用到的资源
    public static class BoYueLauncherResource {
        /*----------------------------------火火兔学堂-----------------------------------------------*/
        //早教英语 ----邦尼英语
        public static final String HHT_XT_ZJYY_BANGNI_ROOT_PATH = "/system/videos/xuetang/zaojiaoyingyu/bangni/";
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
        public static final String HHT_AR_ENGLISH = "com.o2interaction.educationEnglish";//com.o2interaction.educationEnglish/.MainActivity
        public static final String HHT_AR_MATH = "com.o2interaction.educationMath";// com.o2interaction.educationMath/.MainActivity
        public static final String HHT_AR_LAND_ANIMAL = "com.o2design.animal";
        public static final String HHT_AR_OCEAN_ANIMAL = "com.o2design.animalofocean";
        public static final String HHT_AR_DINOSAUR = "com.o2design.Dinosaurs";
        public static final String HHT_AR_3D_MAGIC = "com.simon.MH3D";


        /*----------------------------------火火兔乐园-----------------------------------------------*/
        public static final String HHT_LY_KLOK = "";
        public static final String HHT_LY_ENGLISH_SING = "";
        public static final String HHT_LY_KING_STORY = "故事王国";
        public static final String HHT_LY_ART_TRAIN = "";
        public static final String HHT_LY_YZ_GAME = "";
        public static final String HHT_LY_BABY_CAMERA = "com.android.camera2";// com.android.camera2/com.android.camera.CameraLauncher

        //火火兔乐园---- 卡拉ok ---经典儿歌
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH = "/system/videos/leyuan/kalaOK/jingdian/";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_01 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "fenshuajiang03.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_02 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "yifenqian09.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_03 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "woniuyuhuangliniao07.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_04 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "lingerxiangdingdang04.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_05 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "maliyouzhixiaoyanggao19.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_06 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "liangzhilaohu10.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_07 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "shishangzhiyoumamahao05.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_08 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "shuyazi06.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_09 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "aiwojiubaobaowo18.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_10 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "baluobo15.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_11 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "chuntianzainali01.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_12 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "lanjinling02.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_13 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "shijianzaishuohua17.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_14 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "woyouyigejia13.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_15 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "xiaolongren12.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_16 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "xiaoxingxing08.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_17 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "xiaoyanzi11.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_18 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "zhaopengyou14.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_19 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "zhongtaiyang20.mkv";
        public static final String HHT_LY_KALAOK_JDEG_ROOT_PATH_ITEM_20 = HHT_LY_KALAOK_JDEG_ROOT_PATH + "zhuoniqiu16.mkv";
        //火火兔乐园---- 卡拉ok ---兔兔MTV
        public static final String HHT_LY_KALAOK_TTMTV_ROOT_PATH = "";


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

        //火火兔乐园---- 艺术培养 ---艺术之旅
        public static final String HHT_LY_YSPY_YSZL_ROOT_PATH = "/system/videos/leyuan/yishupeiyang/yishuzhilv/";
        public static final String HHT_LY_YSPY_YSZL_01 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh1.mp4";
        public static final String HHT_LY_YSPY_YSZL_02 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh2.mp4";
        public static final String HHT_LY_YSPY_YSZL_03 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh3.mp4";
        public static final String HHT_LY_YSPY_YSZL_04 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh4.mp4";
        public static final String HHT_LY_YSPY_YSZL_05 = HHT_LY_YSPY_YSZL_ROOT_PATH + "sjmh5.mp4";
        public static final String HHT_LY_YSPY_YSZL_06 = HHT_LY_YSPY_YSZL_ROOT_PATH + "zmds.mp4";


        //火火兔乐园 ---- 益智游戏  //air.RabbitTarget/.AppEntry
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
