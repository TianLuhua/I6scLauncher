package com.boyue.boyuelauncher.settings;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.settings.entity.MenuBean;
import com.boyue.boyuelauncher.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class SettingsPersenterImp extends SettingsPersenter {

    private Context mContext;
    private SettingsMode mode;
    private SPUtils spUtils;

    public SettingsPersenterImp(Context mContext) {
        this.mContext = mContext;
        this.mode = new SettingsModeImp(this.mContext, new SettingsMode.CallBack() {

            @Override
            public void setPlayIndicatorItems(List<MenuBean> dataList) {
                getView().setPlayIndicatorItems(dataList);

            }


            @Override
            public void setPagerFragments(ArrayList<Fragment> fragments) {
                SettingsView view = getView();
                if (view == null) return;
                view.disPlayPagerFragments(fragments);
            }
        });
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
    }

    @Override
    void getIndicatorItems() {
        if (mode == null) return;
        mode.getIndicatorItems();
    }

    @Override
    boolean matchingPwd(String pwd) {
        boolean isMactch = false;
        if (pwd.equals(spUtils.getString(Config.PassWordKey.BOOT_PWD_NAME))) {
            isMactch = true;
        }
        return isMactch;
    }

    @Override
    public boolean hasEnablePWD() {
        return spUtils.getBoolean(Config.PassWordKey.PWD_IS_ENABLE);
    }

    public void getPagerFragments() {
        if (mode == null) return;
        mode.getPagerFragments();
    }
}
