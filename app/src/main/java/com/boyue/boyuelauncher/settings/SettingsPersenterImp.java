package com.boyue.boyuelauncher.settings;

import android.content.Context;

import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.List;
import java.util.Map;

public class SettingsPersenterImp extends SettingsPersenter {

    private Context mContext;
    private SettingsMode mode;

    public SettingsPersenterImp(Context mContext) {
        this.mContext = mContext;
        this.mode = new SettingsModeImp(this.mContext, new SettingsMode.CallBack() {
            @Override
            public void indicatorItems(List<Map<String, Object>> dataList) {

                SettingsView view = getView();
                if (view == null) {
                    LogUtils.e("tlh", "SettingsPersenterImp----->:view == null");
                    return;
                }
                LogUtils.e("tlh", "SettingsPersenterImp----->:view != null");
                view.disPlayIndicatorItems(dataList);
            }
        });
    }

    @Override
    void getIndicatorItems() {
        if (mode == null) return;
        mode.getIndicatorItems();
    }
}
