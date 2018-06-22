package com.boyue.boyuelauncher.settings;

import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.settings.entity.MenuBean;

import java.util.ArrayList;
import java.util.List;

public interface SettingsMode extends BaseMode {


    void getIndicatorItems();

    void getPagerFragments();


    public interface CallBack {

        void setPlayIndicatorItems(List<MenuBean> dataList);

        void setPagerFragments(ArrayList<Fragment> fragments);

    }

}
