package com.boyue.boyuelauncher.main;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.BaseView;

import java.util.List;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public interface MainView extends BaseView {

    //系统音量发生变化时回调
     void setCurrentVolune(int currentVolune);

    void setFragments(List<Fragment> fragments);

}
