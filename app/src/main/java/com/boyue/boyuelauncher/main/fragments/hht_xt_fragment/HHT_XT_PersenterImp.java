package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.main.fragments.base.ItemDataCallBack;
import com.boyue.boyuelauncher.main.fragments.base.ItemMode;
import com.boyue.boyuelauncher.main.fragments.base.ItemPersenter;
import com.boyue.boyuelauncher.main.fragments.base.ItemView;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;

import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_DY_INTELLIGENCE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_MATH_LOGIC;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_SAFE_KNOWLEDGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_TRANDITIONAL_GX;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE_KEY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJXT;


/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_XT_PersenterImp extends ItemPersenter {

    private Context mContext;
    private ItemMode hht_xt_mode;


    public HHT_XT_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_xt_mode = new HHT_XT_ModeImp(mContext, new ItemDataCallBack() {
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
        if (hht_xt_mode != null)
            hht_xt_mode.getIconDrawble();
    }

    @Override
    public void startHHT_Activity(int position) {
        switch (position) {
            case 0:
                //早教英语
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_ZJYY);
                break;
            case 1:
                //早教学堂
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTXT_ZJXT);
                break;
            case 2:
                //数学逻辑
                ActivityUtils.startApplicationForGeLin(HHT_XT_MATH_LOGIC);
                break;
            case 3:
                //传统国学
                ActivityUtils.startApplicationForGeLin(HHT_XT_TRANDITIONAL_GX);
                break;
            case 4:
                //多元智能
                ActivityUtils.startApplicationForGeLin(HHT_XT_DY_INTELLIGENCE);
                break;
            case 5:
                //安全知识
                ActivityUtils.startApplicationForGeLin(HHT_XT_SAFE_KNOWLEDGE);
                break;
        }
    }

    @Override
    public void getItemIcon() {
        if (hht_xt_mode == null) return;
        hht_xt_mode.getItemIcon();
    }

    @Override
    public void detachView() {
        super.detachView();
        if (hht_xt_mode != null)
            hht_xt_mode.onDestroy();
    }
}
