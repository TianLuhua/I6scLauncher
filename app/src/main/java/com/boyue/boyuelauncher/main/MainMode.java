package com.boyue.boyuelauncher.main;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseMode;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public interface MainMode extends BaseMode {

    void getBGDrawble();


    public interface CallBack {

        void setBgDrawcle(Drawable current);
    }
}
