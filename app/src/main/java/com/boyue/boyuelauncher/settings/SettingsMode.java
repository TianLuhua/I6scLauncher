package com.boyue.boyuelauncher.settings;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.BaseMode;

import java.util.List;
import java.util.Map;

public interface SettingsMode extends BaseMode {


    void getIndicatorItems();

    void getPagerFragments();


    public interface CallBack {

        void setIndicatorItems(List<Map<String, Object>> dataList);

        void setPagerFragments(List<Fragment> fragments);

    }

}
