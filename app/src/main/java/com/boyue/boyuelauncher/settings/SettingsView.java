package com.boyue.boyuelauncher.settings;

import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.BaseView;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.settings.entity.MenuBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SettingsView extends BaseView {

    void setPlayIndicatorItems(List<MenuBean> dataList);

    void disPlayPagerFragments(ArrayList<Fragment> fragments);

}
