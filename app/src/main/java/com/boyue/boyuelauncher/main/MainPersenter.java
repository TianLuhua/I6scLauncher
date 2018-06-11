package com.boyue.boyuelauncher.main;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.base.BaseView;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public abstract class MainPersenter extends AbstractPresenter<MainView> {

    //获取系统音量
    abstract void getCurrentVolune();

    //匹配系统密码
    abstract boolean matchingPwd(String pwd);

    //是否启用防沉迷密码
    public abstract boolean hasEnableFCMPWD();
}
