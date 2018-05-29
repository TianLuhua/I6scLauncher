package com.boyue.boyuelauncher.settings.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class SystemSettingFragmentPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragments;


    public SystemSettingFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        if (fragments == null)
            return null;
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return (fragments.size() > 0 ? fragments.size() : 0);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
