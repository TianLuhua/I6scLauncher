package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.HideSystemUIUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;
import com.boyue.boyuelauncher.widget.TitleBar;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_KALAOK_KUWOKGE_PACKAGE;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE_KEY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_KLOK_HHTCGS;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_KLOK_JDEG;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_KLOK_TTMTV;

public class HHT_klok_Main_Activity extends AppCompatActivity implements View.OnClickListener {


    private EnlargeAndNarrowAnimationView btn_01, btn_02, btn_03, btn_04;
    private TitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideSystemUIUtils.hideSystemUI(this);
        setContentView(R.layout.activity_hht_klok_main);
        inintView();
    }


    private void inintView() {
        titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle(R.string.hht_ly_klok);
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
        btn_01 = findViewById(R.id.hht_xt_klok_01_icon);
        btn_02 = findViewById(R.id.hht_xt_klok_02_icon);
        btn_03 = findViewById(R.id.hht_xt_klok_03_icon);
        btn_04 = findViewById(R.id.hht_xt_klok_04_icon);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hht_xt_klok_01_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_KLOK_TTMTV);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
            case R.id.hht_xt_klok_02_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_KLOK_JDEG);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
            case R.id.hht_xt_klok_03_icon:
                ActivityUtils.startApplicationWithPackageName(HHT_LY_KALAOK_KUWOKGE_PACKAGE);
                break;

            case R.id.hht_xt_klok_04_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_KLOK_HHTCGS);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
        }
    }

}
