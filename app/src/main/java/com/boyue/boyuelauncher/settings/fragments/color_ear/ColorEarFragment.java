package com.boyue.boyuelauncher.settings.fragments.color_ear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseFragment;

public class ColorEarFragment extends BaseFragment {


    public static ColorEarFragment newInstance() {
        return new ColorEarFragment();
    }

    public ColorEarFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_color_ear, null, false);

        return rootview;
    }

}
