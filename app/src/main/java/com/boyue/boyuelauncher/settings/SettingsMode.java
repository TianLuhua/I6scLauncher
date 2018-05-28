package com.boyue.boyuelauncher.settings;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseMode;

import java.util.List;
import java.util.Map;

public interface SettingsMode extends BaseMode {


    void getIndicatorItems();


    public interface CallBack {

        void indicatorItems(List<Map<String, Object>> dataList);

    }

}
