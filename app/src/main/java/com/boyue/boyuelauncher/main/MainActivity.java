package com.boyue.boyuelauncher.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.base.BaseFragment;
import com.boyue.boyuelauncher.function.FunctionMnanger;
import com.boyue.boyuelauncher.function.FunctionNoParamNoResult;
import com.boyue.boyuelauncher.function.FunctionWithParamAndResult;
import com.boyue.boyuelauncher.function.FunctionWithParamOnly;
import com.boyue.boyuelauncher.function.FunctionWithResultOnly;
import com.boyue.boyuelauncher.main.adapter.MainPagerAdapter;
import com.boyue.boyuelauncher.main.fragment.hht_xt_fragment.HHT_XT_Fragment;
import com.boyue.boyuelauncher.main.fragment.hht_ar_fragment.HHT_AR_Fragment;
import com.boyue.boyuelauncher.main.fragment.hht_ly_fragment.HHT_LY_Fragment;
import com.boyue.boyuelauncher.main.fragment.hht_bx_fragment.HHT_BX_Fragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.MainTilteBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbstractMVPActivity<MainView, MainPresenterImp> implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, View.OnClickListener, MainView {


    private ViewPager viewpager;
    private RadioGroup radioGroup;
    private ImageView cleanCache;
    private ImageView settings;

    private FrameLayout content;

    private List<Fragment> fragments = new ArrayList<>();
    private MainPagerAdapter adapter;


    private MainTilteBar tilteBar;

    @Override
    protected int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewpager = findViewById(R.id.viewpager);
        cleanCache = findViewById(R.id.cleancache);
        settings = findViewById(R.id.xiaoxue_ketang);
        radioGroup = findViewById(R.id.radioGroup);
        content = findViewById(R.id.content);
        cleanCache.setOnClickListener(this);
        settings.setOnClickListener(this);
        viewpager.addOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        fragments.add(HHT_XT_Fragment.newInstance());
        fragments.add(HHT_AR_Fragment.newInstance());
        fragments.add(HHT_LY_Fragment.newInstance());
        fragments.add(HHT_BX_Fragment.newInstance());
        adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        setBG();
        initTitle();
    }

    private void setBG() {

        if (getPresenter() == null) return;
        getPresenter().getBG();

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
        tilteBar.setVolumeMumber(40);
    }


    @Override
    protected MainPresenterImp createPresenter() {
        return new MainPresenterImp(getApplicationContext());
    }


    public void setFunctionsForFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
        FunctionMnanger functionMnanger = FunctionMnanger.getInstance();
        fragment.setmFunctionManager(functionMnanger.addFunction(new FunctionNoParamNoResult(HHT_XT_Fragment.INTERFACE_RESULT) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this, "成功调用无参无返回值的接口", Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithParamAndResult<String, String>(HHT_LY_Fragment.INTERFACE_RESULT) {
            @Override
            public String function(String param) {
                return "系统的字符串---" + param;
            }
        }).addFunction(new FunctionWithResultOnly<String>(HHT_AR_Fragment.INTERFACE_RESULT) {
            @Override
            public String function() {
                return "只有一个返回值的方法被调用！";
            }
        }).addFunction(new FunctionWithParamOnly<String>(HHT_BX_Fragment.INTERFACE_RESULT) {
            @Override
            public void function(String o) {
                Toast.makeText(MainActivity.this, "成功调用有参无返回值的接口：" + o, Toast.LENGTH_SHORT).show();
            }
        }));

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
            case R.id.ic_settings:
//                startWiFiManager();
                break;
        }
    }


    /**
     * 清除当前APP缓存数据
     */
    public void startCleanCache() {
        setActivityConfig(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_CLEANCACHE);
    }

    /**
     * 启动当前WiFi管理界面
     */
    public void startWiFiManager() {
        setActivityConfig(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_WIFIMANAGER);
    }

    /**
     * 启动Setting界面
     */

    public void startSettings() {
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
    public void setBgDrawble(Drawable bgDrawble) {
        if (content != null)
            content.setBackground(bgDrawble);
    }
}
