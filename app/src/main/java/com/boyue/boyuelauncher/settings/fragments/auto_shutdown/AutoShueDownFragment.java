package com.boyue.boyuelauncher.settings.fragments.auto_shutdown;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.LogUtils;

public class AutoShueDownFragment extends AbstractMVPFragment<AutoShueDownView, AutoShueDownPersenter> implements AutoShueDownView, RadioGroup.OnCheckedChangeListener {

    //屏幕休眠
    private RadioGroup screenDormancyGroup;

    //自动关机
    private RadioGroup autoShutdownGroup;

    //定时关机
    private RadioGroup timingShutdownGroup;


    public static AutoShueDownFragment newInstance() {
        return new AutoShueDownFragment();
    }

    public AutoShueDownFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_auto_shutdown, null, false);
        initView(rootview);

        return rootview;
    }

    private void initView(View rootview) {

        screenDormancyGroup = rootview.findViewById(R.id.screen_dormancy_item_group);
        screenDormancyGroup.setOnCheckedChangeListener(this);

        autoShutdownGroup = rootview.findViewById(R.id.auto_shutdown_item_group);
        autoShutdownGroup.setOnCheckedChangeListener(this);

        timingShutdownGroup = rootview.findViewById(R.id.timing_locking_item_group);
        timingShutdownGroup.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            //屏幕休眠
            case R.id.screen_dormancy_item_00:
                LogUtils.e("tlh","screen_dormancy_item_00");
                break;
            case R.id.screen_dormancy_item_01:
                LogUtils.e("tlh","screen_dormancy_item_01");
                break;
            case R.id.screen_dormancy_item_02:
                LogUtils.e("tlh","screen_dormancy_item_02");
                break;
            case R.id.screen_dormancy_item_03:
                LogUtils.e("tlh","screen_dormancy_item_03");
                break;
            //自动关机
            case R.id.auto_shutdown_item_00:
                LogUtils.e("tlh","auto_shutdown_item_00");
                break;
            case R.id.auto_shutdown_item_01:
                LogUtils.e("tlh","auto_shutdown_item_01");
                break;
            case R.id.auto_shutdown_item_02:
                LogUtils.e("tlh","auto_shutdown_item_02");
                break;
            case R.id.auto_shutdown_item_03:
                LogUtils.e("tlh","auto_shutdown_item_03");
                break;
            //定时关机
            case R.id.timing_shutdown_item_00:
                LogUtils.e("tlh","timing_shutdown_item_00");
                break;
            case R.id.timing_shutdown_item_01:
                LogUtils.e("tlh","timing_shutdown_item_01");
                break;
            case R.id.timing_shutdown_item_02:
                LogUtils.e("tlh","timing_shutdown_item_02");
                break;
            case R.id.timing_shutdown_item_03:
                LogUtils.e("tlh","timing_shutdown_item_03");
                break;

        }

    }

    @Override
    protected AutoShueDownPersenter createPresenter() {
        return new AutoShueDownPersenter();
    }
}
