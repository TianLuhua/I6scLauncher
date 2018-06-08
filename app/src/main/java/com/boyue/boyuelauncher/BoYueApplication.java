package com.boyue.boyuelauncher;

import android.app.Application;

import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.Utils;

/**
 * Created by tianluhua on 2018/5/11.
 */

public class BoYueApplication extends Application {

    public static String TAG = BoYueApplication.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        //初始化系统SharedPreferences
        SPUtils spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
        //如何没有存储默认密码，系统就默认为：default
        String bootPwd = spUtils.getString(Config.PWDKey.BOOT_PWD_NAME);
        //存储默认值，原则上只会在机器刷机启动的第一次调用
        if (SPUtils.DEFAULT_STRING.equals(bootPwd)) {

            LogUtils.e("tlh", "SPUtils:" );
            //初始化默认密码
            spUtils.put(Config.PWDKey.BOOT_PWD_NAME, Config.PWDKey.DEFAULT_BOOTPWD);
            //默认不启用密码
            spUtils.put(Config.PWDKey.PWD_IS_ENABLE, false);
            //默认不启用防沉迷密码
            spUtils.put(Config.PWDKey.FCM_PWD_NAME, false);

        }

        LogUtils.e("tlh", "SPUtils:" + spUtils.getAll().toString());
    }
}
