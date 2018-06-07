package com.boyue.boyuelauncher.main.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.HideSystemUIUtils;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/6.
 */

public abstract class HHT_Abstract_Activity extends AppCompatActivity {

    protected TitleBar titleBar;
    protected FrameLayout content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideSystemUIUtils.hideSystemUI(this);
        setContentView(R.layout.activity_hht);
        initView();
    }

    protected void initView() {
        titleBar = findViewById(R.id.title_bar);
        content = findViewById(R.id.content);
        content.addView(getConentView(LayoutInflater.from(getApplicationContext())));

    }

    protected abstract View getConentView(LayoutInflater inflater);
}
