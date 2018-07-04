package com.boyue.boyuelauncher.settings.fragments.advance_settings.system_update;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.TextProgressBar;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018\7\3 0003.
 */
public class SystemUpdateActivity extends AbstractMVPActivity<SystemUpdateView, SystemUpdatePresenter> implements SystemUpdateView, View.OnClickListener {


    private TitleBar titleBar;
    private TextView currentVersionText;
    private TextProgressBar progressBar;
    private Button updateBtn;
    private TextView load_success;

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
        progressBar = findViewById(R.id.updating);
        progressBar.setMax(100);
        updateBtn = findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(this);
        load_success = findViewById(R.id.load_success);
        getPresenter().getCurrentVersion();

    }

    @Override
    protected SystemUpdatePresenter createPresenter() {
        return new SystemUpdatePresenter();
    }

    @Override
    public void setCurrentVersion(String currentVersion) {
        if (currentVersionText == null) return;
        currentVersionText.setText(getResources().getString(R.string.firmware_version_update_currentversion) + currentVersion);
    }

    @Override
    public void setSystemUpdateProgress(final int progress) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressBar == null) return;
                progressBar.setProgress(progress);
                if (progress == 100) {
                    progressBar.setVisibility(View.INVISIBLE);
                    updateBtn.setVisibility(View.VISIBLE);
                    load_success.setVisibility(View.VISIBLE);
                    updateBtn.setText(getResources().getString(R.string.immediately_reboot));
                }
            }
        });
    }


    @Override
    public void onClick(View v) {

        //按钮处于一键升级状态
        if (getResources().getString(R.string.update_one_key).equals(((Button) v).getText())) {
            LogUtils.e("tlh", "一键升级！");
            getPresenter().update();
            v.setVisibility(View.INVISIBLE);
        }

        //按钮处于立即重启状态
        if (getResources().getString(R.string.immediately_reboot).equals(((Button) v).getText())) {
            LogUtils.e("tlh", "立即重启！");
            getPresenter().reboot();
        }

    }
}
