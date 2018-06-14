package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.HHT_zjyy_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.daban.HHT_zjyy_Daban_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.daban.HHT_zjyy_Daban_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.duona.HHT_zjyy_Duona_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.duona.HHT_zjyy_Duona_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.xiaoban.HHT_zjyy_Xiaoban_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.xiaoban.HHT_zjyy_Xiaoban_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.zhongban.HHT_zjyy_zhongban_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.zhongban.HHT_zjyy_zhongban_02_Fragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.TitleBar;

import java.util.List;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_zjyy_Activity extends HHT_Abstract_Activity implements HHT_zjyy_Fragment.Notification_ZJYY, View.OnClickListener {


    public static final int MAIN = 0x0000;
    //小班
    public static final int BONNIE_XIAOBAN = 0x0001;
    //中班
    public static final int BONNIE_ZHONGBAN = 0x0002;
    //大班
    public static final int BONNIE_DABAN = 0x0003;
    //多纳英语
    public static final int DONNA_ENGLISH = 0x0004;

    //记录当前处于那一页
    private int currentPageId = MAIN;

    private ImageView previous_page, next_page;


    private FragmentManager manager;
    private Fragment fragment_zjyy, xiaoban_01, xiaoban_02, zhongban_01, zhongban_02, daban_01, daban_02, duona_01, duona_02;
    private Fragment currentShowFragment;

    @Override
    protected View getConentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_hht_zjyy, null);
    }


    @Override
    protected void initView() {
        super.initView();
        titleBar.setTitle(R.string.hht_xt_zjyy);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                //用户点击返回键，如果不在主界面，那就先退回主界面
                if (currentPageId != MAIN) {
                    titleBar.setTitle(R.string.hht_xt_zjyy);
                    FragmentTransaction ft = manager.beginTransaction();
                    hideOtherFrangment(ft, fragment_zjyy);
                    currentPageId = MAIN;
                    showPageBtn(false);
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

        //初始化默认加载主Fragment
        fragment_zjyy = HHT_zjyy_Fragment.newInstance();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.zjyy_content, fragment_zjyy).show(fragment_zjyy);
        ft.commit();
        currentPageId = MAIN;
        showPageBtn(false);
    }

    @Override
    public void onChangedPage(int pageId) {
        LogUtils.e("tlh", "HHT_zjyy_Activity----onChangedPage：" + pageId);
        this.currentPageId = pageId;
        switch (pageId) {
            case BONNIE_XIAOBAN:
                titleBar.setTitle(R.string.hht_xt_zjyy_bnyyxb);
                showCurrentPage(pageId);
                break;
            case BONNIE_ZHONGBAN:
                titleBar.setTitle(R.string.hht_xt_zjyy_bnyyzb);
                showCurrentPage(pageId);
                break;
            case BONNIE_DABAN:
                titleBar.setTitle(R.string.hht_xt_zjyy_bnyydb);
                showCurrentPage(pageId);
                break;
            case DONNA_ENGLISH:
                titleBar.setTitle(R.string.hht_xt_zjyy_dnyy);
                showCurrentPage(pageId);
                break;
        }

    }


    /**
     * 根据pageId显示Fragment
     *
     * @param pageId
     */
    private void showCurrentPage(int pageId) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.hide(fragment_zjyy);
        switch (pageId) {
            case BONNIE_XIAOBAN:
                xiaoban_01 = HHT_zjyy_Xiaoban_01_Fragment.newInstance();
                xiaoban_02 = HHT_zjyy_Xiaoban_02_Fragment.newInstance();
                ft.add(R.id.zjyy_content, xiaoban_01).hide(xiaoban_01);
                ft.add(R.id.zjyy_content, xiaoban_02).hide(xiaoban_02);
                ft.show(xiaoban_01);
                ft.commit();
                currentShowFragment = xiaoban_01;
                currentPageId = BONNIE_XIAOBAN;
                break;
            case BONNIE_ZHONGBAN:
                zhongban_01 = HHT_zjyy_zhongban_01_Fragment.newInstance();
                zhongban_02 = HHT_zjyy_zhongban_02_Fragment.newInstance();
                ft.add(R.id.zjyy_content, zhongban_01).hide(zhongban_01);
                ft.add(R.id.zjyy_content, zhongban_02).hide(zhongban_02);
                ft.show(zhongban_01);
                ft.commit();

                currentShowFragment = zhongban_01;
                currentPageId = BONNIE_ZHONGBAN;
                break;
            case BONNIE_DABAN:

                daban_01 = HHT_zjyy_zhongban_01_Fragment.newInstance();
                daban_02 = HHT_zjyy_zhongban_02_Fragment.newInstance();

                ft.add(R.id.zjyy_content, daban_01).hide(daban_01);
                ft.add(R.id.zjyy_content, daban_02).hide(daban_02);
                ft.show(daban_01);
                ft.commit();

                currentShowFragment = daban_01;
                currentPageId = BONNIE_DABAN;
                break;
            case DONNA_ENGLISH:

                duona_01 = HHT_zjyy_Duona_01_Fragment.newInstance();
                duona_02 = HHT_zjyy_Duona_02_Fragment.newInstance();
                ft.add(R.id.zjyy_content, duona_01).hide(duona_01);
                ft.add(R.id.zjyy_content, duona_02).hide(duona_02);
                ft.show(duona_01);
                ft.commit();

                currentShowFragment = duona_01;
                currentPageId = DONNA_ENGLISH;
                break;
        }
        showNextPageBtn(true);
    }


    void showPageBtn(boolean show) {
        previous_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        next_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    //有下一页就显示，反之显示上一个button
    void showNextPageBtn(boolean show) {
        previous_page.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
        next_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
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
    protected void slide_to_the_right() {
        if (currentPageId == MAIN) return;
        FragmentTransaction ft = manager.beginTransaction();
        ft.hide(fragment_zjyy);
        switch (currentPageId) {
            case BONNIE_XIAOBAN:
                if (currentShowFragment == xiaoban_01) return;
                ft.show(xiaoban_01);
                ft.hide(xiaoban_02);
                ft.commit();
                currentShowFragment = xiaoban_01;
                break;
            case BONNIE_ZHONGBAN:
                if (currentShowFragment == zhongban_01) return;

                ft.show(zhongban_01);
                ft.hide(zhongban_02);
                ft.commit();
                currentShowFragment = zhongban_01;
                break;
            case BONNIE_DABAN:
                if (currentShowFragment == daban_01) return;
                ft.show(daban_01);
                ft.hide(daban_02);
                ft.commit();
                currentShowFragment = daban_01;

                break;
            case DONNA_ENGLISH:
                if (currentShowFragment == duona_01) return;
                ft.show(duona_01);
                ft.hide(duona_02);
                ft.commit();
                currentShowFragment = duona_01;
                break;

        }

        showNextPageBtn(true);

    }

    @Override
    protected void slide_to_the_left() {
        if (currentPageId == MAIN) return;
        FragmentTransaction ft = manager.beginTransaction();
        ft.hide(fragment_zjyy);
        switch (currentPageId) {
            case BONNIE_XIAOBAN:
                if (currentShowFragment == xiaoban_02) return;

                ft.hide(xiaoban_01);
                ft.show(xiaoban_02);
                ft.commit();
                currentShowFragment = xiaoban_02;
                break;
            case BONNIE_ZHONGBAN:
                if (currentShowFragment == zhongban_02) return;
                ft.hide(zhongban_01);
                ft.show(zhongban_02);
                ft.commit();
                currentShowFragment = zhongban_02;
                break;
            case BONNIE_DABAN:
                if (currentShowFragment == daban_02) return;
                ft.hide(daban_01);
                ft.show(daban_02);
                ft.commit();
                currentShowFragment = daban_02;
                break;
            case DONNA_ENGLISH:
                if (currentShowFragment == duona_02) return;
                ft.hide(duona_01);
                ft.show(duona_02);
                ft.commit();
                currentShowFragment = duona_02;
                break;
        }
        showNextPageBtn(false);

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
