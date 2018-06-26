package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.HHT_klok_Activity;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;

public class HHT_klok_Main_Fragment extends Fragment implements View.OnClickListener {


    private EnlargeAndNarrowAnimationView btn_01, btn_02, btn_03;

    public static HHT_klok_Main_Fragment newInstance() {
        return new HHT_klok_Main_Fragment();
    }

    public HHT_klok_Main_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mNotification_KLOK = (Notification_KLOK) context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hht_klok_main, null);
        inintView(rootView);
        return rootView;
    }

    private void inintView(View rootView) {
        btn_01 = rootView.findViewById(R.id.hht_xt_klok_01_icon);
        btn_02 = rootView.findViewById(R.id.hht_xt_klok_02_icon);
        btn_03 = rootView.findViewById(R.id.hht_xt_klok_03_icon);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hht_xt_klok_01_icon:
                if (mNotification_KLOK == null) return;
                mNotification_KLOK.onChangedPage(HHT_klok_Activity.TTMTV);
                break;
            case R.id.hht_xt_klok_02_icon:
                mNotification_KLOK.onChangedPage(HHT_klok_Activity.JDEG);
                break;
            case R.id.hht_xt_klok_03_icon:
                ToastUtil.showShortToast("打开酷我K歌！");
                break;
        }
    }


    private Notification_KLOK mNotification_KLOK;

    //点击不同的班型，切换到不同的Fragmnet
    public static interface Notification_KLOK {
        void onChangedPage(int pageId);
    }
}
