package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_zjyy_Activity extends HHT_Abstract_Activity {

    @Override
    protected View getConentView(LayoutInflater inflater) {
        return new TextView(getApplicationContext());
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
    }
}
