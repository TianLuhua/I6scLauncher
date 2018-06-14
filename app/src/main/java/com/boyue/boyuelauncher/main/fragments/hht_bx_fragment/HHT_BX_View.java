package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment;

import android.graphics.drawable.Drawable;

import com.boyue.boyuelauncher.base.BaseView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public interface HHT_BX_View extends BaseView {

     void displayIocn(Drawable icon);

     void setItemicon(ArrayList<Map<String, Object>> list);
}
