package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

import android.content.Context;
import android.content.res.TypedArray;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void getItemIcon() {
        final ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                //图标
                TypedArray icno = mContext.getResources().obtainTypedArray(R.array.hht_xt_items_image);
                //图标下的文字
                String name[] = mContext.getResources().getStringArray(R.array.hht_xt_items_text);
                for (int i = 0; i < name.length; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("img", icno.getResourceId(i, 0));
                    map.put("text", name[i]);
                    dataList.add(map);
                }
                if (callBack==null)return;
                callBack.setItemicon(dataList);
            }
        });
    }


    @Override
    public void onDestroy() {

    }
}
