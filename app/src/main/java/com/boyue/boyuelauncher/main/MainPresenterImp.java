package com.boyue.boyuelauncher.main;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.main.adapter.MainPagerAdapter;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class MainPresenterImp extends MainPersenter {

    private MainMode mainMode;

    public MainPresenterImp(Context mContext) {
        mainMode = new MainModeImp(mContext, new MainMode.CallBack() {
            @Override
            public void setBgDrawcle(Drawable current) {
                if (getView() == null) return;
                getView().setBgDrawble(current);
            }
        });
    }

    @Override
    void getBG() {
        if (mainMode == null) return;
        mainMode.getBGDrawble();

    }
}
