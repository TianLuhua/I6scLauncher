package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.base.BaseFragment;

public class VolumeSettingFragment extends AbstractMVPFragment<VolumeSettingView, VolumeSettingPersenter>implements VolumeSettingView {


    public static VolumeSettingFragment newInstance() {
        return new VolumeSettingFragment();
    }

    public VolumeSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_voleme_setting, null, false);

        return rootview;
    }

    @Override
    protected VolumeSettingPersenter createPresenter() {
        return new VolumeSettingPersenter();
    }
}
