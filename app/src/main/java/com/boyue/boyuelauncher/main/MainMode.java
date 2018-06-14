package com.boyue.boyuelauncher.main;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.BaseMode;

import java.util.List;

/**
 * Created by Tianluhua on 2018/5/29.
 */
public interface MainMode extends BaseMode {

    void getCurrentVolume();

    void getFragments();


    public interface CallBack {

        void setCurrentVolume(int currentVolume);

        void volumeChange(int volume);

        void setFragments(List<Fragment> fragments);
    }
}
