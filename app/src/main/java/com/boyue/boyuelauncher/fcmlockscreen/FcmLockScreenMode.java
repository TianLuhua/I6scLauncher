package com.boyue.boyuelauncher.fcmlockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FcmLockScreenMode implements BaseMode {

    private CallBack mCallBack;
    private Context mContext;

    private Date nowDate;
    private SimpleDateFormat format;


    public FcmLockScreenMode(Context mContext, CallBack mCallBack) {
        this.mContext = mContext;
        this.mCallBack = mCallBack;
        this.nowDate = new Date();
        this.format = new SimpleDateFormat("yyyy年MM月dd日_HHmm_EEEE");

    }


    public void updateClock() {
        if (mCallBack == null) return;
        String s = format.format(nowDate);
        LogUtils.e("tlh", "FcmLockScreenMode--updateClock:" + s);
        String[] ss = s.split("_");
        int size = ss[1].length();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            LogUtils.d("tlh", "FcmLockScreenMode:" + ss[1].charAt(i));
            array[i] = Integer.parseInt(String.valueOf(ss[1].charAt(i)));
        }
        mCallBack.setUpdateClock(ss[0], ss[2], array[0], array[1], array[2], array[3]);

    }

    //注册时间变化广播
    public void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        mContext.registerReceiver(mIntentRecever, filter);

    }

    //取消时间变化广播
    public void unregisterReceiver() {
        mContext.unregisterReceiver(mIntentRecever);
    }

    @Override
    public void onDestroy() {
        if (mIntentRecever != null)
            mIntentRecever = null;
        if (mCallBack != null)
            mCallBack = null;
    }


    //监听系统时间变化
    private BroadcastReceiver mIntentRecever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.e("tlh", "FcmLockScreenMode,时间变化了");
            nowDate.setTime(System.currentTimeMillis());
            updateClock();
        }
    };


    public static interface CallBack {
        void setUpdateClock(String date, String week, int time_0_Leve, int time_1_Leve, int time_2_Leve, int time_3_Leve);
    }
}
