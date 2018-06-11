package com.boyue.boyuelauncher.settings;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;

import java.util.List;
import java.util.Map;

public class SettingsPersenterImp extends SettingsPersenter {

    private Context mContext;
    private SettingsMode mode;
    private SPUtils spUtils;

    public SettingsPersenterImp(Context mContext) {
        this.mContext = mContext;
        this.mode = new SettingsModeImp(this.mContext, new SettingsMode.CallBack() {
            @Override
            public void setIndicatorItems(List<Map<String, Object>> dataList) {

                SettingsView view = getView();
                if (view == null) {
                    LogUtils.e("tlh", "SettingsPersenterImp----->:view == null");
                    return;
                }
                LogUtils.e("tlh", "SettingsPersenterImp----->:view != null");
                view.disPlayIndicatorItems(dataList);
            }

            @Override
            public void setPagerFragments(List<Fragment> fragments) {
                SettingsView view = getView();
                if (view == null) return;
                view.disPlayPagerFragments(fragments);
            }
        });
        this.spUtils = SPUtils.getInstance(Config.PWDKey.SPNMAE);
    }

    @Override
    void getIndicatorItems() {
        if (mode == null) return;
        mode.getIndicatorItems();
    }

    @Override
    boolean matchingPwd(String pwd) {
        boolean isMactch = false;
        if (pwd.equals(spUtils.getString(Config.PWDKey.BOOT_PWD_NAME))) {
            isMactch = true;
        }
        return isMactch;
    }

    public void getPagerFragments() {
        if (mode == null) return;
        mode.getPagerFragments();
    }
}
