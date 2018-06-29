package com.boyue.boyuelauncher.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.Toast;

import com.boyue.boyuelauncher.Config;

import java.util.ArrayList;
import java.util.List;

public class ActivityUtils {


    /**
     * 启动对应的Activity根据不同的Action
     *
     * @param action
     */
    public static void setActivityConfig(String action) {
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Utils.getApp().getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            try {
                Utils.getApp().startActivity(intent);

            } catch (ActivityNotFoundException e) {
                Toast.makeText(Utils.getApp(), "Start Activity Error", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Utils.getApp(), "Not Found Activity", Toast.LENGTH_SHORT).show();
        }
    }

    public static void setActivityConfig(String action, String key, int value) {
        Intent intent = new Intent(action);
        intent.putExtra(key, value);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Utils.getApp().getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            try {
                Utils.getApp().startActivity(intent);

            } catch (ActivityNotFoundException e) {
                Toast.makeText(Utils.getApp(), "Start Activity Error", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Utils.getApp(), "Not Found Activity", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 根据包名启动 APP
     *
     * @param packagename 包名
     */
    public static void startApplicationWithPackageName(String packagename) {

        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageManager manager = Utils.getApp().getPackageManager();
        PackageInfo packageinfo = null;

        try {
            packageinfo = manager.getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo == null) {
            return;
        }
        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(packageinfo.packageName);

        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = manager
                .queryIntentActivities(resolveIntent, 0);

        ResolveInfo resolveinfo = resolveinfoList.iterator().next();
        if (resolveinfo != null) {
            // packagename = 参数packname
            String packageName = resolveinfo.activityInfo.packageName;
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = createComponentName(packageName, className);
            intent.setComponent(cn);
            Utils.getApp().startActivity(intent);
        } else {
            Toast.makeText(Utils.getApp(), "Not Found Activity", Toast.LENGTH_SHORT).show();
        }
    }

//
////    Intent intent = new Intent(Intent.ACTION_MAIN);
////                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
////    ComponentName cn = new ComponentName("com.wyt.hht7.xx", "com.wyt.hengke.huohuotu.activity.AppActivity");
////                    intent.setComponent(cn);
////                    intent.putExtra("appname","拼音学习");
////
////    startActivity(intent);

    /**
     * 根据传入的字符启动格林的apk：数学逻辑   传统国学    多元智能   安全知识    故事王国
     */
    public static void startApplicationForGeLin(String value) {

        startApplicationWithComponent("com.wyt.hht7.xx", "com.wyt.hengke.huohuotu.activity.AppActivity", "appname", value);
    }


    /**
     * 根据包名和类名启动,附带key，value
     *
     * @param packageName
     * @param className
     */
    public static void startApplicationWithComponent(String packageName, String className, String key, String value) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(key, value);
        ComponentName cn = createComponentName(packageName, className);
        intent.setComponent(cn);
        Utils.getApp().startActivity(intent);
    }

    /**
     * 根据包名和类名启动
     *
     * @param packageName
     * @param className
     */
    public static void startApplicationWithComponent(String packageName, String className) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ComponentName cn = createComponentName(packageName, className);
        intent.setComponent(cn);
        Utils.getApp().startActivity(intent);
    }

    private static ComponentName createComponentName(String packageName, String className) {
        return new ComponentName(packageName, className);
    }

    /**
     * 启动播放器
     *
     * @param lists    数据源
     * @param position 在数据源的位置
     */
    public static void startBoYueVideoPlayer(ArrayList<String> lists, int position) {
        Intent intent = new Intent(Config.BoYueAction.BOOYUE_MEDIAPLAYER_VIDEO_ACTION);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putStringArrayListExtra("videoInfoList", lists);
        intent.putExtra("position", position);
        Utils.getApp().startActivity(intent);
    }

}
