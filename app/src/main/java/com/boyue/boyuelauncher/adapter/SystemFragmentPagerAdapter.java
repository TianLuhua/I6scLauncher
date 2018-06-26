package com.boyue.boyuelauncher.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.DESKeySpec;

public class SystemFragmentPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragments = new ArrayList<Fragment>();

    public void setFragments(List<Fragment> fragments) {
        LogUtils.e("tlh", "SystemFragmentPagerAdapter----fragments.size():" + fragments.size());
        this.fragments = fragments;
        this.notifyDataSetChanged();
    }

    public SystemFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        LogUtils.e("tlh", "SystemFragmentPagerAdapter----getItem:" + position);
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return (fragments.size() > 0 ? fragments.size() : 0);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
