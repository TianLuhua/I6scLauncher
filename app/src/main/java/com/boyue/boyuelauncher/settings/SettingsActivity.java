package com.boyue.boyuelauncher.settings;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.settings.adapter.SystemSettingFragmentPagerAdapter;
import com.boyue.boyuelauncher.settings.adapter.SystemSettingIndicatorgAdapter;
import com.boyue.boyuelauncher.settings.fragments.protect_eye_settings.ProtectEyeFragment;
import com.boyue.boyuelauncher.settings.fragments.protect_eye_settings.ProtectEyeView;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.TitleBar;

import java.util.List;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/5/28.
 */

public class SettingsActivity extends AbstractMVPActivity<SettingsView, SettingsPersenterImp> implements SettingsView, AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener, ProtectEyeFragment.Notfication {

    public static final String TITLE = "title";
    public static final String IMAGE = "image";

    private TitleBar titleBar;
    private ListView mListView;
    private SystemSettingIndicatorgAdapter indicatorgAdapter;
    private SystemSettingFragmentPagerAdapter fragmentPagerAdapter;

    private ViewPager fragmentPagers;

    private int defaultPager = 0;

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
                ToastUtil.showShortToast("onLeftIconClick");
                finish();

            }

            @Override
            public void onTitleClick(View view) {
                ToastUtil.showShortToast("onTitleClick");

            }

            @Override
            public void onRightIconClick(View view) {
                ToastUtil.showShortToast("onRightIconClick");

            }
        });

        mListView = findViewById(R.id.page_indicator);
        fragmentPagers = findViewById(R.id.page_content);
        //设置ViewPager缓存的Fragment数量
        fragmentPagers.setOffscreenPageLimit(2);
        fragmentPagers.addOnPageChangeListener(this);

        getPresenter().getIndicatorItems();
        getPresenter().getPagerFragments();
    }

    @Override
    protected SettingsPersenterImp createPresenter() {
        return new SettingsPersenterImp(getApplicationContext());
    }

    @Override
    public void disPlayIndicatorItems(List<Map<String, Object>> dataList) {
        indicatorgAdapter = new SystemSettingIndicatorgAdapter(getApplicationContext(), dataList, R.layout.item_system_setting_indicator, new String[]{TITLE, IMAGE},
                new int[]{R.id.page_item_tv, R.id.page_item_iv});
        mListView.setAdapter(indicatorgAdapter);
        //设置第一个icon为选中状态
        indicatorgAdapter.setmCurrentItem(defaultPager);
        indicatorgAdapter.setClick(true);
        mListView.setOnItemClickListener(this);

        LogUtils.e("tlh", "SettingsActivity--->disPlayIndicatorItems----->dataList.size():" + dataList.size());

    }

    @Override
    public void disPlayPagerFragments(List<Fragment> fragments) {
        fragmentPagerAdapter = new SystemSettingFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        fragmentPagers.setAdapter(fragmentPagerAdapter);
        fragmentPagers.setCurrentItem(defaultPager);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indicatorgAdapter.setmCurrentItem(position);
        indicatorgAdapter.setClick(true);
        indicatorgAdapter.notifyDataSetChanged();
        fragmentPagers.setCurrentItem(position, false);
        LogUtils.e("tlh", "H:" + view.getHeight());

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LogUtils.e("tlh", "position:" + position);
        indicatorgAdapter.setmCurrentItem(position);
        indicatorgAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void gotoSetFcmPassWord() {
        //跳转到Fcm密码设置界面
        fragmentPagers.setCurrentItem(4, false);
    }
}
