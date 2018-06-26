package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.HHT_klok_Item_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.HHT_klok_Main_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.jdeg.HHT_Klok_Jdeg_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.jdeg.HHT_Klok_Jdeg_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.jdeg.HHT_Klok_Jdeg_03_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.ttmtv.HHT_Klok_ttmtv_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.ttmtv.HHT_Klok_ttmtv_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.ttmtv.HHT_Klok_ttmtv_03_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.ttmtv.HHT_Klok_ttmtv_04_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.ttmtv.HHT_Klok_ttmtv_05_Fragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.TitleBar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_klok_Activity extends AbstractMVPActivity<HHT_klok_View, HHT_klok_Persenter> implements HHT_klok_Main_Fragment.Notification_KLOK, View.OnClickListener, HHT_klok_View {


    //卡拉ok主界面
    public static final int KLOK = 0x0000;
    //兔兔MTV
    public static final int TTMTV = 0x0001;
    //经典儿歌
    public static final int JDEG = 0x0002;


    private TitleBar titleBar;
    private ImageView previous_page, next_page;

    //记录当前处于那一页
    private int currentPageId = KLOK;
    private FragmentManager manager;

    private Fragment fragment_klok;
    private HHT_klok_Item_Fragment ttmvFrament;


    @Override
    protected int getContentViewID() {
        return R.layout.activity_hht_klok;
    }

    @Override
    protected void initView() {
        titleBar = findViewById(R.id.title_bar);
        titleBar.setTitle(R.string.hht_ly_klok);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                //当前不处于klok的话，就回到klok
                if (currentPageId != KLOK) {
                    onChangedPage(KLOK);
                } else {
                    finish();
                }
            }

            @Override
            public void onTitleClick(View view) {

            }

            @Override
            public void onRightIconClick(View view) {

            }
        });

        previous_page = findViewById(R.id.previous_page);
        previous_page.setOnClickListener(this);
        next_page = findViewById(R.id.next_page);
        next_page.setOnClickListener(this);

        manager = getSupportFragmentManager();

        fragment_klok = HHT_klok_Main_Fragment.newInstance();
        ttmvFrament = HHT_klok_Item_Fragment.newInstance();

        //初始化默认加载主Fragment
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.klok_content, fragment_klok).hide(fragment_klok);
        ft.add(R.id.klok_content, ttmvFrament).hide(ttmvFrament);
        ft.show(fragment_klok).commit();
        currentPageId = KLOK;
        showPageBtn(false);


    }

    @Override
    protected HHT_klok_Persenter createPresenter() {
        return new HHT_klok_Persenter();
    }


    void showPageBtn(boolean show) {
        previous_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        next_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    void showNextPageBtn(boolean show) {
        previous_page.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
        next_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onChangedPage(int pageId) {
        FragmentTransaction ft = manager.beginTransaction();
        switch (pageId) {
            case KLOK:
                //切换回klok
                titleBar.setTitle(R.string.hht_ly_klok);
                hideOtherFrangment(ft, fragment_klok);
                currentPageId = KLOK;
                break;
            case TTMTV:
                titleBar.setTitle(R.string.hht_ly_klok_ttmtv);
                initItemFragmentPage(ft, TTMTV);
                break;
            case JDEG:
                titleBar.setTitle(R.string.hht_ly_klok_jdeg);
                initItemFragmentPage(ft, JDEG);
                break;
        }

    }

    /**
     * 显示兔兔MTV、经典儿歌
     */
    private void initItemFragmentPage(FragmentTransaction ft, int currentPage) {

        LogUtils.e("tll", "HHT_klok_Activity-----onChangedPage:" + currentPage);
        hideOtherFrangment(ft, ttmvFrament);
        getPresenter().getFragments(currentPage);
        currentPageId = currentPage;

    }

    /**
     * 隐藏掉其他的Fragment
     *
     * @param ft
     */
    private void hideOtherFrangment(FragmentTransaction ft, Fragment needShowFragment) {
        List<Fragment> fragments = manager.getFragments();
        for (Fragment f : fragments) {
            ft.hide(f);
        }
        ft.show(needShowFragment).commit();
        showPageBtn(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previous_page:
                LogUtils.e("tlh", "HHT_zjyy_Activity----previous_page");
//                slide_to_the_right();
                break;
            case R.id.next_page:
                LogUtils.e("tlh", "HHT_zjyy_Activity----next_page");
//                slide_to_the_left();
                break;
        }
    }

    @Override
    public void setFragments(final List<Fragment> ttmvDataFragments) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Fragment fragment = manager.findFragmentById(R.id.klok_content);
                if (fragment instanceof HHT_klok_Item_Fragment)
                    ttmvFrament.setFragments(ttmvDataFragments);
            }
        });
    }
}
