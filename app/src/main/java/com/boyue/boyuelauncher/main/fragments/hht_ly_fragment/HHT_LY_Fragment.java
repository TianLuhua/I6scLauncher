package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.main.fragments.adapter.FragmentItemAdapter;
import com.boyue.boyuelauncher.main.fragments.base.ItemView;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;

import java.util.List;


/**
 * Created by Tianluhua on 2018/4/3.
 */

public class HHT_LY_Fragment extends AbstractMVPFragment<ItemView, HHT_LY_PersenterImp> implements ItemView {

    private EnlargeAndNarrowAnimationView iconView;
    private GridView displayApps;
    private FragmentItemAdapter fragmentItemAdapter;

    public static HHT_LY_Fragment newInstance() {
        return new HHT_LY_Fragment();
    }

    public HHT_LY_Fragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_grideview, null);
        init(view);
        return view;
    }


    private void init(View rootView) {
        iconView = rootView.findViewById(R.id.iocn);
        iconView.setEnlargeMultiple(1.05f);
        displayApps = rootView.findViewById(R.id.display_apps);
        fragmentItemAdapter = new FragmentItemAdapter(getContext(), 122, 125,FragmentItemAdapter.IconType.MAIN);
        displayApps.setAdapter(fragmentItemAdapter);
        displayApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getPresenter().startHHT_Activity(position);
            }
        });
        //初始化数据
        getPresenter().getItemIcon();


        getPresenter().getIconDrawble();

    }


    @Override
    public void displayIocn(Drawable icon) {
        if (icon != null && iconView != null)
            iconView.setImageDrawable(icon);
    }

    @Override
    public void setItemicon(final List<APPEntity> appEntities) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragmentItemAdapter.setAppEntities(appEntities);
            }
        });

    }


    @Override
    protected HHT_LY_PersenterImp createPresenter() {
        return new HHT_LY_PersenterImp(getActivity().getApplicationContext());
    }
}
