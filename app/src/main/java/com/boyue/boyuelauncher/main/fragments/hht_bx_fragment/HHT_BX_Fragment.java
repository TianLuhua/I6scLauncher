package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment;

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
import com.boyue.boyuelauncher.main.fragments.adapter.FragmentItemAdapter;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;

import java.util.List;


/**
 * Created by Tianluhua on 2018/4/3.
 */

public class HHT_BX_Fragment extends AbstractMVPFragment<HHT_BX_View, HHT_BX_PersenterImp> implements HHT_BX_View {
    public static final String INTERFACE_RESULT = HHT_BX_Fragment.class.getName() + "NR";


    private AppCompatImageView iocnView;
    private GridView displayApps;
    private SimpleAdapter simpleAdapter;
    private FragmentItemAdapter fragmentItemAdapter;

    public static HHT_BX_Fragment newInstance() {
        return new HHT_BX_Fragment();
    }

    public HHT_BX_Fragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_grideview, null);
        init(view);
        return view;
    }


    @Override
    public void displayIocn(Drawable icon) {
        if (icon != null && iocnView != null)
            iocnView.setImageDrawable(icon);
    }

    private void init(View rootView) {
        iocnView = rootView.findViewById(R.id.iocn);
        displayApps = rootView.findViewById(R.id.display_apps);
        fragmentItemAdapter = new FragmentItemAdapter(getContext(),122,125);
        displayApps.setAdapter(fragmentItemAdapter);
        displayApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        //初始化数据
        getPresenter().getItemIcon();

        getPresenter().getIconDrawble();

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
    protected HHT_BX_PersenterImp createPresenter() {
        return new HHT_BX_PersenterImp(getContext().getApplicationContext());
    }
}
