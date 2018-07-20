package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment;

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
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_BABY_CAMERA;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_KING_STORY;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE_KEY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YWEG;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YZYX;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_LY_PersenterImp extends ItemPersenter {

    private Context mContext;
    private ItemMode hht_ly_mode;


    public HHT_LY_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_ly_mode = new HHT_LY_ModeImp(mContext, new ItemDataCallBack() {
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
        if (hht_ly_mode != null)
            hht_ly_mode.getIconDrawble();
    }

    @Override
    public void startHHT_Activity(int position) {
        switch (position) {
            //卡拉ok
            case 0:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_KLOK);
                break;
            //英文儿歌
            case 1:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YWEG);
                break;
            //故事王国
            case 2:
                ActivityUtils.startApplicationForGeLin(HHT_LY_KING_STORY);
                break;
            //艺术培养
            case 3:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YSPY);
//                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_YSPY);
                break;
            //益智游戏
            case 4:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YZYX);
                break;
            //宝宝相机
            case 5:
                ActivityUtils.startApplicationWithPackageName(HHT_LY_BABY_CAMERA);
                break;


        }
    }

    @Override
    public void getItemIcon() {
        if (hht_ly_mode == null) return;
        hht_ly_mode.getItemIcon();
    }

    @Override
    public void detachView() {
        super.detachView();
        if (hht_ly_mode != null)
            hht_ly_mode.onDestroy();
    }
}
