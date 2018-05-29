package com.boyue.boyuelauncher.settings.fragments.auto_shutdown;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.base.BaseFragment;

public class AutoShueDownFragment extends AbstractMVPFragment<AutoShueDownView, AutoShueDownPersenter> implements AutoShueDownView {


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

        return rootview;
    }

    @Override
    protected AutoShueDownPersenter createPresenter() {
        return new AutoShueDownPersenter();
    }
}
