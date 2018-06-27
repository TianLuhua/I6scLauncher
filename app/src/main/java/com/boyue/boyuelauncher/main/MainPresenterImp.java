package com.boyue.boyuelauncher.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.List;

import static com.boyue.boyuelauncher.Config.PassWordKey.DEFAULT_BOOTPWD;

/**
 * Created by Tianluhua on 2018/5/29.
 */
public class MainPresenterImp extends MainPersenter {

    private final MainMode mainMode;
    private final SPUtils spUtils;
    private Context mContext;

    public MainPresenterImp(Context mContext) {
        this.mContext = mContext;
        mainMode = new MainModeImp(mContext, new MainMode.CallBack() {
            @Override
            public void setCurrentVolume(int currentVolume) {
                MainView view = getView();
                if (view != null) {
                    view.setCurrentVolune(currentVolume);
                }
            }

            @Override
            public void volumeChange(int changedVolume) {
                MainView view = getView();
                if (view == null) return;
                view.setCurrentVolune(changedVolume);
            }

            @Override
            public void setFragments(List<Fragment> fragments) {
                getView().setFragments(fragments);
            }
        });
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
    }

    @Override
    void getCurrentVolune() {
        if (mainMode == null) return;
        mainMode.getCurrentVolume();

    }

    @Override
    boolean matchingPwd(String pwd) {

        return pwd.equals(spUtils.getString(Config.PassWordKey.BOOT_PWD_NAME));
    }

    @Override
    public boolean hasEnableFCMPWD() {
        return spUtils.getBoolean(Config.PassWordKey.FCM_PWD_NAME);
    }

    @Override
    public void getFragments() {
        if (mainMode == null) return;
        mainMode.getFragments();
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mainMode == null) return;
        mainMode.onDestroy();
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
