package com.boyue.boyuelauncher.settings.fragments.color_ear;

import android.content.Context;
import android.os.CpuUsageInfo;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.SPUtils;

import static com.boyue.boyuelauncher.Config.PassWordKey.DEFAULT_LED_KEY;

public class ColorEarMode implements BaseMode {

    private CallBack callBack;
    private SPUtils spUtils;

    public ColorEarMode(Context mContext, CallBack callBack, SPUtils spUtils) {
        this.callBack = callBack;
        this.spUtils = spUtils;
    }

    public void getColorEarStatus() {

        if (callBack == null) return;
        callBack.colorEarStatus(spUtils.getInt(DEFAULT_LED_KEY));


    }


    public interface CallBack {
        void colorEarStatus(int isOpen);

    }

    @Override
    public void onDestroy() {
        spUtils = null;
        callBack = null;
    }
}
