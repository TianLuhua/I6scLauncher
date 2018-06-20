package com.boyue.boyuelauncher.utils;

import android.widget.Toast;

/**
 * Toast工具类
 */
public class ToastUtil {

    private static String oldMsg;
    protected static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    public static void showToast(String s, int duration) {
        if (toast == null) {
            toast = Toast.makeText(Utils.getApp(), s, duration);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (twoTime - oneTime > duration) {
                    toast.show();
                }
            } else {
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

    public static void showShortToast(int resId) {
        showToast(Utils.getApp().getString(resId), Toast.LENGTH_SHORT);
    }

    public static void showShortToast(String s) {
        showToast(s, Toast.LENGTH_SHORT);
    }

    public static void showLongToast(int resId) {
        showToast(Utils.getApp().getString(resId), Toast.LENGTH_LONG);
    }

    public static void showLongToast(String s) {
        showToast(s, Toast.LENGTH_LONG);
    }
}
