package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;
import com.boyue.boyuelauncher.widget.TitleBar;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE;

public class HHT_klok_Main_Activity extends AppCompatActivity implements View.OnClickListener {


    public static final int TTMTV = 0X001;
    public static final int JDEG = 0X002;

    private EnlargeAndNarrowAnimationView btn_01, btn_02, btn_03;
    private TitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hht_xt_klok_01_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, 0x001);
                break;
            case R.id.hht_xt_klok_02_icon:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, 0x002);
                break;
            case R.id.hht_xt_klok_03_icon:
                ToastUtil.showShortToast("打开酷我K歌！");
                break;
        }
    }

}
