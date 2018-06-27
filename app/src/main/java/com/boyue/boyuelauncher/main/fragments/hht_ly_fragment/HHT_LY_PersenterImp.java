package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;

import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_KLOK_JDEG;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_THCZ;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YWEG;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YZYX;

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
    public void startHHT_LY_Activity(int position) {
        switch (position) {
            case 0:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_KLOK);
                break;
            case 1:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, HHTLY_YWEG);
                break;
            case 3:
                ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_HHT_YSPY);
                break;
            case 4:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, HHTLY_YZYX);
                break;
        }
    }

    @Override
    public void getItemIcon() {
        if (hht_ly_mode == null) return;
        hht_ly_mode.getItemIcon();
    }
}
