package com.boyue.boyuelauncher.settings;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.settings.adapter.SystemSettingFragmentPagerAdapter;
import com.boyue.boyuelauncher.settings.adapter.SystemSettingIndicatorgAdapter;
import com.boyue.boyuelauncher.settings.fragments.fcm_settings.FCMSettingFragment;
import com.boyue.boyuelauncher.settings.fragments.protect_eye_settings.ProtectEyeFragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.TitleBar;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_FCM_ChangePassWordDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/5/28.
 */

public class SettingsActivity extends AbstractMVPActivity<SettingsView, SettingsPersenterImp> implements SettingsView, AdapterView.OnItemClickListener, ViewPager.OnPageChangeListener, ProtectEyeFragment.Notfication, FCMSettingFragment.Notfication {

    public static final String TITLE = "title";
    public static final String IMAGE = "image";

    private TitleBar titleBar;
    private ListView mListView;
    private SystemSettingIndicatorgAdapter indicatorgAdapter;
    private SystemSettingFragmentPagerAdapter fragmentPagerAdapter;

    private ViewPager fragmentPagers;
    private ArrayList<Fragment> fragments;

    private int defaultPager = 0;

    @Override

    protected int getContentViewID() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView() {
        //判断是否启用密码，启用的话需要验证才能进入。反之，退出设置界面。
        if (getPresenter().hasEnablePWD()) {

            final Setting_FCM_ChangePassWordDialog dialog = new Setting_FCM_ChangePassWordDialog();
            dialog.setNotfication(new Setting_FCM_ChangePassWordDialog.Notfication() {
                @Override
                public void inputNumber(int number) {


                }

                @Override
                public void hasInputNumbers(String pwd) {
                    if (getPresenter().matchingPwd(pwd)) {
                        LogUtils.e("tlh", "通过密码验证，您的密码是：" + pwd);
                        dialog.dismiss();

                    } else {
                        dialog.setTieltT(R.string.input_pwd_error, R.color.color_red);
                        dialog.cleanPwdStatus();
                    }

                }

                @Override
                public void cancel() {
                    SettingsActivity.this.finish();

                }

                @Override
                public void delete() {

                }
            });
            dialog.show(getSupportFragmentManager(), Config.DialogGlod.SETTING_FCM_CHANGEPASSWORD);
            dialog.setCancelable(false);
        }
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
        fragmentPagers.addOnPageChangeListener(this);
        fragmentPagerAdapter = new SystemSettingFragmentPagerAdapter(getSupportFragmentManager());
        fragmentPagers.setAdapter(fragmentPagerAdapter);
        fragmentPagers.setCurrentItem(defaultPager);

        getPresenter().getIndicatorItems();
        getPresenter().getPagerFragments();
    }

    @Override
    protected SettingsPersenterImp createPresenter() {
        return new SettingsPersenterImp(getApplicationContext());
    }

    @Override
    public void disPlayIndicatorItems(final List<Map<String, Object>> dataList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                indicatorgAdapter = new SystemSettingIndicatorgAdapter(getApplicationContext(), dataList, R.layout.item_system_setting_indicator, new String[]{TITLE, IMAGE},
                        new int[]{R.id.page_item_tv, R.id.page_item_iv});
                mListView.setAdapter(indicatorgAdapter);
                //设置第一个icon为选中状态
                indicatorgAdapter.setmCurrentItem(defaultPager);
                indicatorgAdapter.setClick(true);
                mListView.setOnItemClickListener(SettingsActivity.this);
                LogUtils.e("tlh", "SettingsActivity--->disPlayIndicatorItems----->dataList.size():" + dataList.size());
            }
        });


    }

    @Override
    public void disPlayPagerFragments(final ArrayList<Fragment> fragments) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragmentPagerAdapter.setFragments(fragments);
            }
        });

        this.fragments = fragments;
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

    @Override
    public void hasOpenFcmPassWord(boolean hasOpen) {
        //通知护眼界面，已经开启防沉迷密码
        ProtectEyeFragment protectFragment = (ProtectEyeFragment) fragments.get(1);
        protectFragment.hasOpenFcmPassWord(hasOpen);

    }
}
