package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

import android.content.Context;
import android.content.res.TypedArray;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.ItemDataCallBack;
import com.boyue.boyuelauncher.main.fragments.base.ItemMode;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

public class HHT_XT_ModeImp implements ItemMode {

    private Context mContext;
    private ItemDataCallBack callBack;


    public HHT_XT_ModeImp(Context mContext, ItemDataCallBack callBack) {
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

    @Override
    public void getItemIcon() {
        final List<APPEntity> appEntities = new ArrayList<APPEntity>();

        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                //图标
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_xt_items_image);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_xt_items_text);

                for (int i = 0; i < names.length(); i++) {
                    APPEntity appEntity = new APPEntity();
                    appEntity.setNameRes(names.getResourceId(i, 0));
                    appEntity.setIconRes(icnos.getResourceId(i, 0));
                    appEntities.add(appEntity);
                }
                icnos.recycle();
                names.recycle();
                if (callBack == null) return;
                callBack.setItemicon(appEntities);
            }
        });
    }


    @Override
    public void onDestroy() {
        if (mContext != null)
            mContext = null;
        if (callBack != null)
            callBack = null;
    }
}
