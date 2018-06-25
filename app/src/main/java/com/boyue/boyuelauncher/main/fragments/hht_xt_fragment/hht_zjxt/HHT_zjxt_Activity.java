package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjxt;

import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.widget.TitleBar;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_zjxt_Activity extends HHT_Abstract_Activity implements View.OnClickListener {

    private AppCompatImageView item01, item02, item03, item04, item05, item06, item07;

    @Override
    protected View getConentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_hht_zjxt, null);
    }

    @Override
    protected void slide_to_the_right() {

    }

    @Override
    protected void slide_to_the_left() {

    }

    @Override
    protected void initView() {
        super.initView();
        titleBar.setTitle(R.string.hht_xt_zjxt);
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
        item01 = findViewById(R.id.hht_xt_zjxt_01_icon);
        item02 = findViewById(R.id.hht_xt_zjxt_02_icon);
        item03 = findViewById(R.id.hht_xt_zjxt_03_icon);
        item04 = findViewById(R.id.hht_xt_zjxt_04_icon);
        item05 = findViewById(R.id.hht_xt_zjxt_05_icon);
        item06 = findViewById(R.id.hht_xt_zjxt_06_icon);
        item07 = findViewById(R.id.hht_xt_zjxt_07_icon);
        item01.setOnClickListener(this);
        item02.setOnClickListener(this);
        item03.setOnClickListener(this);
        item04.setOnClickListener(this);
        item05.setOnClickListener(this);
        item06.setOnClickListener(this);
        item07.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hht_xt_zjxt_01_icon:
                break;
            case R.id.hht_xt_zjxt_02_icon:
                break;
            case R.id.hht_xt_zjxt_03_icon:
                ActivityUtils.startApplicationWithComponent("air.RabbitEng", "air.RabbitEng.AppEntry");
                break;
            case R.id.hht_xt_zjxt_04_icon:
                break;
            case R.id.hht_xt_zjxt_05_icon:
                break;
            case R.id.hht_xt_zjxt_06_icon:
                break;
            case R.id.hht_xt_zjxt_07_icon:
                break;
        }
    }
}
