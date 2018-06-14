package com.boyue.boyuelauncher.main;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.SPUtils;

import java.util.List;

/**
 * Created by Tianluhua on 2018/5/29.
 */
public class MainPresenterImp extends MainPersenter {

    private final MainMode mainMode;
    private final SPUtils spUtils;

    public MainPresenterImp(Context mContext) {
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
}
