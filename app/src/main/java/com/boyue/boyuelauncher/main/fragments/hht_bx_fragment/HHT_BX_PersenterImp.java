package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;

import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_BABY_BUS;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_ZHONGBAN;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_BX_PersenterImp extends HHT_BX_Persenter {

    private Context mContext;
    private HHT_BX_Mode hht_bx_mode;


    public HHT_BX_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_bx_mode = new HHT_BX_ModeImp(mContext, new HHT_BX_Mode.CallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {
                HHT_BX_View view = getView();
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
        if (hht_bx_mode != null)
            hht_bx_mode.getIconDrawble();
    }

    @Override
    public void getItemIcon() {
        if (hht_bx_mode == null) return;
        hht_bx_mode.getItemIcon();

    }

    @Override
    public void startHHT_BX_Item(int position) {
        switch (position) {
            case 2:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, HHTLY_BABY_BUS);
                break;
        }

    }

}
