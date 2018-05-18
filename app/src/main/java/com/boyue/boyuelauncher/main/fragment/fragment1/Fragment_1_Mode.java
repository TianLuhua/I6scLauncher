package com.boyue.boyuelauncher.main.fragment.fragment1;

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
public class Fragment_1_Mode implements BaseMode {

    private Context mContext;

    public Fragment_1_Mode(Context mContext,CallBack callBack) {
        this.callBack=callBack;
        this.mContext=mContext;
    }

    public void getIconDrawble(){
        Glide.with(mContext).load(R.mipmap.ic_launcher_round).into(new SimpleTarget<GlideDrawable>(500,500) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (callBack!=null){
                    callBack.getIcon(resource.getCurrent());
                }
            }
        });
    }

    private CallBack callBack;
    public interface CallBack{

        void getIcon(Drawable iconDrawble);

    }



}
