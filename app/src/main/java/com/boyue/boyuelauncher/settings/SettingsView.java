package com.boyue.boyuelauncher.settings;

import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.BaseView;

import java.util.List;
import java.util.Map;

public interface SettingsView extends BaseView {

    void disPlayIndicatorItems(List<Map<String, Object>> dataList);

    void disPlayPagerFragments(List<Fragment> fragments);
}
