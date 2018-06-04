package com.boyue.boyuelauncher.main;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseView;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public interface MainView extends BaseView {

    //系统音量发生变化时回调
    public void setCurrentVolune(int currentVolune);

}
