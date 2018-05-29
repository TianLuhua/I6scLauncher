package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseFragment;

public class FCMSettingFragment extends BaseFragment {


    public static FCMSettingFragment newInstance() {
        return new FCMSettingFragment();
    }

    public FCMSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_fcm_setting, null, false);

        return rootview;
    }
}
