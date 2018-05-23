package com.boyue.boyuelauncher.settings;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;

/**
 * Created by Tianluhua on 2018/5/22.
 */

public class SettingsActivity extends AbstractMVPActivity<SettingsView, SettingsPersenter> {
    @Override
    protected int getContentViewID() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected SettingsPersenter createPresenter() {
        return new SettingsPersenter();
    }
}
