package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.base.BaseFragment;

public class AdvanceSettingFragment extends AbstractMVPFragment<AdvanceSettingView, AdvanceSettingPersenter> implements AdvanceSettingView, View.OnClickListener {


    private TextView deviceModelText;
    private TextView firmwareVersionText;
    private TextView freeCapacityText;
    private AppCompatImageView factorySettingSwitch;


    public static AdvanceSettingFragment newInstance() {
        return new AdvanceSettingFragment();
    }

    public AdvanceSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_advance, null, false);

        initView(rootview);

        return rootview;
    }

    private void initView(View rootview) {
        deviceModelText = rootview.findViewById(R.id.device_model_value);
        firmwareVersionText = rootview.findViewById(R.id.firmware_version_value);
        freeCapacityText = rootview.findViewById(R.id.free_capacity_value);
        factorySettingSwitch = rootview.findViewById(R.id.factory_setting_switch);
        factorySettingSwitch.setOnClickListener(this);
    }

    @Override
    protected AdvanceSettingPersenter createPresenter() {
        return new AdvanceSettingPersenter();
    }

    @Override
    public void onClick(View v) {

    }
}
