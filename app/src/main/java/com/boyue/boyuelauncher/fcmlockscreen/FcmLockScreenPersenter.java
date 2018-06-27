package com.boyue.boyuelauncher.fcmlockscreen;

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

public class FcmLockScreenPersenter extends AbstractPresenter<FcmLockScreenView> {


    private SPUtils spUtils;
    private FcmLockScreenMode mode;
    private Context mContext;

    public FcmLockScreenPersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
        this.mode = new FcmLockScreenMode(mContext, new FcmLockScreenMode.CallBack() {
            @Override
            public void setUpdateClock(String date, String week, int time_0_Leve, int time_1_Leve, int time_2_Leve, int time_3_Leve) {
                FcmLockScreenView view = getView();
                if (view == null) return;
                view.setUpdateClock(date, week, time_0_Leve, time_1_Leve, time_2_Leve, time_3_Leve);
            }
        });
    }


    boolean matchingPwd(String pwd) {
        boolean isMactch = false;
        if (pwd.equals(spUtils.getString(Config.PassWordKey.BOOT_PWD_NAME))) {
            isMactch = true;
        }
        return isMactch;
    }

    public void cancleLockScreen(String action) {
        LogUtils.e("tlh", "cancleRegularRestAlarm");
        LockScreenUtils.cancleLockScreen(action);

    }


    public void startLockScreen(String action) {
        int time = spUtils.getInt((Config.PassWordKey.TIMING_LOCKING_KEY));
        if (time == Config.Settings.VALUE_NEVER) return;
        LockScreenUtils.startLockScreen(action, time);
    }


    public void updateClock() {
        if (mode == null) return;
        mode.updateClock();

    }

    public void registerReceiver() {

        if (mode == null) return;
        mode.registerReceiver();

    }

    public void unregisterReceiver() {
        if (mode == null) return;
        mode.unregisterReceiver();

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
