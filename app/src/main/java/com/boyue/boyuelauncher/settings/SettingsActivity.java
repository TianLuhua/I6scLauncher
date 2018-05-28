package com.boyue.boyuelauncher.settings;

import android.content.res.TypedArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.settings.adapter.SystemSettingAdapter;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.TitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/5/28.
 */

public class SettingsActivity extends AbstractMVPActivity<SettingsView, SettingsPersenterImp> implements SettingsView, AdapterView.OnItemClickListener {

    public static final String TITLE = "title";
    public static final String IMAGE = "image";

    private TitleBar titleBar;
    private ListView mListView;
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

        getPresenter().getIndicatorItems();


    }

    @Override
    protected SettingsPersenterImp createPresenter() {
        return new SettingsPersenterImp(getApplicationContext());
    }

    @Override
    public void disPlayIndicatorItems(List<Map<String, Object>> dataList) {
        adapter = new SystemSettingAdapter(getApplicationContext(), dataList, R.layout.item_system_setting_indicator, new String[]{TITLE, IMAGE},
                new int[]{R.id.page_item_tv, R.id.page_item_iv});
        mListView.setAdapter(adapter);

        //设置第一个icon为选中状态
        adapter.setmCurrentItem(0);
        adapter.setClick(true);
        mListView.setOnItemClickListener(this);
        LogUtils.e("tlh", "SettingsActivity--->disPlayIndicatorItems----->dataList.size():" + dataList.size());

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter.setmCurrentItem(position);
        adapter.setClick(true);
        adapter.notifyDataSetChanged();

        switch (position) {

            //七彩耳灯
            case 0:
                break;
            //护眼设置
            case 1:
                break;
            //音量设置
            case 2:
                break;
            //自动关机
            case 3:
                break;
            //防沉迷设置
            case 4:
                break;
            //日期与时间
            case 5:
                break;
            //高级
            case 6:
                break;
            //意见反馈
            case 7:
                break;
        }

    }


    protected int dp2px(float dp) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

}
