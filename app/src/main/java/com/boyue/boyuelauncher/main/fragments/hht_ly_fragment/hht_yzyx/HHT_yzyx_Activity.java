package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yzyx;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_yzyx_Activity extends HHT_Abstract_Activity implements View.OnClickListener, HHT_yzyx_Fragment_01.Notification_01 {

    private ImageView previousPage;
    private ImageView nextPage;

    private FragmentManager manager;

    private HHT_yzyx_Fragment_01 hht_yzyx_fragment_01;
    private HHT_yzyx_Fragment_02 hht_yzyx_fragment_02;


    @Override
    protected View getConentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_hht_yzyx, null);
    }


    @Override
    protected void initView() {
        super.initView();

        titleBar.setTitle(R.string.hht_ly_yzyx);
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
        previousPage = findViewById(R.id.previous_page);
        previousPage.setOnClickListener(this);
        nextPage = findViewById(R.id.next_page);
        nextPage.setOnClickListener(this);

        hht_yzyx_fragment_01 = HHT_yzyx_Fragment_01.newInstance();
        hht_yzyx_fragment_02 = HHT_yzyx_Fragment_02.newInstance();
        manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.yzyx_content, hht_yzyx_fragment_01);
        fragmentTransaction.add(R.id.yzyx_content, hht_yzyx_fragment_02);
        fragmentTransaction.hide(hht_yzyx_fragment_02).show(hht_yzyx_fragment_01).commit();
        previousPage.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previous_page:
                showFragment_01();
                break;
            case R.id.next_page:
                showFragment_02();
                break;
        }

    }

    @Override
    protected void slide_to_the_right() {
        showFragment_01();
    }

    @Override
    protected void slide_to_the_left() {
        showFragment_02();
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        nextPage.setVisibility(!hidden ? View.VISIBLE : View.INVISIBLE);
        previousPage.setVisibility(hidden ? View.VISIBLE : View.INVISIBLE);
    }


    private void showFragment_01() {
        FragmentTransaction ft_01 = manager.beginTransaction();
        ft_01.hide(hht_yzyx_fragment_02).show(hht_yzyx_fragment_01).commit();
    }


    private void showFragment_02() {
        FragmentTransaction ft_02 = manager.beginTransaction();
        ft_02.hide(hht_yzyx_fragment_01).show(hht_yzyx_fragment_02).commit();
    }


}
