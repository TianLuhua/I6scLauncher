package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.htcz;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;

public class HHT_htcz_Fragment_01 extends Fragment {


    public static HHT_htcz_Fragment_01 newInstance() {
        return new HHT_htcz_Fragment_01();
    }

    public HHT_htcz_Fragment_01() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hht_yspy_htcz_01, null);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mNotification_01 = (Notification_01) context;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (mNotification_01 == null) return;
        mNotification_01.onHiddenChanged(hidden);
    }

    private Notification_01 mNotification_01;

    public static interface Notification_01 {
        void onHiddenChanged(boolean hidden);
    }
}
