package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.SystemPropertiesUtils;
import com.boyue.boyuelauncher.utils.Utils;

import java.io.File;

public class AdvanceSettingMode implements BaseMode {

    private CallBack callBack;


    public AdvanceSettingMode(CallBack callBack) {
        this.callBack = callBack;
    }


    public void getSystemParameter() {
        if (callBack == null) return;
        StringBuilder builder = new StringBuilder();
        builder.append(getRomAvailableSize());
        builder.append("/");
        builder.append(getRomTotalSize());


        String deviceModle = getDeviceModel();
        String firmwareVersion = getFirmwareVersion();

        //检查系统是否有更新
        boolean hasUpdateVersion = true;

        callBack.setSystemParameter(builder.toString(), deviceModle, firmwareVersion, hasUpdateVersion);
    }


    /**
     * 获得机身内存总大小
     *
     * @return
     */
    private String getRomTotalSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return Formatter.formatFileSize(Utils.getApp(), blockSize * totalBlocks);
    }

    /**
     * 获得机身可用内存
     *
     * @return
     */
    private String getRomAvailableSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return Formatter.formatFileSize(Utils.getApp(), blockSize * availableBlocks);
    }

    /**
     * 获取设备型号
     * <p>
     * ro.fota.device
     *
     * @return
     */
    private String getDeviceModel() {

        return SystemPropertiesUtils.getString("ro.product.model");
    }

    /**
     * 获取固件版本号
     * <p>
     * ro.build.version.incremental
     *
     * @return
     */
    private String getFirmwareVersion() {
        return SystemPropertiesUtils.getString("ro.build.version.incremental");
    }

    @Override
    public void onDestroy() {

        if (callBack != null) {
            callBack = null;
        }
    }


    public static interface CallBack {

        void setSystemParameter(String capacity, String deviceModle, String firmwareVersion, boolean hasUpdateVersion);

    }
}
