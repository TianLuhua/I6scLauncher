package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.fragment.HHT_klok_Fragment;
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

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_klok_Activity extends HHT_Abstract_Activity implements HHT_klok_Fragment.Notification_KLOK, View.OnClickListener {


    //卡拉ok主界面
    public static final int KLOK = 0x0000;
    //兔兔MTV
    public static final int TTMTV = 0x0001;
    //经典儿歌
    public static final int JDEG = 0x0002;


    //记录当前处于那一页
    private int currentPageId = KLOK;
    private FragmentManager manager;
    private Fragment fragment_klok, ttmtv_01, ttmtv_02, ttmtv_03, ttmtv_04, ttmtv_05, jdeg_01, jdeg_02, jdeg_03;
    //用于保存当前的Fragment
    private LinkedList<Fragment> fragments;
    //显示Fragment的标志位
    private int index = 0;


    private ImageView previous_page, next_page;


    @Override
    protected View getConentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_hht_klok, null);
    }


    @Override
    protected void initView() {
        super.initView();
        titleBar.setTitle(R.string.hht_ly_klok);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                index = 0;
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
        fragments = new LinkedList<>();

        manager = getSupportFragmentManager();

        fragment_klok = HHT_klok_Fragment.newInstance();

        //初始化默认加载主Fragment
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.klok_content, fragment_klok);
        ft.show(fragment_klok).commit();
        currentPageId = KLOK;
        showPageBtn(false);

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
        LogUtils.e("tll", "HHT_klok_Activity-----onChangedPage:" + pageId);
        FragmentTransaction ft = manager.beginTransaction();
        switch (pageId) {
            case KLOK:
                //切换回klok
                hideOtherFrangment(ft, fragment_klok);
                titleBar.setTitle(R.string.hht_ly_klok);
                currentPageId = KLOK;
                break;
            case TTMTV:
                initTTMTVFragment(ft);
                break;
            case JDEG:
                inintJDEGFragment(ft);
                break;
        }

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

    /**
     * 显示兔兔MTV
     */
    private void initTTMTVFragment(FragmentTransaction ft) {
        titleBar.setTitle(R.string.hht_ly_klok_ttmtv);

        //清除其他的Fragment
        ft.hide(fragment_klok);


        //显示兔兔MTV
        ttmtv_01 = HHT_Klok_ttmtv_01_Fragment.newInstance();
        ttmtv_02 = HHT_Klok_ttmtv_02_Fragment.newInstance();
        ttmtv_03 = HHT_Klok_ttmtv_03_Fragment.newInstance();
        ttmtv_04 = HHT_Klok_ttmtv_04_Fragment.newInstance();
        ttmtv_05 = HHT_Klok_ttmtv_05_Fragment.newInstance();
        fragments.clear();
        fragments.add(ttmtv_01);
        fragments.add(ttmtv_02);
        fragments.add(ttmtv_03);
        fragments.add(ttmtv_04);
        fragments.add(ttmtv_05);
        ft.add(R.id.klok_content, ttmtv_01).hide(ttmtv_01);
        ft.add(R.id.klok_content, ttmtv_02).hide(ttmtv_02);
        ft.add(R.id.klok_content, ttmtv_03).hide(ttmtv_03);
        ft.add(R.id.klok_content, ttmtv_04).hide(ttmtv_04);
        ft.add(R.id.klok_content, ttmtv_05).hide(ttmtv_05);
        ft.show(ttmtv_01);
        ft.commit();
        showNextPageBtn(true);
        currentPageId = TTMTV;
    }

    /**
     * 显示经典儿歌
     */
    private void inintJDEGFragment(FragmentTransaction ft) {
        titleBar.setTitle(R.string.hht_ly_klok_jdeg);


        //清除其他的Fragment,只有klok_fragment存在，因为是从klok_fragment进来的
        ft.hide(fragment_klok);

        //显示经典儿歌
        jdeg_01 = HHT_Klok_Jdeg_01_Fragment.newInstance();
        jdeg_02 = HHT_Klok_Jdeg_02_Fragment.newInstance();
        jdeg_03 = HHT_Klok_Jdeg_03_Fragment.newInstance();
        fragments.clear();
        fragments.add(jdeg_01);
        fragments.add(jdeg_02);
        fragments.add(jdeg_03);
        ft.add(R.id.klok_content, jdeg_01).hide(jdeg_01);
        ft.add(R.id.klok_content, jdeg_02).hide(jdeg_02);
        ft.add(R.id.klok_content, jdeg_03).hide(jdeg_03);
        ft.show(jdeg_01);
        ft.commit();
        showNextPageBtn(true);
        currentPageId = JDEG;
    }


    @Override
    protected void slide_to_the_right() {

        FragmentTransaction ft = manager.beginTransaction();
        index--;
        switch (currentPageId) {
            case KLOK:
                break;
            case TTMTV:
                //当前是处于兔兔MTV，处理左滑事件
                showJDEGFragment(ft,TTMTV, index);
                break;
            case JDEG:
                //当前是处于经典儿歌，处理左滑事件

                showJDEGFragment(ft,JDEG, index);

                break;
        }
    }


    @Override
    protected void slide_to_the_left() {
        FragmentTransaction ft = manager.beginTransaction();
        index++;
        switch (currentPageId) {
            case KLOK:
                break;
            case TTMTV:
                //当前是处于兔兔MTV，处理左滑事件
                showJDEGFragment(ft, TTMTV, index);
                break;
            case JDEG:
                //当前是处于经典儿歌，处理左滑事件
                showJDEGFragment(ft, JDEG, index);
                break;
        }
    }

    /**
     * 根据type和index显示Fragment
     *
     * @param ft
     * @param type  判断是 klok和是JDEG
     * @param index
     */
    private void showJDEGFragment(FragmentTransaction ft, int type, int index) {
        if (index >= fragments.size() || index < 0) return;
        Log.e("tlh", "showJDEGFragment---fragment.size():" + fragments.size() + ",index:" + index);
        for (int i = 0; i < fragments.size(); i++) {
            ft.hide(fragments.get(i));
        }
        Fragment fragment = fragments.get(index);
        ft.show(fragment).commit();
        if (JDEG == type) {
            switch (index) {
                case 0:
                    showNextPageBtn(true);
                    break;
                case 1:
                    showPageBtn(true);
                    break;
                case 2:
                    showNextPageBtn(false);
                    break;
            }
        } else if (TTMTV == type) {
            switch (index) {
                case 0:
                    showNextPageBtn(true);
                    break;
                case 1:
                    showPageBtn(true);
                    break;
                case 2:
                    showPageBtn(true);
                    break;
                case 3:
                    showPageBtn(true);
                    break;
                case 4:
                    showNextPageBtn(false);
                    break;
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previous_page:
                LogUtils.e("tlh", "HHT_zjyy_Activity----previous_page");
                slide_to_the_right();
                break;
            case R.id.next_page:
                LogUtils.e("tlh", "HHT_zjyy_Activity----next_page");
                slide_to_the_left();
                break;
        }
    }
}
