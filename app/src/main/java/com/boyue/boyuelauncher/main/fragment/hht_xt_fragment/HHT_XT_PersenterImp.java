package com.boyue.boyuelauncher.main.fragment.hht_xt_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

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
        });
    }


    @Override
    public void getIconDrawble() {
        if (hht_xt_mode != null)
            hht_xt_mode.getIconDrawble();
    }
}
