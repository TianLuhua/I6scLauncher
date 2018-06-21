package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseView;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;

import java.util.List;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public interface HHT_LY_View extends BaseView {

     void displayIocn(Drawable icon);

     void setItemicon(List<APPEntity> appEntities);
}
