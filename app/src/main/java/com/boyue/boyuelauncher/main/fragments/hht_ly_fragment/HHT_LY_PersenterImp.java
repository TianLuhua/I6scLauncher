package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

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
}
