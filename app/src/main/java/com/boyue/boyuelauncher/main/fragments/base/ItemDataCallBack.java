package com.boyue.boyuelauncher.main.fragments.base;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;

import java.util.List;

/**
 * Created by Tianluhua on 2018\6\28 0028.
 */
public interface ItemDataCallBack {

    //回调主界面中，左边的大图标
    void getIcon(Drawable iconDrawble);

    //回调界面上item的小图标
    void setItemicon(List<APPEntity> appEntities);
}
