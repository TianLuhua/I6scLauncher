package com.boyue.boyuelauncher.main.fragments.base;

import com.boyue.boyuelauncher.base.AbstractPresenter;

/**
 * Created by Tianluhua on 2018\7\20 0020.
 */
public abstract class ItemPersenter extends AbstractPresenter<ItemView> {

    //获取大图标
    public abstract void getIconDrawble();

    //启动每个item对应的item
    public abstract void startHHT_Activity(int position);

    //获取item的图标
    public abstract void getItemIcon();

}
