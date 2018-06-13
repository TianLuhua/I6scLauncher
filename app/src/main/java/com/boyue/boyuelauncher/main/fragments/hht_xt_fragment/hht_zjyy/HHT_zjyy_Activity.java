package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.fragment.HHT_zjyy_Fragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_zjyy_Activity extends HHT_Abstract_Activity implements HHT_zjyy_Fragment.Notification_Main {


    //小班
    public static final int BONNIE_XIAOBAN = 0x0001;
    //中班
    public static final int BONNIE_ZHONGBAN = 0x0002;
    //大班
    public static final int BONNIE_DABAN = 0x0003;
    //多纳英语
    public static final int DONNA_ENGLISH = 0x0004;


    private FragmentManager manager;

    @Override
    protected View getConentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_hht_zjyy, null);
    }

    @Override
    protected void slide_to_the_right() {

    }

    @Override
    protected void slide_to_the_left() {

    }

    @Override
    protected void initView() {
        super.initView();
        titleBar.setTitle(R.string.hht_xt_zjyy);
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
        manager = getSupportFragmentManager();
        //初始化默认加载主Fragment
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.content, HHT_zjyy_Fragment.newInstance());
        fragmentTransaction.commit();
    }

    @Override
    public void onChangedPage(int pageId) {
        LogUtils.e("tlh", "HHT_zjyy_Activity----onChangedPage：" + pageId);


    }
}
