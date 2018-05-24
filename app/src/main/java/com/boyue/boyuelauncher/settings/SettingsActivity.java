package com.boyue.boyuelauncher.settings;

import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.settings.entity.MenuBean;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.TitleBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Created by Tianluhua on 2018/5/22.
 */

public class SettingsActivity extends AbstractMVPActivity<SettingsView, SettingsPersenter> implements SettingsView {

    private TitleBar titleBar;
    private VerticalTabLayout verticalTabLayout;


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
        verticalTabLayout = findViewById(R.id.tablayout);
        verticalTabLayout.setTabAdapter(new MyTabAdapter());
    }

    @Override
    protected SettingsPersenter createPresenter() {
        return new SettingsPersenter();
    }

    private class MyTabAdapter implements TabAdapter {

        List<MenuBean> menus;

        public MyTabAdapter() {
            menus = new ArrayList<>();
            Collections.addAll(menus, new MenuBean(R.drawable.man_01_pressed, R.drawable.man_01_none, "七彩耳灯")
                    , new MenuBean(R.drawable.man_02_pressed, R.drawable.man_02_none, "护眼设置")
                    , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "音量设置")
                    , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "自动关机")
                    , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "防沉迷设置")
                    , new MenuBean(R.drawable.man_03_pressed, R.drawable.man_03_none, "高级")
                    , new MenuBean(R.drawable.man_04_pressed, R.drawable.man_04_none, "意见反馈"));
        }

        @Override
        public int getCount() {
            return menus.size();
        }

        @Override
        public TabView.TabBadge getBadge(int position) {
//            return new TabView.TabBadge.Builder().setBadgeNumber(999).setBackgroundColor(0xff2faae5)
//                    .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
//                        @Override
//                        public void onDragStateChanged(int dragState, Badge badge, View targetView) {
//                        }
//                    }).build();
            return null;
        }

        @Override
        public TabView.TabIcon getIcon(int position) {
            MenuBean menu = menus.get(position);
            return new TabView.TabIcon.Builder()
                    .setIcon(menu.mSelectIcon, menu.mNormalIcon)
                    .setIconGravity(Gravity.START)
                    .setIconMargin(dp2px(10))
                    .setIconSize(dp2px(40), dp2px(40))
                    .build();
        }

        @Override
        public TabView.TabTitle getTitle(int position) {
            MenuBean menu = menus.get(position);
            return new TabView.TabTitle.Builder()
                    .setTextSize(dp2px(19))
                    .setContent(menu.mTitle)
                    .setTextColor(0xFF36BC9B, 0xFF757575)
                    .build();
        }

        @Override
        public int getBackground(int position) {
            return -1;
        }

    }

    protected int dp2px(float dp) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
