package com.boyue.boyuelauncher.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

/**
 * Created by Tianluhua on 2018\8\21 0021.
 */
public class ProcessClearHelper {

    private static final String TAG = "ProcessClearHelper";

    public static void cleanProcess() {
        //To change body of implemented methods use File | Settings | File Templates.
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infoList = am.getRunningAppProcesses();
        List<ActivityManager.RunningServiceInfo> serviceInfos = am.getRunningServices(100);

        long beforeMem = getAvailMemory();
        Log.d(TAG, "-----------before memory info : " + beforeMem);

        int count = 0;
        PackageManager pm = Utils.getApp().getPackageManager();

        if (infoList != null) {
            for (int i = 0; i < infoList.size(); ++i) {
                ActivityManager.RunningAppProcessInfo appProcessInfo = infoList.get(i);
                Log.d(TAG, "process name : " + appProcessInfo.processName);
                //importance 该进程的重要程度 分为几个级别，数值越低就越重要。
                Log.d(TAG, "importance : " + appProcessInfo.importance);
                // 一般数值大于RunningAppProcessInfo.IMPORTANCE_SERVICE的进程都长时间没用或者空进程了
                // 一般数值大于RunningAppProcessInfo.IMPORTANCE_VISIBLE的进程都是非可见进程，也就是在后台运行着
                if (appProcessInfo.importance > ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    String[] pkgList = appProcessInfo.pkgList;
                    for (int j = 0; j < pkgList.length; ++j) {//pkgList 得到该进程下运行的包名
                        String appName = null;
                        try {
                            appName = (String) pm.getApplicationLabel(pm.getApplicationInfo(pkgList[j], 0));
                        } catch (PackageManager.NameNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        Log.d(TAG, "It will be killed, package name : " + pkgList[j] + " -- " + appName);
                        am.killBackgroundProcesses(pkgList[j]);
                        count++;
                    }
                }

            }
        }

        long afterMem = getAvailMemory();
        Log.d(TAG, "----------- after memory info : " + afterMem);
    }

    public static long getAvailMemory() {
        // 获取android当前可用内存大小
        ActivityManager am = (ActivityManager) Utils.getApp().getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);
        //mi.availMem; 当前系统的可用内存
        //return Formatter.formatFileSize(context, mi.availMem);// 将获取的内存大小规格化
        Log.d(TAG, "可用内存---->>>" + mi.availMem / (1024 * 1024));
        return mi.availMem / (1024 * 1024);
    }
}
