package com.boyue.boyuelauncher.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.settings.fragments.advance_settings.AdvanceSettingFragment;
import com.boyue.boyuelauncher.settings.fragments.auto_shutdown.AutoShueDownFragment;
import com.boyue.boyuelauncher.settings.fragments.color_ear.ColorEarFragment;
import com.boyue.boyuelauncher.settings.fragments.date_time_settings.DateTimeSettingFragment;
import com.boyue.boyuelauncher.settings.fragments.fcm_settings.FCMSettingFragment;
import com.boyue.boyuelauncher.settings.fragments.feedback.FeedBackFragment;
import com.boyue.boyuelauncher.settings.fragments.protect_eye_settings.ProtectEyeFragment;
import com.boyue.boyuelauncher.settings.fragments.volume_settings.VolumeSettingFragment;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.boyue.boyuelauncher.settings.SettingsActivity.IMAGE;
import static com.boyue.boyuelauncher.settings.SettingsActivity.TITLE;

public class SettingsModeImp implements SettingsMode {

    private Context mContext;
    private CallBack callBack;
    private List<Map<String, Object>> dataList;
    private List<Fragment> fragments;


    public SettingsModeImp(Context mContext, CallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.dataList = new ArrayList<Map<String, Object>>();
        this.fragments = new ArrayList<Fragment>();

    }

    @Override
    public void getIndicatorItems() {
        LogUtils.e("tlh", "getIndicatorItems");
        if (mContext == null && callBack == null) return;

        //图标
        TypedArray icons = mContext.getResources().obtainTypedArray(R.array.system_settings_items_image);
        //文字
        String names[] = mContext.getResources().getStringArray(R.array.system_settings_items_text);

        for (int i = 0; i < names.length; i++) {
            HashMap<String, Object> mapItem = new HashMap<>();
            mapItem.put(TITLE, names[i]);
            mapItem.put(IMAGE, icons.getResourceId(i, 0));
            dataList.add(mapItem);
            LogUtils.e("tlh", "getIndicatorItems--->" + i);
        }

        if (dataList.size() > 0) {
            callBack.setIndicatorItems(dataList);
        }
    }

    @Override
    public void getPagerFragments() {
        if (callBack == null) return;
        fragments.add(ColorEarFragment.newInstance());
        fragments.add(ProtectEyeFragment.newInstance());
        fragments.add(VolumeSettingFragment.newInstance());
        fragments.add(AutoShueDownFragment.newInstance());
        fragments.add(FCMSettingFragment.newInstance());
        fragments.add(DateTimeSettingFragment.newInstance());
        fragments.add(AdvanceSettingFragment.newInstance());
        fragments.add(FeedBackFragment.newInstance());
        callBack.setPagerFragments(fragments);

    }
    @Override
    public void onDestroy() {

    }
}
