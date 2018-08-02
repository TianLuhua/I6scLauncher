package com.boyue.boyuelauncher.cleancache;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Environment;
import android.os.RemoteException;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;

import com.boyue.boyuelauncher.base.AbstractPresenter;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Tianluhua on 2018/5/14.
 */
public class CleanCachePersenter extends AbstractPresenter<CleanCacheView> {

    private PackageManager mPackageManager;
    private long totalCacheSize;


    public CleanCachePersenter(Context mContext) {
        this.mPackageManager = mContext.getPackageManager();
    }


    /**
     * 执行清除缓存操作
     */
    public void cleanSystemCache() {
        totalCacheSize = 0l;// 初始化
        queryToatalCache();// 给cacheSize赋值
        try {
            String methodName = "freeStorageAndNotify";// 想通过反射机制调用的方法名
            Class<?> parameterType1 = Long.TYPE;// 被反射的方法的第一个参数的类型
            Class<?> parameterType2 = IPackageDataObserver.class;// 被反射的方法的第二个参数的类型
            Method freeStorageAndNotify = mPackageManager.getClass().getMethod(
                    methodName, parameterType1, parameterType2);
            Long freeStorageSize = Long.valueOf(getDataDirectorySize());

            freeStorageAndNotify.invoke(mPackageManager, freeStorageSize,
                    new ClearCacheObj());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得手机中所有程序的缓存
     */
    private void queryToatalCache() {
        List<ApplicationInfo> apps = mPackageManager
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES
                        | PackageManager.GET_ACTIVITIES);
        String pkgName = "";
        for (ApplicationInfo info : apps) {
            pkgName = info.packageName;
            try {
                queryPkgCacheSize(pkgName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回/data目录的大小。
     */
    private long getDataDirectorySize() {
        File tmpFile = Environment.getDataDirectory();
        if (tmpFile == null) {
            return 0l;
        }
        String strDataDirectoryPath = tmpFile.getPath();
        StatFs localStatFs = new StatFs(strDataDirectoryPath);
        long size = localStatFs.getBlockSize() * localStatFs.getBlockCount();
        return size;
    }


    /**
     * 获得手机中所有程序的缓存
     */
    public long getSystemCaches() {
        List<ApplicationInfo> apps = mPackageManager
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES
                        | PackageManager.GET_ACTIVITIES);
        String pkgName = "";
        for (ApplicationInfo info : apps) {
            pkgName = info.packageName;
            try {
                queryPkgCacheSize(pkgName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return totalCacheSize;
    }


    /**
     * 取得指定包名的程序的缓存大小
     */
    private void queryPkgCacheSize(String pkgName) throws Exception {
        if (!TextUtils.isEmpty(pkgName)) {// pkgName不能为空
            // 使用放射机制得到PackageManager类的隐藏函数getPackageSizeInfo
            try {
                String methodName = "getPackageSizeInfo";// 想通过反射机制调用的方法名
                Class<?> parameterType1 = String.class;// 被反射的方法的第一个参数的类型
                Class<?> parameterType2 = IPackageStatsObserver.class;// 被反射的方法的第二个参数的类型
                Method getPackageSizeInfo = mPackageManager.getClass().getMethod(
                        methodName, parameterType1, parameterType2);
                getPackageSizeInfo.invoke(mPackageManager,// 方法所在的类
                        pkgName, new CleanCachePackageStateObserver());// 方法使用的参数

            } catch (Exception ex) {
                Log.wtf("tag", "queryPkgSize()-->NoSuchMethodException");
                ex.printStackTrace();
                throw ex; // 抛出异常
            }
        }
    }

    class CleanCachePackageStateObserver extends IPackageStatsObserver.Stub {
        @Override
        public void onGetStatsCompleted(PackageStats pStats, boolean succeeded) throws RemoteException {
            String packageName = pStats.packageName;
            long cacheSize = pStats.cacheSize;
            long codeSize = pStats.codeSize;
            long dataSize = pStats.dataSize;
            totalCacheSize += cacheSize;
            Log.e("CleanCachePersenter", "get---packageName:" + packageName + ",cacheSize:" + cacheSize);
        }
    }

    class ClearCacheObj extends IPackageDataObserver.Stub {
        @Override
        public void onRemoveCompleted(String packageName, final boolean succeeded) throws RemoteException {
            Log.e("CleanCachePersenter", "clean---packageName:" + packageName + "," + succeeded);
        }
    }

}