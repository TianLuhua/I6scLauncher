package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_XT_PersenterImp extends HHT_XT_Persenter {

    private Context mContext;
    private HHT_XT_Mode hht_xt_mode;


    public HHT_XT_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_xt_mode = new HHT_XT_ModeImp(mContext, new HHT_XT_Mode.CallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {
                HHT_XT_View view = getView();
                if (view != null) {
                    view.displayIocn(iconDrawble);
                }
            }

            @Override
            public void setItemicon(ArrayList<Map<String, Object>> list) {
                getView().setItemicon(list);
            }
        });
    }


    @Override
    public void getIconDrawble() {
        if (hht_xt_mode != null)
            hht_xt_mode.getIconDrawble();
    }

    @Override
    public void startHHT_XT_Activity(int position) {
        switch (position) {
            case 0:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_ZJYY);
                break;
            case 1:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_ZJXT);
                break;
            case 3:

                ActivityUtils.startApplicationWithPackageName("");

//
//                LogUtils.e("boyue", "启动播放器");
//                ArrayList<String> lists = new ArrayList<>();
//                lists.add("/mnt/usbhost1/Where_is_Bunny.mp4");
//                lists.add("/mnt/usbhost1/Hello_hello_how_are_you.mp4");
//                Intent intent = new Intent("com.booyue.android.mediaplayer.video");
//                intent.putStringArrayListExtra("videoInfoList", lists);
//                intent.putExtra("position", 1);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mContext.startActivity(intent);
//                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_ZJXT);
                break;
        }
    }

    @Override
    public void getItemIcon() {
        if (hht_xt_mode==null)return;
        hht_xt_mode. getItemIcon();
    }

}
