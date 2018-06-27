package com.boyue.boyuelauncher.main.fragments;

import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.HHT_klok_Main_Activity;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.jdeg.HHT_Klok_Jdeg_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.jdeg.HHT_Klok_Jdeg_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.jdeg.HHT_Klok_Jdeg_03_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_03_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_04_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_05_Fragment;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianluhua on 2018/6/26.
 */

public class HHT_Item_Persenter extends AbstractPresenter<HHT_Item_View> {

    private Fragment ttmtv_01, ttmtv_02, ttmtv_03, ttmtv_04, ttmtv_05, jdeg_01, jdeg_02, jdeg_03;

    public void getFragments(final int currentPage) {
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                List<Fragment> ttmvDataFragments = new ArrayList<>();
                switch (currentPage) {
                    case HHT_klok_Main_Activity.TTMTV:
                        ttmtv_01 = HHT_Klok_ttmtv_01_Fragment.newInstance();
                        ttmtv_02 = HHT_Klok_ttmtv_02_Fragment.newInstance();
                        ttmtv_03 = HHT_Klok_ttmtv_03_Fragment.newInstance();
                        ttmtv_04 = HHT_Klok_ttmtv_04_Fragment.newInstance();
                        ttmtv_05 = HHT_Klok_ttmtv_05_Fragment.newInstance();
                        ttmvDataFragments.clear();
                        ttmvDataFragments.add(ttmtv_01);
                        ttmvDataFragments.add(ttmtv_02);
                        ttmvDataFragments.add(ttmtv_03);
                        ttmvDataFragments.add(ttmtv_04);
                        ttmvDataFragments.add(ttmtv_05);
                        getView().setFragments(ttmvDataFragments);
                        break;
                    case HHT_klok_Main_Activity.JDEG:
                        jdeg_01 = HHT_Klok_Jdeg_01_Fragment.newInstance();
                        jdeg_02 = HHT_Klok_Jdeg_02_Fragment.newInstance();
                        jdeg_03 = HHT_Klok_Jdeg_03_Fragment.newInstance();
                        ttmvDataFragments.clear();
                        ttmvDataFragments.add(jdeg_01);
                        ttmvDataFragments.add(jdeg_02);
                        ttmvDataFragments.add(jdeg_03);
                        getView().setFragments(ttmvDataFragments);
                        break;
                }


            }
        });


    }
}
