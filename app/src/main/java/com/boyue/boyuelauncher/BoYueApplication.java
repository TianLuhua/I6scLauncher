package com.boyue.boyuelauncher;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.provider.Settings;

import com.boyue.boyuelauncher.receive.SystemReceiver;
import com.boyue.boyuelauncher.service.SystemSettingsService;
import com.boyue.boyuelauncher.utils.LockScreenUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.utils.Utils;
import com.tencent.bugly.crashreport.CrashReport;

import static android.provider.Settings.System.SCREEN_OFF_TIMEOUT;
import static com.boyue.boyuelauncher.Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_KEY;
import static com.boyue.boyuelauncher.Config.BoYueAction.COLOR_EAR_OFF;
import static com.boyue.boyuelauncher.Config.BoYueAction.COLOR_EAR_ON;
import static com.boyue.boyuelauncher.Config.PassWordKey.DEFAULT_LED_KEY;


/**
 * Created by tianluhua on 2018/5/25.
 */

public class BoYueApplication extends Application {

    public static String TAG = BoYueApplication.class.getSimpleName();

    private AudioManager audioManager;

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.isShowToast = false;
        //初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), "0708b7aed2", false);
        //初始化Utils
        Utils.init(this);
        //初始化系统SharedPreferences
        final SPUtils spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
        //如何没有存储默认密码，系统就默认为：default
        String bootPwd = spUtils.getString(Config.PassWordKey.BOOT_PWD_NAME);
        this.audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //存储默认值，理论上只会在机器刷机启动的第一次调用，除非恢复出厂、删除系统SP
        if (SPUtils.DEFAULT_STRING.equals(bootPwd)) {
            //初始化默认密码
            spUtils.put(Config.PassWordKey.BOOT_PWD_NAME, Config.PassWordKey.DEFAULT_BOOTPWD);

            //默认不启用密码
            spUtils.put(Config.PassWordKey.PWD_IS_ENABLE, false);

            //默认不启用防沉迷密码
            spUtils.put(Config.PassWordKey.FCM_PWD_NAME, false);

            //默认关闭启定时休息
            spUtils.put(Config.PassWordKey.REGULAR_REST_KEY, Config.Settings.VALUE_NEVER);

            //默认屏幕休眠为从不休眠
            Settings.System.putInt(getContentResolver(), SCREEN_OFF_TIMEOUT, Config.Settings.VALUE_NEVER);

            //默认关闭定时锁定
            spUtils.put(Config.PassWordKey.TIMING_LOCKING_KEY, Config.Settings.VALUE_NEVER);

            //默认关闭自动关机
            spUtils.put(Config.PassWordKey.AUTO_SHUTDOWN_KEY, Config.Settings.VALUE_NEVER);

            //默认关闭定时关机
            spUtils.put(Config.PassWordKey.ONTIME_SHUTDOWN_KEY, Config.Settings.VALUE_NEVER);

            //默认开启护眼关闭护眼传感器
            spUtils.put(Config.PassWordKey.PROTECT_EYE_SENSOR_ENABLE_KEY, false);

            //刷机第一次，耳灯默认是开启的状态
            spUtils.put(DEFAULT_LED_KEY, 1);

            //默认系统最大音量和开机音量值
            spUtils.put(BOOYUE_STREAMMAXVOLUME_KEY, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        }
//        spUtils.clear();//清空sp中的数据
        LogUtils.e("tlh", "SPUtils:" + spUtils.getAll().toString());

        //开机前设置了定时休息，那就默认启动
        int regularRestTime = spUtils.getInt(Config.PassWordKey.REGULAR_REST_KEY);
        if (regularRestTime != Config.Settings.VALUE_NEVER) {
            LockScreenUtils.startLockScreen(Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION, regularRestTime);
        }
        //开机前设置了定时锁定,那就默认启动
        int timingLockingTime = spUtils.getInt(Config.PassWordKey.TIMING_LOCKING_KEY);
        if (timingLockingTime != Config.Settings.VALUE_NEVER) {
            LockScreenUtils.startLockScreen(Config.BoYueAction.ONTIME_REST_ACTION, timingLockingTime);
        }
        //开机前设置了定时关机,那就默认启动
        int shutDowntime = spUtils.getInt(Config.PassWordKey.ONTIME_SHUTDOWN_KEY);
        if (shutDowntime != Config.Settings.VALUE_NEVER) {
            LockScreenUtils.startLockScreen(Config.BoYueAction.ONTIME_SHUTDOWN_ACTION, shutDowntime);
        }

        //开机前设置了自动关机,自动关机默认开启
        int aotuShutDowntime = spUtils.getInt(Config.PassWordKey.AUTO_SHUTDOWN_KEY);
        if (aotuShutDowntime != Config.Settings.VALUE_NEVER) {
            //好像什么都不要做，系统直接给广播
        }

        //通知SystemSettingsService，恢复关机前护眼传感器的状态、
        if (spUtils.getBoolean(Config.PassWordKey.PROTECT_EYE_SENSOR_ENABLE_KEY)) {
            Intent intent = new Intent(getApplicationContext(), SystemSettingsService.class);
            intent.setAction(Config.BoYueAction.PROTECTSENSOR_ACTION_OPEN);
            startService(intent);
        }


        //初始化耳灯状态
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setAction(spUtils.getInt(DEFAULT_LED_KEY) == 1 ? COLOR_EAR_ON : COLOR_EAR_OFF);
                Utils.getApp().sendBroadcast(intent);
                LogUtils.e("tlh", "BoYueApplication---初始化耳灯状态：" + spUtils.getInt(DEFAULT_LED_KEY));
            }
        });

        //初始化最系统大音量值
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_ACTION);
                intent.putExtra(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_KEY, spUtils.getInt(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_KEY));
                Utils.getApp().sendBroadcast(intent);
                LogUtils.e("tlh", "BoYueApplication---初始化最系统大音量值：" + spUtils.getInt(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_KEY));
            }
        });

        //注册 弹窗广播：usb连接、U盘插入、电量不足、话筒插入....
        SystemReceiver systemReceiver = new SystemReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Config.BoYueAction.COM_BOYUE_ACTION_USB_MOUNTED);
        filter.addAction(Config.BoYueAction.COM_BOYUE_ACTION_POWER_CONNECTED);
        filter.addAction(Config.BoYueAction.ACTION_MIC_IN);
        filter.addAction(Intent.ACTION_BATTERY_LOW);

        //一段时间屏幕无操作的系统广播
        filter.addAction(Config.BoYueAction.UNACTIVITY_FIFTEEN_MIN);
        filter.addAction(Config.BoYueAction.UNACTIVITY_THIRTY_MIN);
        filter.addAction(Config.BoYueAction.UNACTIVITY_SIXTY_MIN);

        registerReceiver(systemReceiver, filter);
        LogUtils.e("tlh", "BoYueApplication---registerReceiver");


    }
}
