package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.utils.ActivityUtils;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_LY_PersenterImp extends HHT_LY_Persenter {

    private Context mContext;
    private HHT_LY_Mode hht_ly_mode;


    public HHT_LY_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_ly_mode = new HHT_LY_ModeImp(mContext, new HHT_LY_Mode.CallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {
                HHT_LY_View view = getView();
                if (view != null) {
                    view.displayIocn(iconDrawble);
                }
            }
        });
    }


    @Override
    public void getIconDrawble() {
        if (hht_ly_mode != null)
            hht_ly_mode.getIconDrawble();
    }

    @Override
    public void startHHT_LY_Activity(int position) {
        switch (position){
            case 0:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_KLOK);
                break;
            case 3:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_YSPY);
                break;
            case 4:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_YZYX);
                break;
        }
    }
}
