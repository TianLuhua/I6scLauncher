package com.boyue.boyuelauncher.settings.fragments.auto_shutdown;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.boyue.boyuelauncher.Config;
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
        getPresenter().getInitView();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            //屏幕休眠
            case R.id.screen_dormancy_item_00:
                LogUtils.e("tlh", "screen_dormancy_item_00");
                getPresenter().setScreenTimeout(Config.Settings.VALUE_NEVER);
                break;
            case R.id.screen_dormancy_item_01:
                LogUtils.e("tlh", "screen_dormancy_item_01");
                getPresenter().setScreenTimeout(Config.Settings.VALUE_1M);
                break;
            case R.id.screen_dormancy_item_02:
                LogUtils.e("tlh", "screen_dormancy_item_02");
                getPresenter().setScreenTimeout(Config.Settings.VALUE_5M);
                break;
            case R.id.screen_dormancy_item_03:
                LogUtils.e("tlh", "screen_dormancy_item_03");
                getPresenter().setScreenTimeout(Config.Settings.VALUE_10M);
                break;

            //自动关机
            case R.id.auto_shutdown_item_00:
                LogUtils.e("tlh", "auto_shutdown_item_00");
                getPresenter().setAutoShutDownTime(Config.Settings.VALUE_NEVER);
                break;
            case R.id.auto_shutdown_item_01:
                LogUtils.e("tlh", "auto_shutdown_item_01");
                getPresenter().setAutoShutDownTime(Config.Settings.VALUE_15M);
                break;
            case R.id.auto_shutdown_item_02:
                LogUtils.e("tlh", "auto_shutdown_item_02");
                getPresenter().setAutoShutDownTime(Config.Settings.VALUE_30M);
                break;
            case R.id.auto_shutdown_item_03:
                LogUtils.e("tlh", "auto_shutdown_item_03");
                getPresenter().setAutoShutDownTime(Config.Settings.VALUE_60M);
                break;


            //定时关机
            case R.id.timing_shutdown_item_00:
                LogUtils.e("tlh", "timing_shutdown_item_00");
                setShutDownTime(Config.Settings.VALUE_NEVER);
                startShutDownTask(false);
                break;
            case R.id.timing_shutdown_item_01:
                LogUtils.e("tlh", "timing_shutdown_item_01");
                setShutDownTime(Config.Settings.VALUE_30M);
                startShutDownTask(true);
                break;
            case R.id.timing_shutdown_item_02:
                LogUtils.e("tlh", "timing_shutdown_item_02");
                setShutDownTime(Config.Settings.VALUE_60M);
                startShutDownTask(true);
                break;
            case R.id.timing_shutdown_item_03:
                LogUtils.e("tlh", "timing_shutdown_item_03");
                setShutDownTime(Config.Settings.VALUE_120M);
                startShutDownTask(true);
                break;

        }

    }

    /**
     * 设置定时关机的时间
     *
     * @param time 具体时间
     */
    private void setShutDownTime(int time) {
        getPresenter().setShutDownTime(time);

    }

    /**
     * 设置是否开启定时关机的任务
     *
     * @param start
     */
    private void startShutDownTask(boolean start) {
        getPresenter().startShutDownTask(start);
    }

    @Override
    protected AutoShueDownPersenter createPresenter() {
        return new AutoShueDownPersenter(getActivity().getApplicationContext());
    }


    @Override
    public void setInitView(int screenOffTimeout, int shutDwonTime, int autoShtDownTime) {
        LogUtils.e("tlh", "CurrentScreenTimeout：" + screenOffTimeout + ",shutDwonTime:" + shutDwonTime);
        switch (screenOffTimeout) {
            case Config.Settings.VALUE_NEVER:
                screenDormancyGroup.check(R.id.screen_dormancy_item_00);
                break;
            case Config.Settings.VALUE_1M:
                screenDormancyGroup.check(R.id.screen_dormancy_item_01);
                break;
            case Config.Settings.VALUE_5M:
                screenDormancyGroup.check(R.id.screen_dormancy_item_02);
                break;
            case Config.Settings.VALUE_10M:
                screenDormancyGroup.check(R.id.screen_dormancy_item_03);
                break;

        }
        switch (shutDwonTime) {
            case Config.Settings.VALUE_NEVER:
                timingShutdownGroup.check(R.id.timing_shutdown_item_00);
                break;
            case Config.Settings.VALUE_30M:
                timingShutdownGroup.check(R.id.timing_shutdown_item_01);
                break;
            case Config.Settings.VALUE_60M:
                timingShutdownGroup.check(R.id.timing_shutdown_item_02);
                break;
            case Config.Settings.VALUE_120M:
                timingShutdownGroup.check(R.id.timing_shutdown_item_03);
                break;
        }

        switch (autoShtDownTime) {
            case Config.Settings.VALUE_NEVER:
                autoShutdownGroup.check(R.id.auto_shutdown_item_00);
                break;
            case Config.Settings.VALUE_15M:
                autoShutdownGroup.check(R.id.auto_shutdown_item_01);
                break;
            case Config.Settings.VALUE_30M:
                autoShutdownGroup.check(R.id.auto_shutdown_item_02);
                break;
            case Config.Settings.VALUE_60M:
                autoShutdownGroup.check(R.id.auto_shutdown_item_03);
                break;
        }
    }
}
