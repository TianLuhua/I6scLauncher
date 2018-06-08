package com.boyue.boyuelauncher.settings.fragments.date_time_settings;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.LogUtils;

public class DateTimeSettingMode implements BaseMode {


    private Context mContext;
    private CallBack callBack;
    private ContentResolver resolver;

    public DateTimeSettingMode(Context mContext, CallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.resolver = mContext.getContentResolver();
    }

    /**
     * 获取系统是否制动获取时间
     */
    public void getIsDateTimeAuto() {
        boolean isAuto;

        try {
            isAuto = android.provider.Settings.Global.getInt(resolver,
                    android.provider.Settings.Global.AUTO_TIME) > 0;
            LogUtils.e("tlh","getIsDateTimeAuto =====11111=====");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            LogUtils.e("tlh","getIsDateTimeAuto =====22222=====");
            isAuto = false;
        }
        if (callBack == null) return;
        callBack.setIsDateTimeAuto(isAuto);
    }

    /**
     * 设置系统是否自动获取时间
     *
     * @param autoDateTime
     */
    public void setAutoDateTime(boolean autoDateTime) {

        android.provider.Settings.Global.putInt(resolver,
                android.provider.Settings.Global.AUTO_TIME, autoDateTime ? 1 : 0);
    }


    @Override
    public void onDestroy() {

        if (mContext != null)
            mContext = null;
        if (callBack != null)
            callBack = null;
        if (resolver != null)
            resolver = null;
    }


    public static interface CallBack {

        void setIsDateTimeAuto(boolean isAuto);

    }
}
