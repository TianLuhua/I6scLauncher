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
            public void setCurrentVolume(int currentVolume) {
                MainView view = getView();
                if (view != null) {
                    view.setCurrentVolune(currentVolume);
                }
            }

            @Override
            public void volumeChange(int changedVolume) {
                MainView view = getView();
                if (view == null) return;
                view.setCurrentVolune(changedVolume);
            }
        });
    }

    @Override
    void getCurrentVolune() {
        if (mainMode == null) return;
        mainMode.getCurrentVolume();

    }

    @Override
    public void detachView() {
        super.detachView();
        if (mainMode == null) return;
        mainMode.onDestroy();
    }
}
