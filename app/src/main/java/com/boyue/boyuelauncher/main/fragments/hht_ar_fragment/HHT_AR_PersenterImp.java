package com.boyue.boyuelauncher.main.fragments.hht_ar_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.utils.ActivityUtils;

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

    @Override
    public void startHHT_AR_Activity(int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                //火火兔AR---陆地动物
                ActivityUtils.startApplicationWithPackageName("com.o2design.animal");
                break;
            case 3:
                //火火兔AR---海洋动物园
                ActivityUtils.startApplicationWithPackageName("com.o2design.animalofocean");
                break;
            case 4:
                //火火兔AR---恐龙
                ActivityUtils.startApplicationWithPackageName("com.o2design.Dinosaurs");
                break;
            case 5:
                //火火兔AR---3D魔幻
                ActivityUtils.startApplicationWithPackageName("com.simon.MH3D");
                break;
        }
    }
}
