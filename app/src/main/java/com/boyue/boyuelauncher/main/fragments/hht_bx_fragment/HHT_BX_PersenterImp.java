package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.main.fragments.base.ItemDataCallBack;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;

import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_AIQIYI_CHILDNER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_MEDIA_CHAT;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_WECHAT;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_BABY_BUS;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_BX_PersenterImp extends HHT_BX_Persenter {

    private Context mContext;
    private HHT_BX_Mode hht_bx_mode;


    public HHT_BX_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_bx_mode = new HHT_BX_ModeImp(mContext, new ItemDataCallBack() {
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

            //爱奇艺少儿
            case 1:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_AIQIYI_CHILDNER);
                break;
            //宝宝巴士
            case 2:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE, HHTLY_BABY_BUS);
                break;
            //语音聊天
            case 3:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_MEDIA_CHAT);
                break;
            //微信
            case 4:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_WECHAT);
                break;
        }

    }

}
