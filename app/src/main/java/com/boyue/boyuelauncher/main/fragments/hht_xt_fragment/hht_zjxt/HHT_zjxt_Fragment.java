package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjxt;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.LazyLoadFragment;
import com.boyue.boyuelauncher.utils.ActivityUtils;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_300WORDS_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_300WORDS_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_ENGLISH_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_ENGLISH_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_HEALTH_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_HEALTH_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_KONWLEGE_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_KONWLEGE_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_MATH_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_MATH_PACKAGE_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_PINYIN_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_PINYIN_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_POETRY_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_POETRY_PACKAGE;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_zjxt_Fragment extends LazyLoadFragment implements View.OnClickListener {

    private AppCompatImageView item01, item02, item03, item04, item05, item06, item07;


    public static HHT_zjxt_Fragment newInstance() {
        return new HHT_zjxt_Fragment();
    }

    public HHT_zjxt_Fragment() {
        // Required empty public constructor
    }


    @Override
    protected int setContentView() {
        return R.layout.activity_hht_zjxt;
    }

    @Override
    protected void lazyLoad() {
        initView();
    }


    protected void initView() {

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
                //学前300字
                ActivityUtils.startApplicationWithComponent(HHT_XT_ZJXT_300WORDS_PACKAGE, HHT_XT_ZJXT_300WORDS_LAUNCHER);
                break;
            case R.id.hht_xt_zjxt_02_icon:
                //学前拼音
                ActivityUtils.startApplicationWithComponent(HHT_XT_ZJXT_PINYIN_PACKAGE, HHT_XT_ZJXT_PINYIN_LAUNCHER);
                break;
            case R.id.hht_xt_zjxt_03_icon:
                //学前英语
                ActivityUtils.startApplicationWithComponent(HHT_XT_ZJXT_ENGLISH_PACKAGE, HHT_XT_ZJXT_ENGLISH_LAUNCHER);
                break;
            case R.id.hht_xt_zjxt_04_icon:
                //基础数学
                ActivityUtils.startApplicationWithComponent(HHT_XT_ZJXT_MATH_PACKAGE, HHT_XT_ZJXT_MATH_PACKAGE_LAUNCHER);
                break;
            case R.id.hht_xt_zjxt_05_icon:
                //认知启蒙
                ActivityUtils.startApplicationWithComponent(HHT_XT_ZJXT_KONWLEGE_PACKAGE, HHT_XT_ZJXT_KONWLEGE_LAUNCHER);
                break;
            case R.id.hht_xt_zjxt_06_icon:
                //古诗16首
                ActivityUtils.startApplicationWithComponent(HHT_XT_ZJXT_POETRY_PACKAGE, HHT_XT_ZJXT_POETRY_LAUNCHER);
                break;
            case R.id.hht_xt_zjxt_07_icon:
                //健康教育
                ActivityUtils.startApplicationWithComponent(HHT_XT_ZJXT_HEALTH_PACKAGE, HHT_XT_ZJXT_HEALTH_LAUNCHER);
                break;
        }
    }


}
