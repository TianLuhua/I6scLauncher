package com.boyue.boyuelauncher.main.fragments.hht_ar_fragment;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseMode;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public interface HHT_AR_Mode extends BaseMode {

    void getIconDrawble();
    void getItemIcon();


    public interface CallBack {

        void getIcon(Drawable iconDrawble);
        void setItemicon(ArrayList<Map<String, Object>> list);
    }


}
