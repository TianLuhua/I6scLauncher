package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.main.fragments.base.ItemDataCallBack;
import com.boyue.boyuelauncher.main.fragments.base.ItemMode;
import com.boyue.boyuelauncher.main.fragments.base.ItemPersenter;
import com.boyue.boyuelauncher.main.fragments.base.ItemView;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;

import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_ZXBX_CARTOON;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_HHT_BABY_SCHOOL;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_MEDIA_CHAT;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_MY_ADAPTER_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_MY_ADAPTER_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_MY_DAEMON_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_MY_DAEMON_PACKGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_MY_ROBOTE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_WECHAT;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE_KEY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_BABY_BUS;

/**
 * Created by Tianluhua on 2018/5/18.
 */
public class HHT_BX_PersenterImp extends ItemPersenter {

    private Context mContext;
    private ItemMode hht_bx_mode;


    public HHT_BX_PersenterImp(Context mContext) {
        this.mContext = mContext;
        this.hht_bx_mode = new HHT_BX_ModeImp(mContext, new ItemDataCallBack() {
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
        if (hht_bx_mode != null)
            hht_bx_mode.getIconDrawble();
    }

    @Override
    public void getItemIcon() {
        if (hht_bx_mode == null) return;
        hht_bx_mode.getItemIcon();

    }

    @Override
    public void startHHT_Activity(int position) {
        switch (position) {
            case 0:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_HHT_BABY_SCHOOL);
                break;
            //爱奇艺少儿
            case 1:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_ZXBX_CARTOON);
                break;
            //宝宝巴士
            case 2:
                ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_BABY_BUS);
                break;
            //语音聊天
            case 3:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_MEDIA_CHAT);
                break;
            //微信
            case 4:
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_WECHAT);
                break;
            //语音机器人
            case 5:
                ActivityUtils.startApplicationWithComponent(HHT_ZXBX_MY_DAEMON_PACKGE, HHT_ZXBX_MY_DAEMON_LAUNCHER);
                ActivityUtils.startApplicationWithComponent(HHT_ZXBX_MY_ADAPTER_PACKAGE, HHT_ZXBX_MY_ADAPTER_LAUNCHER);
                ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_MY_ROBOTE);
                break;
        }

    }

    @Override
    public void detachView() {
        super.detachView();
        if (hht_bx_mode != null)
            hht_bx_mode.onDestroy();
    }

}
