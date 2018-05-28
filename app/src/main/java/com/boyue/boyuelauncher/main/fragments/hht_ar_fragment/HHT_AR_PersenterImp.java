package com.boyue.boyuelauncher.main.fragments.hht_ar_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_AR_PersenterImp extends HHT_AR_Persenter {

    private Context mContext;
    private HHT_AR_Mode hht_ar_mode;


    public HHT_AR_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_ar_mode = new HHT_AR_ModeImp(mContext, new HHT_AR_Mode.CallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {
                HHT_AR_View view = getView();
                if (view != null) {
                    view.displayIocn(iconDrawble);
                }
            }
        });
    }


    @Override
    public void getIconDrawble() {
        if (hht_ar_mode != null)
            hht_ar_mode.getIconDrawble();
    }
}
