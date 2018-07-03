package com.boyue.boyuelauncher.settings.fragments.advance_settings.system_update;

import android.view.View;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018\7\3 0003.
 */
public class SystemUpdateActivity extends AbstractMVPActivity<SystemUpdateView, SystemUpdatePresenter> implements SystemUpdateView {

    private TitleBar titleBar;
    private TextView currentVersionText;

    @Override
    protected int getContentViewID() {
        return R.layout.activity_system_update;
    }

    @Override
    protected void initView() {
        titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle(R.string.firmware_update);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                finish();
            }

            @Override
            public void onTitleClick(View view) {

            }

            @Override
            public void onRightIconClick(View view) {

            }
        });
        currentVersionText = findViewById(R.id.update_currentversion);
        getPresenter().getCurrentVersion();
    }

    @Override
    protected SystemUpdatePresenter createPresenter() {
        return new SystemUpdatePresenter();
    }

    @Override
    public void setCurrentVersion(String currentVersion) {
        if (currentVersionText == null) return;
        currentVersionText.setText(getResources().getString(R.string.firmware_version_update_currentversion)+currentVersion);
    }
}
