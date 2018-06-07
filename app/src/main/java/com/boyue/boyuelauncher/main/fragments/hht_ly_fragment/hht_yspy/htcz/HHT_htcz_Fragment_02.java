package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.htcz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;

public class HHT_htcz_Fragment_02  extends Fragment {


    public static HHT_htcz_Fragment_02 newInstance() {
        return new HHT_htcz_Fragment_02();
    }

    public HHT_htcz_Fragment_02() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hht_yspy_htcz_02, null);
        return rootView;
    }

}
