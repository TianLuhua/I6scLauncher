package com.boyue.boyuelauncher.main.fragment.hht_bx_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.BaseMode;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public interface HHT_BX_Mode extends BaseMode {

    void getIconDrawble();



    public interface CallBack {

        void getIcon(Drawable iconDrawble);

    }


}
