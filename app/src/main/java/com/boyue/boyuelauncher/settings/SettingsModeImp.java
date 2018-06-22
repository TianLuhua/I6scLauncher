package com.boyue.boyuelauncher.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.settings.entity.MenuBean;
import com.boyue.boyuelauncher.settings.fragments.advance_settings.AdvanceSettingFragment;
import com.boyue.boyuelauncher.settings.fragments.auto_shutdown.AutoShueDownFragment;
import com.boyue.boyuelauncher.settings.fragments.color_ear.ColorEarFragment;
import com.boyue.boyuelauncher.settings.fragments.date_time_settings.DateTimeSettingFragment;
import com.boyue.boyuelauncher.settings.fragments.fcm_settings.FCMSettingFragment;
import com.boyue.boyuelauncher.settings.fragments.feedback.FeedBackFragment;
import com.boyue.boyuelauncher.settings.fragments.protect_eye_settings.ProtectEyeFragment;
import com.boyue.boyuelauncher.settings.fragments.volume_settings.VolumeSettingFragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SettingsModeImp implements SettingsMode {

    private Context mContext;
    private CallBack callBack;
    private List<Map<String, Object>> dataList;
    private ArrayList<Fragment> fragments;


    public SettingsModeImp(Context mContext, CallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.dataList = new ArrayList<Map<String, Object>>();
        this.fragments = new ArrayList<Fragment>();

    }

    @Override
    public void getIndicatorItems() {
        LogUtils.e("tlh", "getIndicatorItems");

        final List<MenuBean> menuBeanEntities = new ArrayList<MenuBean>();

        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                //图标
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.system_settings_items_image);
                //图标右边的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.system_settings_items_text);

                for (int i = 0; i < names.length(); i++) {
                    MenuBean appEntity = new MenuBean();
                    appEntity.setNameRes(names.getResourceId(i, 0));
                    appEntity.setIconRes(icnos.getResourceId(i, 0));
                    menuBeanEntities.add(appEntity);
                }
                icnos.recycle();
                names.recycle();
                if (callBack == null) return;
                callBack.setPlayIndicatorItems(menuBeanEntities);
            }
        });


    }

    @Override
    public void getPagerFragments() {
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                fragments.add(ColorEarFragment.newInstance());
                fragments.add(ProtectEyeFragment.newInstance());
                fragments.add(VolumeSettingFragment.newInstance());
                fragments.add(AutoShueDownFragment.newInstance());
                fragments.add(FCMSettingFragment.newInstance());
                fragments.add(DateTimeSettingFragment.newInstance());
                fragments.add(AdvanceSettingFragment.newInstance());
                fragments.add(FeedBackFragment.newInstance());
                if (callBack == null) return;
                callBack.setPagerFragments(fragments);
            }
        });


    }

    @Override
    public void onDestroy() {

    }
}
