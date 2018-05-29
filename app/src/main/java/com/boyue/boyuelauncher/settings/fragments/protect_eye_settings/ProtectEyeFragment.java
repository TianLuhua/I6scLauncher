package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseFragment;

public class ProtectEyeFragment extends BaseFragment {


    public static ProtectEyeFragment newInstance() {
        return new ProtectEyeFragment();
    }

    public ProtectEyeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_protect_eye, null, false);

        return rootview;
    }
}
