package com.boyue.boyuelauncher.main.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tianluhua on 2018\6\28 0028.
 */
public abstract class ItemBaseFragment extends Fragment {

    protected final String TAG = "ItemBaseFragment";

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setContentView(), container, false);
        /*初始化Fragment中的视图、View*/
        init();
        return view;
    }


    /**
     * 设置Fragment要显示的布局
     *
     * @return 布局的layoutId
     */
    protected abstract int setContentView();


    /**
     * 舒适化Fragment中的视图
     */

    protected abstract void init();

    /**
     * 获取设置的布局
     *
     * @return
     */
    protected View getContentView() {
        return view;
    }

    /**
     * 找出对应的控件
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findViewById(int id) {

        return (T) getContentView().findViewById(id);
    }


}
