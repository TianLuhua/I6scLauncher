package com.boyue.boyuelauncher.settings;

import android.content.Context;
import android.content.res.TypedArray;

import com.boyue.boyuelauncher.R;
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


    public SettingsModeImp(Context mContext, CallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.dataList = new ArrayList<Map<String, Object>>();

    }

    @Override
    public void getIndicatorItems() {
        LogUtils.e("tlh","getIndicatorItems");
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
            LogUtils.e("tlh","getIndicatorItems--->"+i);
        }

        if (dataList.size() > 0) {
            callBack.indicatorItems(dataList);
        }
    }
}
