package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.ttmtv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;

public class HHT_Klok_ttmtv_05_Fragment extends Fragment implements View.OnClickListener {


    public static HHT_Klok_ttmtv_05_Fragment newInstance() {
        return new HHT_Klok_ttmtv_05_Fragment();
    }

    public HHT_Klok_ttmtv_05_Fragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hht_klok_ttmtv_05, null);
        inintView(rootView);
        return rootView;
    }


    private EnlargeAndNarrowAnimationView btn_01, btn_02, btn_03;

    private void inintView(View rootView) {
        btn_01 = rootView.findViewById(R.id.hht_ly_yzyx_01_icon);
        btn_02 = rootView.findViewById(R.id.hht_ly_yzyx_02_icon);
        btn_03 = rootView.findViewById(R.id.hht_ly_yzyx_03_icon);

        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hht_ly_yzyx_01_icon:
                break;
            case R.id.hht_ly_yzyx_02_icon:
                break;
            case R.id.hht_ly_yzyx_03_icon:
                break;

        }

    }
}
