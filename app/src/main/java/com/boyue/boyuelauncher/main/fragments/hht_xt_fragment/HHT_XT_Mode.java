package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseMode;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public interface HHT_XT_Mode extends BaseMode {

    public void getIconDrawble();



    public interface CallBack {

        void getIcon(Drawable iconDrawble);

    }


}
