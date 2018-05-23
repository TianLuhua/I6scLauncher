package com.boyue.boyuelauncher.settings;

import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/5/22.
 */

public class SettingsActivity extends AbstractMVPActivity<SettingsView, SettingsPersenter> implements SettingsView {

    private TitleBar titleBar;


    @Override
    protected int getContentViewID() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView() {
        titleBar = findViewById(R.id.title_bar);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                ToastUtil.showShortToast(SettingsActivity.this, "onLeftIconClick");
                finish();

            }

            @Override
            public void onTitleClick(View view) {
                ToastUtil.showShortToast(SettingsActivity.this, "onTitleClick");

            }

            @Override
            public void onRightIconClick(View view) {
                ToastUtil.showShortToast(SettingsActivity.this, "onRightIconClick");

            }
        });
    }

    @Override
    protected SettingsPersenter createPresenter() {
        return new SettingsPersenter();
    }
}
