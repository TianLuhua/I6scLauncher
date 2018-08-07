package com.boyue.boyuelauncher.main;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.main.adapter.MainPagerAdapter;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.MainTilteBar;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_FCM_ChangePassWordDialog;

import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.FILE_MANGER_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.FILE_MANGER_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XXKT_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XXKT_PACKAGE;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_AUDIO_KEY;


public class MainActivity extends AbstractMVPActivity<MainView, MainPresenterImp> implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, View.OnClickListener, MainView {


    private MainTilteBar tilteBar;
    private ViewPager viewpager;
    private RadioGroup radioGroup;
    private ImageView cleanCache;
    private ImageView xiaoxue_ketang;

    private MainPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取Fragments
        getPresenter().getFragments();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        unregisterReceiver(systemReceiver);
//        LogUtils.e("tlh", "MainActivity---nregisterReceiver");
    }

    @Override
    protected int getContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


        //判断是否启用密码，启用的话需要验证才能进入。反之，退出设置界面。
        if (getPresenter().hasEnableFCMPWD()) {

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

                }

                @Override
                public void delete() {

                }

                @Override
                public void reSetPassWord() {
                    getPresenter().reSetPassWord();

                }
            });
            dialog.show(getSupportFragmentManager(), Config.DialogGlod.SETTING_FCM_CHANGEPASSWORD);
            dialog.setCancelable(false);
        }
        viewpager = findViewById(R.id.viewpager);
        cleanCache = findViewById(R.id.cleancache);
        xiaoxue_ketang = findViewById(R.id.xiaoxue_ketang);
        radioGroup = findViewById(R.id.radioGroup);
        cleanCache.setOnClickListener(this);
        xiaoxue_ketang.setOnClickListener(this);
        viewpager.addOnPageChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(4);

        initTitle();
        //获取系统音量，跟新界面
        getPresenter().getCurrentVolune();
    }


    private void initTitle() {
        tilteBar = findViewById(R.id.title_bar);
        tilteBar.setOnTitleBarClickListener(new MainTilteBar.OnTitleBarClickListener() {
            @Override
            public void onBackClick(View view) {
                AudioManager audioMa = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                audioMa.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_SAME, AudioManager.FLAG_PLAY_SOUND
                                | AudioManager.FLAG_SHOW_UI);
                ToastUtil.showToast("Set System volume", Toast.LENGTH_SHORT);
            }

            @Override
            public void onSettingsClick(View view) {
                ToastUtil.showToast("SETTINGS", Toast.LENGTH_SHORT);
                startSettings();
            }

            @Override
            public void onWiFiManagerClick(View view) {
                ToastUtil.showToast("WIFI", Toast.LENGTH_SHORT);
                startWiFiManager();
            }

            @Override
            public void onSDIconClick(View view) {
                ToastUtil.showToast("SD", Toast.LENGTH_SHORT);
                ActivityUtils.startApplicationWithComponent(FILE_MANGER_PACKAGE, FILE_MANGER_LAUNCHER);
            }

            @Override
            public void onUSBIconClick(View view) {
                ToastUtil.showToast("USB", Toast.LENGTH_SHORT);
                ActivityUtils.startApplicationWithComponent(FILE_MANGER_PACKAGE, FILE_MANGER_LAUNCHER);
            }
        });
    }

    @Override
    public void setFragments(final List<Fragment> fragments) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.setFragments(fragments);
            }
        });
    }

    @Override
    protected MainPresenterImp createPresenter() {
        return new MainPresenterImp(getApplicationContext());
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        LogUtils.e("tlh", "MainActivity---onCheckedChanged");
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
        LogUtils.e("tlh", "MainActivity---onPageSelected---position:" + position);
        //tlh 2018.08.07 禁止掉每页滑动时候的背景音乐
        //startPlayAudio(position);
        radioGroup.setOnCheckedChangeListener(null);
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
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        LogUtils.e("tlh", "MainActivity---onPageScrollStateChanged---state:" + state);
        isDragging = state == 1;
    }

    /**
     * 播放选中界面的音频文件
     *
     * @param position
     */
    private void startPlayAudio(int position) {
        Intent intent = new Intent(Config.BoYueAction.PLAYAUDIO);
        intent.putExtra(HHTLY_AUDIO_KEY, position);
        startService(intent);
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
        ToastUtil.showToast("小学课堂！", Toast.LENGTH_SHORT);
        ActivityUtils.startApplicationWithComponent(HHT_XXKT_PACKAGE, HHT_XXKT_LAUNCHER);

    }


    /**
     * 清除当前APP缓存数据
     */
    private void startCleanCache() {
        ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_CLEANCACHE);
    }

    /**
     * 启动当前WiFi管理界面
     */
    private void startWiFiManager() {
        ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_WIFIMANAGER);
    }

    /**
     * 启动Setting界面
     */

    private void startSettings() {
        ActivityUtils.setActivityConfig(Config.BoYueAction.ACTIVITY_ACTION_SETTINGS);
    }


    @Override
    public void setCurrentVolune(int currentVolune) {
        if (tilteBar == null) return;
        tilteBar.setVolumeMumber(currentVolune);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //主界面响应Back按键
        if (keyCode == KeyEvent.KEYCODE_BACK)
            return false;
        return super.onKeyDown(keyCode, event);
    }
}
