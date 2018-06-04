package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment;

import android.content.Context;

import com.boyue.boyuelauncher.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class HHT_LY_ModeImp implements HHT_LY_Mode {

    private Context mContext;
    private HHT_LY_Mode.CallBack callBack;


    public HHT_LY_ModeImp(Context mContext, HHT_LY_Mode.CallBack callBack) {
        this.callBack = callBack;
        this.mContext = mContext;
    }

    public void getIconDrawble() {
        Glide.with(mContext).load(R.mipmap.hht_ly_icon).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (callBack != null) {
                    callBack.getIcon(resource.getCurrent());
                }
            }
        });
    }

    @Override
    public void onDestroy() {

    }
}
