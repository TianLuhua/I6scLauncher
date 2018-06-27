package com.boyue.boyuelauncher.protecteyelockscreen;

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


public class ProtectEyeLockScreenPersenter extends AbstractPresenter<ProtectEyeLockScreenView> {

    private Context mContext;
    private SPUtils spUtils;

    public ProtectEyeLockScreenPersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
    }

    boolean matchingPwd(String pwd) {
        boolean isMactch = false;
        if (pwd.equals(spUtils.getString(Config.PassWordKey.BOOT_PWD_NAME))) {
            isMactch = true;
        }
        return isMactch;
    }

    public void cancleRegularRestAlarm(String action) {
        LogUtils.e("tlh", "cancleRegularRestAlarm");
        LockScreenUtils.cancleLockScreen(action);

    }


    public void startRegularRestAlarm(String action) {
        int time = spUtils.getInt((Config.PassWordKey.REGULAR_REST_KEY));
        if (time == Config.Settings.VALUE_NEVER) return;
        LockScreenUtils.startLockScreen(action,time);
    }

    public void reSetPassWord() {
        //恢复默认密码：0000
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                spUtils.put(Config.PassWordKey.BOOT_PWD_NAME, DEFAULT_BOOTPWD);
            }
        });
        Toast.makeText(mContext, R.string.reset_password_success,Toast.LENGTH_SHORT).show();
    }
}
