package com.boyue.boyuelauncher.main;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import com.boyue.boyuelauncher.main.fragment.fragment1.Fragment1;
import com.boyue.boyuelauncher.main.fragment.fragment2.Fragment2;
import com.boyue.boyuelauncher.main.fragment.fragment3.Fragment3;
import com.boyue.boyuelauncher.main.fragment.fragment4.Fragment4;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

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


    @Override
    protected int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewpager = findViewById(R.id.viewpager);
        cleanCache = findViewById(R.id.cleancache);
        cleanCache.setOnClickListener(this);
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(this);
        viewpager.addOnPageChangeListener(this);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        content = findViewById(R.id.content);
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment2.newInstance());
        fragments.add(Fragment3.newInstance());
        fragments.add(Fragment4.newInstance());
        adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0, false);
        viewpager.setOffscreenPageLimit(4);
        setBG();
    }

    private void setBG() {

        Glide.with(MainActivity.this).load(R.mipmap.bg).into(new SimpleTarget<GlideDrawable>(1024, 600) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (content != null)
                    content.setBackground(resource.getCurrent());
            }
        });
//        Picasso.get().load(R.mipmap.bg).config(Bitmap.Config.RGB_565).resize(300, 300).into(new Target() {
//            @Override
//            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                if (content != null)
//                    content.setBackground(new BitmapDrawable(bitmap));
//                LogUtils.e("tlh", "onBitmapLoaded");
//            }
//
//            @Override
//            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//                LogUtils.e("tlh", "onBitmapFailed");
//
//            }
//
//            @Override
//            public void onPrepareLoad(Drawable placeHolderDrawable) {
//                LogUtils.e("tlh", "onBitmapFailed");
//            }
//        });
    }

    @Override
    protected MainPresenterImp createPresenter() {
        return new MainPresenterImp();
    }


    public void setFunctionsForFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
        FunctionMnanger functionMnanger = FunctionMnanger.getInstance();
        fragment.setmFunctionManager(functionMnanger.addFunction(new FunctionNoParamNoResult(Fragment1.INTERFACE_RESULT) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this, "成功调用无参无返回值的接口", Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithParamAndResult<String, String>(Fragment3.INTERFACE_RESULT) {
            @Override
            public String function(String param) {
                return "系统的字符串---" + param;
            }
        }).addFunction(new FunctionWithResultOnly<String>(Fragment2.INTERFACE_RESULT) {
            @Override
            public String function() {
                return "只有一个返回值的方法被调用！";
            }
        }).addFunction(new FunctionWithParamOnly<String>(Fragment4.INTERFACE_RESULT) {
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
            case R.id.radio1:
                viewpager.setCurrentItem(0);
                break;
            case R.id.radio2:
                viewpager.setCurrentItem(1);
                break;
            case R.id.radio3:
                viewpager.setCurrentItem(2);
                break;
            case R.id.radio4:
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

                Toast.makeText(MainActivity.this, "别往右拉了，跑不动了", Toast.LENGTH_SHORT).show();

            }
            if (position == 3 && positionOffset == 0.0 && positionOffsetPixels == 0) {

                Toast.makeText(MainActivity.this, "别往左拉了，跑不动了", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                radioGroup.check(R.id.radio1);
                break;
            case 1:
                radioGroup.check(R.id.radio2);
                break;
            case 2:
                radioGroup.check(R.id.radio3);
                break;
            case 3:
                radioGroup.check(R.id.radio4);
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
                startCleanCache(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_CLEANCACHE);
                break;
            case R.id.settings:
                startWiFiManager(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_WIFIMANAGER);
                break;
        }
    }


    /**
     * 清除当前APP缓存数据
     *
     * @param mContext
     * @param action
     */
    public void startCleanCache(Context mContext, String action) {
        setActivityConfig(mContext, action);
    }

    /**
     * 启动当前WiFi管理界面
     *
     * @param mContext
     * @param action
     */
    public void startWiFiManager(Context mContext, String action) {
        setActivityConfig(mContext, action);
    }

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


}
