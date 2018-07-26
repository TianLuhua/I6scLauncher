package com.boyue.boyuelauncher.utils;

import java.io.File;

/**
 * Created by Tianluhua on 2018\7\26 0026.
 */
public class FileUtils {

    public static boolean hasFile(String path) {
        if (new File(path).list() != null) {
            LogUtils.e("tlh", "path--->:" + path + "," + "true");
            return true;
        } else {
            LogUtils.e("tlh", "path--->:" + path + "," + "false");
            return false;
        }
    }
}
