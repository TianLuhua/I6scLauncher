package com.boyue.boyuelauncher.settings.fragments.date_time_settings;

import android.app.AlarmManager;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.Calendar;

public class DateTimeSettingMode implements BaseMode {


    private Context mContext;
    private CallBack callBack;
    private ContentResolver resolver;
    private AlarmManager alarmManager;

    public DateTimeSettingMode(Context mContext, CallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.resolver = mContext.getContentResolver();
        this.alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
    }

    /**
     * 获取系统是否制动获取时间
     */
    public void getIsDateTimeAuto() {
        boolean isAuto;

        try {
            isAuto = android.provider.Settings.Global.getInt(resolver,
                    android.provider.Settings.Global.AUTO_TIME) > 0;
            LogUtils.e("tlh", "getIsDateTimeAuto =====11111=====");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            LogUtils.e("tlh", "getIsDateTimeAuto =====22222=====");
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
    public void setAutoDateTime(final boolean autoDateTime) {
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                android.provider.Settings.Global.putInt(resolver,
                        android.provider.Settings.Global.AUTO_TIME, autoDateTime ? 1 : 0);
            }
        });


    }


    /**
     * 设置系统 年、月、日
     *
     * @param year
     * @param month
     * @param day
     */
    public void setSysDate(int year, int month, int day) {
        LogUtils.e("tlh", "setSysDate year:" + year + ",month" + month + ",day:" + day);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        long when = c.getTimeInMillis();
        callCore(when);
    }

    /**
     * 设置系统时、分
     *
     * @param hour
     * @param minute
     */
    public void setSysTime(int hour, int minute) {
        LogUtils.e("tlh", "setSysTime hour:" + hour + ",minute:" + minute);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long when = c.getTimeInMillis();
        callCore(when);
    }

    private void callCore(long when) {
        if (when / 1000 < Integer.MAX_VALUE) {
            try {
                ((AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE)).setTime(when);
                callBack.setSuccess();
            } catch (Exception e) {
                callBack.setFail();
            }

        }
    }


    @Override
    public void onDestroy() {
        if (mContext != null)
            mContext = null;
        if (callBack != null)
            callBack = null;
        if (resolver != null)
            resolver = null;
        if (alarmManager != null)
            alarmManager = null;
    }

    /**
     * 口状态回调接口
     */
    public static interface CallBack {

        void setIsDateTimeAuto(boolean isAuto);

        void setSuccess();

        void setFail();

    }
}
