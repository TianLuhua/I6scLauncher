package com.boyue.boyuelauncher.main.fragments.hht_ar_fragment;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public interface HHT_AR_Mode extends BaseMode {

    void getIconDrawble();

    void getItemIcon();


    public interface CallBack {

        void getIcon(Drawable iconDrawble);

        void setItemicon(List<APPEntity> appEntities);
    }


}
