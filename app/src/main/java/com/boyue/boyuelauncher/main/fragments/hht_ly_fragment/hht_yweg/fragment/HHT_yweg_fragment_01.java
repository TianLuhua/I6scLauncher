package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;

public class HHT_yweg_fragment_01 extends Fragment implements View.OnClickListener {

    private EnlargeAndNarrowAnimationView btn_01, btn_02, btn_03, btn_04, btn_05, btn_06, btn_07, btn_08;


    public static HHT_yweg_fragment_01 newInstance() {
        return new HHT_yweg_fragment_01();
    }

    public HHT_yweg_fragment_01() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hht_ly_yweg_01, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        btn_01 = rootView.findViewById(R.id.hht_ly_yzyx_01_icon);
        btn_02 = rootView.findViewById(R.id.hht_ly_yzyx_02_icon);
        btn_03 = rootView.findViewById(R.id.hht_ly_yzyx_03_icon);
        btn_04 = rootView.findViewById(R.id.hht_ly_yzyx_04_icon);
        btn_05 = rootView.findViewById(R.id.hht_ly_yzyx_05_icon);
        btn_06 = rootView.findViewById(R.id.hht_ly_yzyx_06_icon);
        btn_07 = rootView.findViewById(R.id.hht_ly_yzyx_07_icon);
        btn_08 = rootView.findViewById(R.id.hht_ly_yzyx_08_icon);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);
        btn_05.setOnClickListener(this);
        btn_06.setOnClickListener(this);
        btn_07.setOnClickListener(this);
        btn_08.setOnClickListener(this);
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
            case R.id.hht_ly_yzyx_04_icon:
                break;
            case R.id.hht_ly_yzyx_05_icon:
                break;
            case R.id.hht_ly_yzyx_06_icon:
                break;
            case R.id.hht_ly_yzyx_07_icon:
                break;
            case R.id.hht_ly_yzyx_08_icon:
                break;
        }
    }

}
