package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy;

import android.view.LayoutInflater;
import android.view.View;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_yspy_Activity extends HHT_Abstract_Activity implements View.OnClickListener {

    private EnlargeAndNarrowAnimationView zqyy, htcz, yszl;

    @Override
    protected View getConentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_hht_yspy, null);
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
        titleBar.setTitle(R.string.hht_ly_yspy);
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
        zqyy = findViewById(R.id.hht_xt_yspy_01_icon);
        htcz = findViewById(R.id.hht_xt_yspy_02_icon);
        yszl = findViewById(R.id.hht_xt_yspy_03_icon);

        zqyy.setOnClickListener(this);
        htcz.setOnClickListener(this);
        yszl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hht_xt_yspy_01_icon:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_YSPY_ZQYY);
                break;
            case R.id.hht_xt_yspy_02_icon:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_YSPY_HTCZ);
                break;
            case R.id.hht_xt_yspy_03_icon:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_YSPY_SYZL);
                break;
        }

    }
}
