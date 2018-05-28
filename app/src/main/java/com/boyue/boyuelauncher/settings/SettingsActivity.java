package com.boyue.boyuelauncher.settings;

import android.content.res.TypedArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.settings.adapter.SystemSettingAdapter;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.TitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/5/22.
 */

public class SettingsActivity extends AbstractMVPActivity<SettingsView, SettingsPersenter> implements SettingsView, AdapterView.OnItemClickListener {

    public static final String TITLE = "title";
    public static final String IMAGE = "image";

    private TitleBar titleBar;
    private ListView mListView;
    private List<Map<String, Object>> dataList;
    private SystemSettingAdapter adapter;


    @Override
    protected int getContentViewID() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView() {
        titleBar = findViewById(R.id.title_bar);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                ToastUtil.showShortToast(SettingsActivity.this, "onLeftIconClick");
                finish();

            }

            @Override
            public void onTitleClick(View view) {
                ToastUtil.showShortToast(SettingsActivity.this, "onTitleClick");

            }

            @Override
            public void onRightIconClick(View view) {
                ToastUtil.showShortToast(SettingsActivity.this, "onRightIconClick");

            }
        });

        mListView = findViewById(R.id.page_indicator);
        initData();


    }

    private void initData() {
        //图标
        TypedArray icons = getResources().obtainTypedArray(R.array.system_settings_items_image);
        //文字
        String names[] = getResources().getStringArray(R.array.system_settings_items_text);
        dataList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < names.length; i++) {
            HashMap<String, Object> mapItem = new HashMap<>();
            mapItem.put(TITLE, names[i]);
            mapItem.put(IMAGE, icons.getResourceId(i, 0));
            dataList.add(mapItem);
        }

        adapter = new SystemSettingAdapter(getApplicationContext(), dataList, R.layout.item_system_setting_indicator, new String[]{TITLE, IMAGE},
                new int[]{R.id.page_item_tv, R.id.page_item_iv});
        mListView.setAdapter(adapter);

        //设置第一个icon为选中状态
        adapter.setmCurrentItem(0);
        adapter.setClick(true);
        mListView.setOnItemClickListener(this);

    }

    @Override
    protected SettingsPersenter createPresenter() {
        return new SettingsPersenter();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter.setmCurrentItem(position);
        adapter.setClick(true);
        adapter.notifyDataSetChanged();
    }


    protected int dp2px(float dp) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

}
