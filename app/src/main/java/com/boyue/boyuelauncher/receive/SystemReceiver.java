package com.boyue.boyuelauncher.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ShutDownUtils;
import com.boyue.boyuelauncher.widget.dialogfragment.Popup_Battery_Low_Dialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Popup_MacConnectEd_Dialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Popup_USBConnected_Dialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Popup_USBMounted_Dialog;


/**
 * 接受系统广播，usb连接、U盘插入、电量不足、话筒插入....
 * Created by Tianluhua on 2018/6/14.
 */

public class SystemReceiver extends BroadcastReceiver {

    public static final String USBMOUNTED = "usbMounted";
    public static final String USBCONNECTED = "usbconnected";
    public static final String BATTERY_LOW = "battery_low";
    public static final String MIC_COMMECTED = "mac_commected";


    private AppCompatActivity activity;
    private SPUtils spUtils;

    public SystemReceiver(AppCompatActivity activity) {
        this.activity = activity;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        String action = intent.getAction();
        LogUtils.e("tlh", "SystemReceiver---onReceive--action:" + action);

        switch (action) {
            //U盘挂载
            case Config.BoYueAction.COM_BOYUE_ACTION_USB_MOUNTED:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "U盘挂载了！");
                showUSBMountedDialog();
                break;

            //usb连接
            case Config.BoYueAction.COM_BOYUE_ACTION_POWER_CONNECTED:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "usb连接了！");
                showUSBConnectedDialog();
                break;

            //电量过低
            case Intent.ACTION_BATTERY_LOW:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "电量过低，请连接充电器！");
                showBatteryLowDialog();
                break;
            //话筒已插入
            case Config.BoYueAction.ACTION_MIC_IN:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "话筒已插入，开始唱歌吧！");
                showMacConnectedDialog();
                break;
            //15、30、60分钟用户无操作,系统自动关机
            case Config.BoYueAction.UNACTIVITY_FIFTEEN_MIN:
            case Config.BoYueAction.UNACTIVITY_THIRTY_MIN:
            case Config.BoYueAction.UNACTIVITY_SIXTY_MIN:
                //接收到系统对应时间的广播，查看用户是否设置了自动关机的时间，没有的话不执行关机
                if (spUtils.getInt(Config.PassWordKey.AUTO_SHUTDOWN_KEY) != Config.Settings.VALUE_NEVER)
                    ShutDownUtils.shutDownWithAction();
                break;


        }
    }

    private void showUSBMountedDialog() {
        FragmentManager manager = activity.getSupportFragmentManager();
        if (manager.findFragmentByTag(USBMOUNTED) == null) {
            Popup_USBMounted_Dialog dialog = new Popup_USBMounted_Dialog();
            dialog.show(activity.getSupportFragmentManager(), USBMOUNTED);
        }

    }

    private void showUSBConnectedDialog() {
        FragmentManager manager = activity.getSupportFragmentManager();
        if (manager.findFragmentByTag(USBCONNECTED) == null) {
            Popup_USBConnected_Dialog dialog = new Popup_USBConnected_Dialog();
            dialog.show(activity.getSupportFragmentManager(), USBCONNECTED);
        }

    }

    private void showBatteryLowDialog() {
        FragmentManager manager = activity.getSupportFragmentManager();
        if (manager.findFragmentByTag(BATTERY_LOW) == null) {
            Popup_Battery_Low_Dialog dialog = new Popup_Battery_Low_Dialog();
            dialog.show(manager, BATTERY_LOW);
        }
    }

    private void showMacConnectedDialog() {
        FragmentManager manager = activity.getSupportFragmentManager();
        if (manager.findFragmentByTag(MIC_COMMECTED) == null) {
            Popup_MacConnectEd_Dialog dialog = new Popup_MacConnectEd_Dialog();
            dialog.show(manager, MIC_COMMECTED);
        }

    }


}
