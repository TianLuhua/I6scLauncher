package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;
import com.boyue.boyuelauncher.widget.TitleBar;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE_KEY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_BANGNI;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_BAODI;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_ENGLISH;

public class HHT_zjyy_Main_Activity extends AppCompatActivity implements View.OnClickListener {


    private EnlargeAndNarrowAnimationView icon01, icon02, icon03, icon04;
    private TitleBar titleBar;


    public static HHT_zjyy_Main_Activity newInstance() {
        return new HHT_zjyy_Main_Activity();
    }

    public HHT_zjyy_Main_Activity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hht_zjyy);
        initView();
    }


    private void initView() {
        titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle(R.string.hht_xt_item_name_101);
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
        icon02 = findViewById(R.id.hht_xt_zjyy_bangni_icon);
        icon03 = findViewById(R.id.hht_xt_zjyy_duona_icon);
        icon04 = findViewById(R.id.hht_xt_zjyy_baodi_icon);

        icon02.setOnClickListener(this);
        icon03.setOnClickListener(this);
        icon04.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        LogUtils.e("tlh", "HHT_zjyy_Main_Activity---onAnimationEnd:" + v.getId());
        switch (v.getId()) {
            case R.id.hht_xt_zjyy_bangni_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTXT_ZJYY_BANGNI);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
            case R.id.hht_xt_zjyy_duona_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTXT_ZJYY_ENGLISH);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
            case R.id.hht_xt_zjyy_baodi_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTXT_ZJYY_BAODI);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                break;
        }
    }

}
