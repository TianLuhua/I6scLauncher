package com.boyue.boyuelauncher.main.fragments.hht_ar_fragment;

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
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.EnlargeAndNarrowAnimationView;

import java.util.List;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public class HHT_AR_Fragment extends AbstractMVPFragment<HHT_AR_View, HHT_AR_PersenterImp> implements HHT_AR_View {

    public static final String INTERFACE_RESULT = HHT_AR_Fragment.class.getName() + "WithResault";


    private EnlargeAndNarrowAnimationView iconView;
    private GridView displayApps;

    private FragmentItemAdapter fragmentItemAdapter;

    public static HHT_AR_Fragment newInstance() {
        return new HHT_AR_Fragment();
    }

    public HHT_AR_Fragment() {
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
        fragmentItemAdapter = new FragmentItemAdapter(getContext(), 122, 125);
        displayApps.setAdapter(fragmentItemAdapter);
        displayApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getPresenter().startHHT_AR_Activity(position);
            }
        });

        //初始化item图标和文字
        getPresenter().getItemIcon();

        //加载大图标
        getPresenter().getIconDrawble();

    }


    @Override
    public void displayIocn(Drawable icon) {
        if (icon != null && iconView != null)
            iconView.setImageDrawable(icon);
    }


    @Override
    public void setItemicon(final List<APPEntity> appEntities) {
        LogUtils.e("tlh", "HHT_AR_Fragment--setItemicon--appEntities：" + appEntities.size());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragmentItemAdapter.setAppEntities(appEntities);
            }
        });
    }


    @Override
    protected HHT_AR_PersenterImp createPresenter() {
        return new HHT_AR_PersenterImp(getContext().getApplicationContext());
    }
}
