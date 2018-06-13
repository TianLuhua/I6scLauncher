package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg.fragment.HHT_yweg_fragment_01;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg.fragment.HHT_yweg_fragment_02;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg.fragment.HHT_yweg_fragment_03;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.TitleBar;

public class HHT_yweg_Activity extends HHT_Abstract_Activity implements View.OnClickListener {


    public static final int FRAGMENT_01 = 0x0001;
    public static final int FRAGMENT_02 = 0x0002;
    public static final int FRAGMENT_03 = 0x0003;


    private ImageView previous_page, next_page;
    private FragmentManager manager;
    private Fragment fragment_01, fragment_02, fragment_03;
    private int currentPageId = FRAGMENT_01;

    @Override
    protected View getConentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_hht_yweg, null);
    }


    @Override
    protected void initView() {
        super.initView();
        titleBar.setTitle(R.string.hht_ly_yweg);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                finish();
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

        fragment_01 = HHT_yweg_fragment_01.newInstance();
        fragment_02 = HHT_yweg_fragment_02.newInstance();
        fragment_03 = HHT_yweg_fragment_03.newInstance();

        //初始化默认加载主Fragment
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.yweg_content, fragment_02).hide(fragment_02);
        ft.add(R.id.yweg_content, fragment_03).hide(fragment_03);
        ft.add(R.id.yweg_content, fragment_01).show(fragment_01).commit();
        currentPageId = FRAGMENT_01;
        previous_page.setVisibility( View.INVISIBLE);
        next_page.setVisibility(View.VISIBLE);
    }



    @Override
    protected void slide_to_the_right() {
        if (currentPageId == FRAGMENT_01) return;
        currentPageId -= 1;
        showCurrentPage(currentPageId);

    }

    @Override
    protected void slide_to_the_left() {
        if (currentPageId == FRAGMENT_03) return;
        currentPageId += 1;
        showCurrentPage(currentPageId);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.previous_page:
                LogUtils.e("tlh", "HHT_yweg_Activity----previous_page");
                slide_to_the_right();
                break;
            case R.id.next_page:
                LogUtils.e("tlh", "HHT_yweg_Activity----next_page");
                slide_to_the_left();
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

        switch (pageId) {
            case FRAGMENT_01:
                ft.show(fragment_01);
                ft.hide(fragment_02);
                ft.hide(fragment_03);
                ft.commit();
                previous_page.setVisibility(View.INVISIBLE);
                next_page.setVisibility(View.VISIBLE);
                break;
            case FRAGMENT_02:
                ft.hide(fragment_01);
                ft.show(fragment_02);
                ft.hide(fragment_03);
                ft.commit();
                showPageBtn(true);
                break;
            case FRAGMENT_03:
                ft.hide(fragment_01);
                ft.hide(fragment_02);
                ft.show(fragment_03);
                ft.commit();
                previous_page.setVisibility(View.VISIBLE);
                next_page.setVisibility(View.INVISIBLE);
                break;
        }
    }
    void showPageBtn(boolean show) {
        previous_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        next_page.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }
}
