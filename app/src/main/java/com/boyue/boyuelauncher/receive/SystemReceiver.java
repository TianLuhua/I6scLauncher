package com.boyue.boyuelauncher.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ShutDownUtils;
import com.boyue.boyuelauncher.widget.dialogfragment.Popup_MacConnectEd_Dialog;
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

    private boolean isShowUSBConntectDialog;
    private boolean isShowBatteryLogDialog;
    private boolean isShowMicDialog;


    private SPUtils spUtils;
    private WindowManager windowManager;
    private LayoutInflater layoutInflater;
    private WindowManager.LayoutParams wl;

    public SystemReceiver() {
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
        wl = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_TOAST, 0, PixelFormat.TRANSPARENT);
        wl.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        wl.gravity = Gravity.CENTER;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        String action = intent.getAction();
        LogUtils.e("tlh", "SystemReceiver---onReceive--action:" + action);
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        layoutInflater = LayoutInflater.from(context);
        switch (action) {
            //U盘挂载
            case Config.BoYueAction.COM_BOYUE_ACTION_USB_MOUNTED:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "U盘挂载了！");
                if (!isShowUSBConntectDialog)
                    showUSBMountedDialog();
                break;

            //usb连接
            case Config.BoYueAction.COM_BOYUE_ACTION_POWER_CONNECTED:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "usb连接了！");
                //有充电的apk了，似乎这个框框没什么意义
//                showUSBConnectedDialog();
                break;

            //电量过低
            case Intent.ACTION_BATTERY_LOW:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "电量过低，请连接充电器！");
                if (!isShowBatteryLogDialog) {
                    showBatteryLowDialog();
                }

                break;
            //话筒已插入
            case Config.BoYueAction.ACTION_MIC_IN:
                LogUtils.e("tlh", "SystemReceiver---onReceive:" + "话筒已插入，开始唱歌吧！");
                if (!isShowMicDialog) {
                    showMicConnectedDialog();
                }
                break;
            //15、30、60分钟用户无操作,系统自动关机
            case Config.BoYueAction.UNACTIVITY_FIFTEEN_MIN:
                if (spUtils.getInt(Config.PassWordKey.AUTO_SHUTDOWN_KEY) == Config.Settings.VALUE_15M) {
                    ShutDownUtils.shutDownWithAction();
                }
                break;
            case Config.BoYueAction.UNACTIVITY_THIRTY_MIN:
                if (spUtils.getInt(Config.PassWordKey.AUTO_SHUTDOWN_KEY) == Config.Settings.VALUE_30M) {
                    ShutDownUtils.shutDownWithAction();
                }

                break;
            case Config.BoYueAction.UNACTIVITY_SIXTY_MIN:

                if (spUtils.getInt(Config.PassWordKey.AUTO_SHUTDOWN_KEY) == Config.Settings.VALUE_60M) {
                    ShutDownUtils.shutDownWithAction();
                }
                break;


        }
    }

    private void showUSBMountedDialog() {
        isShowUSBConntectDialog = true;
        View v = layoutInflater.inflate(R.layout.dialog_popup_only_icon_lable, null);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (windowManager != null) {
                    windowManager.removeViewImmediate(v);
                    isShowUSBConntectDialog = false;
                }
            }
        });
        windowManager.addView(v, wl);

//        FragmentManager manager = context.getSupportFragmentManager();
//        if (manager.findFragmentByTag(USBMOUNTED) == null) {
//            Popup_USBMounted_Dialog dialog = new Popup_USBMounted_Dialog();
//            dialog.show(activity.getSupportFragmentManager(), USBMOUNTED);
//        }

    }

//    private void showUSBConnectedDialog() {
//        FragmentManager manager = activity.getSupportFragmentManager();
//        if (manager.findFragmentByTag(USBCONNECTED) == null) {
//            Popup_USBConnected_Dialog dialog = new Popup_USBConnected_Dialog();
//            dialog.show(activity.getSupportFragmentManager(), USBCONNECTED);
//        }
//
//    }

    private void showBatteryLowDialog() {

        isShowBatteryLogDialog = true;
        View v = layoutInflater.inflate(R.layout.dialog_popup_battery_low, null);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (windowManager != null) {
                    windowManager.removeViewImmediate(v);
                    isShowBatteryLogDialog = false;
                }
            }
        });
        windowManager.addView(v, wl);

//        FragmentManager manager = activity.getSupportFragmentManager();
//        if (manager.findFragmentByTag(BATTERY_LOW) == null) {
//            Popup_Battery_Low_Dialog dialog = new Popup_Battery_Low_Dialog();
//            dialog.show(manager, BATTERY_LOW);
//        }
    }

    private void showMicConnectedDialog() {
        isShowMicDialog = true;
        View v = layoutInflater.inflate(R.layout.dialog_popup_mic, null);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (windowManager != null) {
                    windowManager.removeViewImmediate(v);
                    isShowMicDialog = false;
                }
            }
        });
        windowManager.addView(v, wl);
//        FragmentManager manager = activity.getSupportFragmentManager();
//        if (manager.findFragmentByTag(MIC_COMMECTED) == null) {
//            Popup_MacConnectEd_Dialog dialog = new Popup_MacConnectEd_Dialog();
//            dialog.show(manager, MIC_COMMECTED);
//        }

    }


}
