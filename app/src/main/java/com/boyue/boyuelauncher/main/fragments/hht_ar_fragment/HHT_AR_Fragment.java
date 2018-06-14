package com.boyue.boyuelauncher.main.fragments.hht_ar_fragment;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public class HHT_AR_Fragment extends AbstractMVPFragment<HHT_AR_View, HHT_AR_PersenterImp> implements HHT_AR_View {

    public static final String INTERFACE_RESULT = HHT_AR_Fragment.class.getName() + "WithResault";


    public static HHT_AR_Fragment newInstance() {
        return new HHT_AR_Fragment();
    }

    public HHT_AR_Fragment() {
        // Required empty public constructor
    }

    private AppCompatImageView iocnView;
    private GridView displayApps;
    private SimpleAdapter simpleAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_grideview, null);
        init(view);
        return view;
    }


    private void init(View rootView) {
        iocnView = rootView.findViewById(R.id.iocn);
        displayApps = rootView.findViewById(R.id.display_apps);


        //初始化item图标和文字
        getPresenter().getItemIcon();

        //加载大图标
        getPresenter().getIconDrawble();

    }


    @Override
    public void displayIocn(Drawable icon) {
        if (icon != null && iocnView != null)
            iocnView.setImageDrawable(icon);
    }


    @Override
    public void setItemicon(ArrayList<Map<String, Object>> dataList) {
        String[] from = {"img", "text"};
        int[] to = {R.id.icon, R.id.name};
        simpleAdapter = new SimpleAdapter(getContext(), dataList, R.layout.item_layout_main_grideview, from, to);
        displayApps.setAdapter(simpleAdapter);
        displayApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getPresenter().startHHT_AR_Activity(position);
            }
        });
    }


    @Override
    protected HHT_AR_PersenterImp createPresenter() {
        return new HHT_AR_PersenterImp(getContext().getApplicationContext());
    }
}
