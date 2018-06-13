package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.HHT_zjyy_Activity;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;

public class HHT_zjyy_Fragment extends Fragment implements View.OnClickListener {


    private EnlargeAndNarrowAnimationView icon01, icon02, icon03, icon04;


    public static HHT_zjyy_Fragment newInstance() {
        return new HHT_zjyy_Fragment();
    }

    public HHT_zjyy_Fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hht_zjyy, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        icon01 = rootView.findViewById(R.id.hht_xt_zjyy_01_icon);
        icon02 = rootView.findViewById(R.id.hht_xt_zjyy_02_icon);
        icon03 = rootView.findViewById(R.id.hht_xt_zjyy_03_icon);
        icon04 = rootView.findViewById(R.id.hht_xt_zjyy_04_icon);
        icon01.setOnClickListener(this);
        icon02.setOnClickListener(this);
        icon03.setOnClickListener(this);
        icon04.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mNotification_ZJYY = (Notification_ZJYY) context;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onClick(View v) {
        if (mNotification_ZJYY == null) return;
        int pageId = 0;
        switch (v.getId()) {
            case R.id.hht_xt_zjyy_01_icon:
                pageId = HHT_zjyy_Activity.BONNIE_XIAOBAN;
                mNotification_ZJYY.onChangedPage(pageId);
                break;
            case R.id.hht_xt_zjyy_02_icon:
                pageId = HHT_zjyy_Activity.BONNIE_ZHONGBAN;
                mNotification_ZJYY.onChangedPage(pageId);
                break;
            case R.id.hht_xt_zjyy_03_icon:
                pageId = HHT_zjyy_Activity.BONNIE_DABAN;
                mNotification_ZJYY.onChangedPage(pageId);
                break;
            case R.id.hht_xt_zjyy_04_icon:
                pageId = HHT_zjyy_Activity.DONNA_ENGLISH;
                mNotification_ZJYY.onChangedPage(pageId);
                break;
        }
    }

    private Notification_ZJYY mNotification_ZJYY;

    //点击不同的班型，切换到不同的Fragmnet
    public static interface Notification_ZJYY {
        void onChangedPage(int pageId);
    }

}
