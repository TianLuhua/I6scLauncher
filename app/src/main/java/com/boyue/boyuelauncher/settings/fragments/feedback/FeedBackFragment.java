package com.boyue.boyuelauncher.settings.fragments.feedback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.base.BaseFragment;

public class FeedBackFragment extends AbstractMVPFragment<FeedBackView, FeedBackPersenter> implements FeedBackView {


    public static FeedBackFragment newInstance() {
        return new FeedBackFragment();
    }

    public FeedBackFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_feedback, null, false);

        return rootview;
    }

    @Override
    protected FeedBackPersenter createPresenter() {
        return new FeedBackPersenter();
    }
}
