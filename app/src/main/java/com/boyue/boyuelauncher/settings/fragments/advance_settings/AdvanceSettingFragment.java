package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.base.BaseFragment;

public class AdvanceSettingFragment extends AbstractMVPFragment<AdvanceSettingView, AdvanceSettingPersenter> implements AdvanceSettingView {


    private CheckBox colorEarSwitch;


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
    }

    @Override
    protected AdvanceSettingPersenter createPresenter() {
        return new AdvanceSettingPersenter();
    }
}
