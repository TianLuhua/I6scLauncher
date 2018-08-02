package com.boyue.boyuelauncher.utils;

import android.content.Context;
import android.content.pm.IPackageDataObserver;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.RemoteException;
import android.os.StatFs;


import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by Tianluhua on 2018\8\2 0002.
 */
public class CacheClearHelper {

    public static void clearCache(Context context) {

        try {
            PackageManager packageManager = context.getPackageManager();
            Method localMethod = packageManager.getClass().getMethod("freeStorageAndNotify", Long.TYPE,
                    IPackageDataObserver.class);
            Long localLong = Long.valueOf(getEnvironmentSize() - 1L);
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = localLong;
            localMethod.invoke(packageManager, localLong, new IPackageDataObserver.Stub() {

                @Override
                public void onRemoveCompleted(String packageName, boolean succeeded) throws RemoteException {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long getEnvironmentSize() {
        File localFile = Environment.getDataDirectory();
        long l1;
        if (localFile == null)
            l1 = 0L;
        while (true) {
            String str = localFile.getPath();
            StatFs localStatFs = new StatFs(str);
            long l2 = localStatFs.getBlockSize();
            l1 = localStatFs.getBlockCount() * l2;
            return l1;
        }

    }


}
