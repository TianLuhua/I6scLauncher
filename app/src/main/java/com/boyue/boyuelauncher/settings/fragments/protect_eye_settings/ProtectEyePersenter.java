package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import android.content.Context;
import android.content.Intent;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.service.SystemSettingsService;
import com.boyue.boyuelauncher.utils.LockScreenUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;


public class ProtectEyePersenter extends AbstractPresenter<ProtectEyeView> {

    private Context mContext;
    private SPUtils spUtils;
    private ProtectEyeMode mode;

    public ProtectEyePersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
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

        return spUtils.getBoolean(Config.PassWordKey.PWD_IS_ENABLE);
    }

    //保存定时休息的时间
    public void setRegularRestTime(int time) {
        LogUtils.e("tlh", "ProtectEyePersenter---setRegularRestTime----time:" + time);

        spUtils.put(Config.PassWordKey.REGULAR_REST_KEY, time);
        switch (time) {
            case Config.Settings.VALUE_NEVER:
                LockScreenUtils.cancleLockScreen(Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION);
                break;
            default:
                LockScreenUtils.startLockScreen(Config.BoYueAction.ONTIME_LOCKSCREEN_ACTION, time);
                break;
        }

    }

    /**
     * 初始界面UI
     */
    public void initView() {
        if (mode == null) return;
        mode.initView();

    }

    /**
     * 保存护眼传感器的状态
     *
     * @param isEnbale
     */
    public void sevaProtectSensorStatus(boolean isEnbale) {
        LogUtils.e("tlh", "ProtectEyePersenter---sevaProtectSensorStatus:" + isEnbale);
        if (spUtils == null) return;
        spUtils.put(Config.PassWordKey.PROTECT_EYE_SENSOR_ENABLE_KEY, isEnbale);

        //通知SystemSettingsService，当前用户操作护眼传感器的状态
        Intent intent = new Intent(mContext, SystemSettingsService.class);
        intent.setAction(isEnbale ? Config.BoYueAction.PROTECTSENSOR_ACTION_OPEN : Config.BoYueAction.PROTECTSENSOR_ACTION_CLOSE);
        mContext.startService(intent);

    }


}
