package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_zjyy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/6.
 */

public class HHT_ZJYY_Activity extends AppCompatActivity {

    private TitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hht_zjyy);
        initView();
    }

    private void initView() {

        titleBar=findViewById(R.id.title_bar);
    }
}
