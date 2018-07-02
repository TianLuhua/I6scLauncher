package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment.cartoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.HHT_zjyy_Main_Activity;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;
import com.boyue.boyuelauncher.widget.TitleBar;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_AIQIYI_CHILDNER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_ERGEDUODUO;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_XIAOQIELEYUAN;

/**
 * Created by Tianluhua on 2018\7\2 0002.
 */
public class HHT_CatToon_Main_Activity extends AppCompatActivity implements View.OnClickListener {


    private EnlargeAndNarrowAnimationView icon01, icon02, icon03;
    private TitleBar titleBar;


    public static HHT_zjyy_Main_Activity newInstance() {
        return new HHT_zjyy_Main_Activity();
    }

    public HHT_CatToon_Main_Activity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxbx_cartoon);
        initView();
    }


    private void initView() {
        titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle(R.string.hht_bx_item_name_102);
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
        icon01 = findViewById(R.id.hht_zxbx_01_icon);
        icon02 = findViewById(R.id.hht_zxbx_02_icon);
        icon03 = findViewById(R.id.hht_zxbx_03_icon);

        icon01.setOnClickListener(this);
        icon02.setOnClickListener(this);
        icon03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        LogUtils.e("tlh", "HHT_zjyy_Main_Activity---onAnimationEnd:" + v.getId());
        switch (v.getId()) {
            //爱奇艺少儿
            case R.id.hht_zxbx_01_icon:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_AIQIYI_CHILDNER);
                break;
            //小企鹅乐园
            case R.id.hht_zxbx_02_icon:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_XIAOQIELEYUAN);
                break;
            //儿歌多多
            case R.id.hht_zxbx_03_icon:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_ERGEDUODUO);
                break;
        }
    }

}
