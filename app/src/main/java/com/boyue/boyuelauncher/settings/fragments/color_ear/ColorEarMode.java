package com.boyue.boyuelauncher.settings.fragments.color_ear;

import android.content.Context;
import android.os.CpuUsageInfo;

import com.boyue.boyuelauncher.base.BaseMode;

public class ColorEarMode implements BaseMode {

    private Context mContext;
    private CallBack callBack;
    private int colorEarStatus;

    public ColorEarMode(Context mContext, CallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
    }

    public void getColorEarStatus() {

        this.colorEarStatus = 1;
        /**
         * 这里需要和驱动交互,默认开启
         */

        if (callBack == null) return;
        callBack.colorEarStatus(colorEarStatus);


    }


    public interface CallBack {
        void colorEarStatus(int isOpen);

    }

    @Override
    public void onDestroy() {

    }
}
