package com.boyue.boyuelauncher.wifimanager;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class WiFiManagerActivity extends AbstractMVPActivity<WiFiManagerView,WiFiManagerPersenterImp> implements WiFiManagerView{
    @Override
    protected int getContentViewID() {
        return R.layout.activity_wifimanager;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected WiFiManagerPersenterImp createPresenter() {
        return new WiFiManagerPersenterImp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }




}
