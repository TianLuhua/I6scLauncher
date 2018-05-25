package com.boyue.boyuelauncher.main;

import android.content.Context;

import com.boyue.boyuelauncher.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class MainModeImp implements MainMode {

    private CallBack callBack;
    private Context mContext;

    public MainModeImp(Context mContext, CallBack callBack) {
        this.callBack = callBack;
        this.mContext = mContext;
    }


    @Override
    public void getBGDrawble() {
        Glide.with(mContext).load(R.mipmap.bg_launcher).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (callBack != null) {
                    callBack.setBgDrawcle(resource.getCurrent());
                }
            }
        });

    }
}
