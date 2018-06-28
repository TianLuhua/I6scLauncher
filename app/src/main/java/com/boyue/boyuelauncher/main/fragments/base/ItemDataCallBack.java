package com.boyue.boyuelauncher.main.fragments.base;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;

import java.util.List;

/**
 * Created by Tianluhua on 2018\6\28 0028.
 */
public interface ItemDataCallBack {

    void getIcon(Drawable iconDrawble);

    void setItemicon(List<APPEntity> appEntities);
}
