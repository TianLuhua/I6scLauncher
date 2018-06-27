package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;

import java.util.List;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public interface HHT_XT_Mode extends BaseMode {

    void getIconDrawble();

    void getItemIcon();


    public interface CallBack {

        void getIcon(Drawable iconDrawble);

        void setItemicon(List<APPEntity> appEntities);

    }


}
