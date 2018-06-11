package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.recervier.SystemSettingsService;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;


public class ProtectEyePersenter extends AbstractPresenter<ProtectEyeView> {

    private Context mContext;
    private SPUtils spUtils;
    private ProtectEyeMode mode;

    public ProtectEyePersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
        this.mode = new ProtectEyeMode(spUtils, new ProtectEyeMode.CallBack() {
            @Override
            public void setInitView(int screenBrightness, boolean isOpenProtectSener, int regularRestTime) {
                ProtectEyeView view = getView();
                if (view == null) return;
                view.setInitView(screenBrightness, isOpenProtectSener, regularRestTime);
            }
        });
    }

    //返回系统是否开启了密码设置
    public boolean hasePassWord() {

        return spUtils.getBoolean(Config.PWDKey.PWD_IS_ENABLE);
    }

    //保存定时休息的时间
    public void setRegularRestTime(int time) {
        LogUtils.e("tlh", "ProtectEyePersenter---setRegularRestTime----time:" + time);

        spUtils.put(Config.PWDKey.REGULARREST_KEY, time);
        switch (time) {
            case Config.Settings.VALUE_NEVER:
                cancleRegularRestAlarm();
                break;
            default:
                startRegularRestAlarm();
                break;
        }

    }

    public void cancleRegularRestAlarm() {
        LogUtils.e("tlh", "cancleRegularRestAlarm");
        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mContext, SystemSettingsService.class);
        intent.setAction(Config.BoYueAction.ACTION_SHUTDOWN);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        am.cancel(pendingIntent);
    }


    public void startRegularRestAlarm() {
        int time = spUtils.getInt((Config.PWDKey.REGULARREST_KEY));
        if (time == Config.Settings.VALUE_NEVER) return;
        LogUtils.e("tlh", "starRegularRestAlarm---time:" + time);
        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(mContext, SystemSettingsService.class);
        intent.setAction(Config.BoYueAction.ACTION_SHUTDOWN);
        PendingIntent pendingIntent = PendingIntent.getService(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, time + SystemClock.elapsedRealtime(), time, pendingIntent);
    }


    public void initView() {
        if (mode == null) return;
        mode.initView();

    }
}
