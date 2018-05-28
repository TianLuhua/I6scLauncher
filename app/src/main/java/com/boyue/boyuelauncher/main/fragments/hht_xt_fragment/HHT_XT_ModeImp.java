package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

import android.content.Context;

import com.boyue.boyuelauncher.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class HHT_XT_ModeImp implements HHT_XT_Mode {

    private Context mContext;
    private CallBack callBack;


    public HHT_XT_ModeImp(Context mContext, CallBack callBack) {
        this.callBack = callBack;
        this.mContext = mContext;
    }

    public void getIconDrawble() {
        Glide.with(mContext).load(R.mipmap.hht_xt_icon).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (callBack != null) {
                    callBack.getIcon(resource.getCurrent());
                }
            }
        });
    }
}
