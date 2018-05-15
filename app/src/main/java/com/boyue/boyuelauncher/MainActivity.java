package com.boyue.boyuelauncher;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.boyue.boyuelauncher.base.BaseFragment;
import com.boyue.boyuelauncher.fragment.Fragment1;
import com.boyue.boyuelauncher.fragment.Fragment2;
import com.boyue.boyuelauncher.fragment.Fragment3;
import com.boyue.boyuelauncher.fragment.Fragment4;
import com.boyue.boyuelauncher.function.FunctionMnanger;
import com.boyue.boyuelauncher.function.FunctionNoParamNoResult;
import com.boyue.boyuelauncher.function.FunctionWithParamAndResult;
import com.boyue.boyuelauncher.function.FunctionWithParamOnly;
import com.boyue.boyuelauncher.function.FunctionWithResultOnly;
import com.boyue.boyuelauncher.utils.HideSystemUIUtils;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, View.OnClickListener {


    private ViewPager viewpager;
    private RadioGroup radioGroup;
    private ImageView cleanCache;
    private ImageView settings;

    private List<Fragment> fragments = new ArrayList<>();
    private MyPagerAdapter adapter;
    private boolean isGranted;
    private static final int REQUEST_CODE = 11000;//权限请求code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideSystemUIUtils.hideSystemUI(this);
        setContentView(R.layout.activity_main);

        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        cleanCache = findViewById(R.id.cleancache);
        cleanCache.setOnClickListener(this);
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(this);
        viewpager.setOnPageChangeListener(this);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0, false);
        viewpager.setOffscreenPageLimit(4);
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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

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

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cleancache:
                startCleanCache(MainActivity.this, Config.BoYueAction.ACTIVITY_ACTION_CLEANCACHE);
                break;
            case R.id.settings:

                break;
        }
    }


    /**
     * 清楚当前APP缓存数据
     *
     * @param mContext
     * @param action
     */
    public void startCleanCache(Context mContext, String action) {
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

//    /**
//     * 检查权限
//     */
//    private void checkPermission() {
//        int perm = ContextCompat.checkSelfPermission(MainActivity.this, Config.Permission.LOCATION_PERMISSION);
//        if (perm == PackageManager.PERMISSION_GRANTED) {
//            isGranted = true;
//        } else {
//            isGranted = false;
//            ActivityCompat.requestPermissions(MainActivity.this,
//                    new String[]{Config.Permission.LOCATION_PERMISSION}, REQUEST_CODE);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == REQUEST_CODE) {//请求权限结果
//            int perm = ContextCompat.checkSelfPermission(MainActivity.this, Config.Permission.LOCATION_PERMISSION);
//            if (perm == PackageManager.PERMISSION_GRANTED) {
//                isGranted = true;
//
//            } else {
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            }
//        }
//    }
}
