package com.boyue.boyuelauncher.settings.fragments.date_time_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.base.BaseFragment;

public class DateTimeSettingFragment extends AbstractMVPFragment<DateTimeSettingView, DateTimeSettingPersenter> implements DateTimeSettingView {


    public static DateTimeSettingFragment newInstance() {
        return new DateTimeSettingFragment();
    }

    public DateTimeSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_date_time_setting, null, false);
        initView(rootview);
        return rootview;
    }

    private void initView(View rootview) {

    }

    @Override
    protected DateTimeSettingPersenter createPresenter() {
        return new DateTimeSettingPersenter();
    }
}
