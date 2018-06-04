package com.boyue.boyuelauncher.main;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.base.BaseView;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public abstract class MainPersenter extends AbstractPresenter<MainView> {

    //获取系统音量
    abstract void getCurrentVolune();

}
