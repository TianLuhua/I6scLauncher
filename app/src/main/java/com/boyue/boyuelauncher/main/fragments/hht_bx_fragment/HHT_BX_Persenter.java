package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment;

import com.boyue.boyuelauncher.base.AbstractPresenter;

/**
 * Created by Tianluhua on 2018/5/17.
 */
public abstract class HHT_BX_Persenter extends AbstractPresenter<HHT_BX_View> {

    public abstract void getIconDrawble();

    public abstract void getItemIcon();

    public abstract void startHHT_BX_Item(int position);
}
