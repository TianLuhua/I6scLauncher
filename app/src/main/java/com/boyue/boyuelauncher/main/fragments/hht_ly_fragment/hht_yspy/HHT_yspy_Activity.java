package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy;

import android.view.LayoutInflater;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;
import com.boyue.boyuelauncher.widget.TitleBar;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_THCZ;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_YSZL;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_ZQYY;

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
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
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
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, HHTLY_YSPY_ZQYY);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
            case R.id.hht_xt_yspy_02_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, HHTLY_YSPY_THCZ);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
            case R.id.hht_xt_yspy_03_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, HHTLY_YSPY_YSZL);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
        }

    }
}
