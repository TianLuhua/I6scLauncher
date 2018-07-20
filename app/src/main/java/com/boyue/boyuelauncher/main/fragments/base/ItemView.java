package com.boyue.boyuelauncher.main.fragments.base;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseView;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;

import java.util.List;

/**
 * Created by Tianluhua on 2018\7\20 0020.
 */
public interface ItemView extends BaseView {

    //显示大图标
    void displayIocn(Drawable icon);

    //显示各个item的图标
    void setItemicon(List<APPEntity> appEntities);

}
