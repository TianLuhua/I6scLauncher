package com.boyue.boyuelauncher.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.main.adapter.MainPagerAdapter;
import com.boyue.boyuelauncher.main.fragments.hht_ar_fragment.HHT_AR_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_bx_fragment.HHT_BX_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.HHT_LY_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_XT_Fragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.MainTilteBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbstractMVPActivity<MainView, MainPresenterImp> implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, View.OnClickListener, MainView {


    private MainTilteBar tilteBar;
    private ViewPager viewpager;
    private RadioGroup radioGroup;
    private ImageView cleanCache;
    private ImageView xiaoxue_ketang;
    private FrameLayout content;

    private MainPagerAdapter adapter;
    private List<Fragment> fragments = new ArrayList<>();


    @Override
    protected int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewpager = findViewById(R.id.viewpager);
        cleanCache = findViewById(R.id.cleancache);
        xiaoxue_ketang = findViewById(R.id.xiaoxue_ketang);
        radioGroup = findViewById(R.id.radioGroup);
        content = findViewById(R.id.content);
        cleanCache.setOnClickListener(this);
        xiaoxue_ketang.setOnClickListener(this);
        viewpager.addOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        fragments.add(HHT_XT_Fragment.newInstance());
        fragments.add(HHT_AR_Fragment.newInstance());
        fragments.add(HHT_LY_Fragment.newInstance());
        fragments.add(HHT_BX_Fragment.newInstance());
        adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        initTitle();
        getCurrentVolune();
    }

    private void getCurrentVolune() {
        if (getPresenter() == null) return;
        getPresenter().getCurrentVolune();

    }

    private void initTitle() {
        tilteBar = findViewById(R.id.title_bar);
        tilteBar.setOnTitleBarClickListener(new MainTilteBar.OnTitleBarClickListener() {
            @Override
            public void onBackClick(View view) {
                Toast.makeText(MainActivity.this, "Set System volume", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSettingsClick(View view) {
                Toast.makeText(MainActivity.this, "SETTINGS", Toast.LENGTH_SHORT).show();
                startSettings();

            }

            @Override
            public void onWiFiManagerClick(View view) {
                Toast.makeText(MainActivity.this, "WIFI", Toast.LENGTH_SHORT).show();
                startWiFiManager();

            }

            @Override
            public void onSDIconClick(View view) {
                Toast.makeText(MainActivity.this, "SD", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUSBIconClick(View view) {
                Toast.makeText(MainActivity.this, "USB", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    protected MainPresenterImp createPresenter() {
        return new MainPresenterImp(getApplicationContext());
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        LogUtils.e("tlh", "onCheckedChanged:" + checkedId);
        switch (checkedId) {
            case R.id.hht_xt:
                viewpager.setCurrentItem(0);
                break;
            case R.id.hht_ar:
                viewpager.setCurrentItem(1);
                break;
            case R.id.hht_ly:
                viewpager.setCurrentItem(2);
                break;
            case R.id.hht_gx:
                viewpager.setCurrentItem(3);
                break;
        }
    }

    private boolean isDragging = false;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LogUtils.e("tlh", "onPageScrolled---position:" + position + " ,positionOffset:" + positionOffset + ",positionOffsetPixels:" + positionOffsetPixels);

        if (isDragging) {
            if (position == 0 && positionOffset == 0.0 && positionOffsetPixels == 0) {

//                Toast.makeText(MainActivity.this, "别往右拉了，跑不动了", Toast.LENGTH_SHORT).show();

            }
            if (position == 3 && positionOffset == 0.0 && positionOffsetPixels == 0) {

//                Toast.makeText(MainActivity.this, "别往左拉了，跑不动了", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                radioGroup.check(R.id.hht_xt);
                break;
            case 1:
                radioGroup.check(R.id.hht_ar);
                break;
            case 2:
                radioGroup.check(R.id.hht_ly);
                break;
            case 3:
                radioGroup.check(R.id.hht_gx);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        LogUtils.e("tlh", "onPageScrollStateChanged:" + state);
        isDragging = state == 1;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cleancache:
                startCleanCache();
                break;
            case R.id.xiaoxue_ketang:
                startXiaoxue_ketang();
                break;
        }
    }

    private void startXiaoxue_ketang() {

    }


    /**
     * 清除当前APP缓存数据
     */
    private void startCleanCache() {
        setActivityConfig(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_CLEANCACHE);
    }

    /**
     * 启动当前WiFi管理界面
     */
    private void startWiFiManager() {
        setActivityConfig(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_WIFIMANAGER);
    }

    /**
     * 启动Setting界面
     */

    private void startSettings() {
        setActivityConfig(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_SETTINGS);
    }

    /**
     * 启动对应的Activity根据不同的Action
     *
     * @param mContext
     * @param action
     */
    private void setActivityConfig(Context mContext, String action) {
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (mContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            try {
                mContext.startActivity(intent);
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(mContext, "Start Activity Error", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(mContext, "Not Found CleanCacheActivity", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setCurrentVolune(int currentVolune) {
        tilteBar.setVolumeMumber(currentVolune);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
