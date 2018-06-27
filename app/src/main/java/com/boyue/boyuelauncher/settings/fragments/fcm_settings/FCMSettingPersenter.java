package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import android.content.Context;
import android.widget.Toast;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LockScreenUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import static com.boyue.boyuelauncher.Config.PassWordKey.DEFAULT_BOOTPWD;

public class FCMSettingPersenter extends AbstractPresenter<FCMSettingView> {

    private FCMSettingMode mode;
    private SPUtils spUtils;
    private Context mContext;

    public FCMSettingPersenter(Context mContext) {
        this.mContext = mContext;
        this.mode = new FCMSettingMode(new FCMSettingMode.CallBack() {
            @Override
            public void setSystmStatus(boolean pwdIsEnable, boolean pwdFcmIsEnable, int timingTime) {
                FCMSettingView view = getView();
                if (view == null) return;
                view.setSystmStatus(pwdIsEnable, pwdFcmIsEnable, timingTime);
            }
        });
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
    }

    //获取当起那界面UI的状态，用于初始化UI界面
    public void getSystmStatus() {
        if (mode == null) return;
        mode.getSystmStatus();
    }


    //判断当前防沉迷密码时候处于开启状态
    public void disAbleFcmPassWord(boolean isEnable) {
        if (mode == null) return;
        mode.disAbleFcmPassWord(isEnable);
    }

    //判断当前密码时候处于开启状态
    public void enAblePassword(boolean isEnable) {
        if (mode == null) return;
        mode.enAblePassword(isEnable);
    }

    //用户输入密码匹配
    public boolean matchingPwd(String pwd) {
        if (mode == null) return false;
        return mode.matchingPwd(pwd);
    }

    //保存密码到本地SP
    public boolean saveingPwd(String pwd) {
        if (mode == null) return false;
        return mode.saveingPwd(pwd);
    }

    public void setTimingLockTime(int timingLockTime) {
        if (spUtils == null) return;
        LogUtils.e("tlh", "FCMSettingPersenter---timingLockTime:" + timingLockTime);
        spUtils.put(Config.PassWordKey.TIMING_LOCKING_KEY, timingLockTime);

        switch (timingLockTime) {
            case Config.Settings.VALUE_NEVER:
                LockScreenUtils.cancleLockScreen(Config.BoYueAction.ONTIME_REST_ACTION);
                break;
            default:
                LockScreenUtils.startLockScreen(Config.BoYueAction.ONTIME_REST_ACTION, timingLockTime);
                break;
        }
    }

    public void reSetPassWord() {
        //恢复默认密码：0000
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                spUtils.put(Config.PassWordKey.BOOT_PWD_NAME, DEFAULT_BOOTPWD);
            }
        });
        Toast.makeText(mContext, R.string.reset_password_success, Toast.LENGTH_SHORT).show();

    }

}
