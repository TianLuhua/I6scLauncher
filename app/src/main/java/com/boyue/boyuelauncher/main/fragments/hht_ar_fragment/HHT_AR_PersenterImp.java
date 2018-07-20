package com.boyue.boyuelauncher.main.fragments.hht_ar_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.main.fragments.base.ItemDataCallBack;
import com.boyue.boyuelauncher.main.fragments.base.ItemMode;
import com.boyue.boyuelauncher.main.fragments.base.ItemPersenter;
import com.boyue.boyuelauncher.main.fragments.base.ItemView;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;

import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_AR_3D_MAGIC;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_AR_DINOSAUR;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_AR_ENGLISH;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_AR_LAND_ANIMAL;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_AR_MATH;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_AR_OCEAN_ANIMAL;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_AR_PersenterImp extends ItemPersenter {

    private Context mContext;
    private ItemMode hht_ar_mode;


    public HHT_AR_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_ar_mode = new HHT_AR_ModeImp(mContext, new ItemDataCallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {
                ItemView view = getView();
                if (view != null) {
                    view.displayIocn(iconDrawble);
                }
            }

            @Override
            public void setItemicon(List<APPEntity> appEntities) {
                getView().setItemicon(appEntities);
            }
        });
    }


    @Override
    public void getIconDrawble() {
        if (hht_ar_mode != null)
            hht_ar_mode.getIconDrawble();
    }

    @Override
    public void startHHT_Activity(int position) {
        switch (position) {
            //火火兔AR---AR英语
            case 0:
                ActivityUtils.startApplicationWithPackageName(HHT_AR_ENGLISH);
                break;
            case 1:
                //火火兔AR---AR数学
                ActivityUtils.startApplicationWithPackageName(HHT_AR_MATH);
                break;
            case 2:
                //火火兔AR---陆地动物
                ActivityUtils.startApplicationWithPackageName(HHT_AR_LAND_ANIMAL);
                break;
            case 3:
                //火火兔AR---海洋动物园
                ActivityUtils.startApplicationWithPackageName(HHT_AR_OCEAN_ANIMAL);
                break;
            case 4:
                //火火兔AR---恐龙
                ActivityUtils.startApplicationWithPackageName(HHT_AR_DINOSAUR);
                break;
            case 5:
                //火火兔AR---3D魔幻
                ActivityUtils.startApplicationWithPackageName(HHT_AR_3D_MAGIC);
                break;
        }
    }

    @Override
    public void getItemIcon() {
        if (hht_ar_mode == null) return;
        hht_ar_mode.getItemIcon();

    }

    @Override
    public void detachView() {
        super.detachView();
        if (hht_ar_mode != null)
            hht_ar_mode.onDestroy();
    }

}
