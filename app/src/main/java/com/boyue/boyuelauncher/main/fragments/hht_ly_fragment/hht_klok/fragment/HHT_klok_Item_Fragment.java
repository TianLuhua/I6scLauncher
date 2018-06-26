package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.adapter.SystemFragmentPagerAdapter;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.List;

/**
 * Created by Tianluhua on 2018\6\26 0026.
 */
public class HHT_klok_Item_Fragment extends Fragment {

    private ViewPager pager;
    private SystemFragmentPagerAdapter adapter;

    public static HHT_klok_Item_Fragment newInstance() {
        return new HHT_klok_Item_Fragment();
    }

    public HHT_klok_Item_Fragment() {
        // Required empty public constructor

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hht_klok_item, null);
        inintView(rootView);
        return rootView;
    }

    private void inintView(View rootView) {
        LogUtils.e("tlh", "HHT_klok_Item_Fragment----inintView");
        pager = rootView.findViewById(R.id.pager);
        adapter = new SystemFragmentPagerAdapter(getFragmentManager());
        pager.setAdapter(adapter);
    }


    public void setFragments(List<Fragment> fragments) {
        adapter.setFragments(fragments);

    }

}
