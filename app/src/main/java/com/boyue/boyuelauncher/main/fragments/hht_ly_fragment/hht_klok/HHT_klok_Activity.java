package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.base.HHT_Abstract_Activity;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_klok_Activity extends HHT_Abstract_Activity {
        @Override
        protected View getConentView(LayoutInflater inflater) {
            return inflater.inflate(R.layout.activity_hht_klok,null);
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
            titleBar.setTitle(R.string.hht_ly_klok);
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
