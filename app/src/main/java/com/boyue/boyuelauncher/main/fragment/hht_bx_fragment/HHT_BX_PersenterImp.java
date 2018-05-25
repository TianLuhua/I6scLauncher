package com.boyue.boyuelauncher.main.fragment.hht_bx_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_BX_PersenterImp extends HHT_BX_Persenter {

    private Context mContext;
    private HHT_BX_Mode hht_bx_mode;


    public HHT_BX_PersenterImp(Context mContext) {
        this.mContext=mContext;
        this.hht_bx_mode =new HHT_BX_ModeImp(mContext, new HHT_BX_Mode.CallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {
                HHT_BX_View view=getView();
                if (view!=null){
                    view.displayIocn(iconDrawble);
                }
            }
        });
    }


    @Override
    public void getIconDrawble() {
        if (hht_bx_mode !=null)
            hht_bx_mode.getIconDrawble();
    }
}
