package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment;

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

public class HHT_XT_Fragment extends AbstractMVPFragment<HHT_XT_View, HHT_XT_PersenterImp> implements HHT_XT_View {

    public static final String INTERFACE_RESULT = HHT_XT_Fragment.class.getName() + "NPNR";


    private AppCompatImageView iocnView;
    private GridView displayApps;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;


    public static HHT_XT_Fragment newInstance() {
        return new HHT_XT_Fragment();
    }

    public HHT_XT_Fragment() {
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
        //初始化数据
        initData();
        String[] from = {"img", "text"};
        int[] to = {R.id.icon, R.id.name};

        simpleAdapter = new SimpleAdapter(getActivity(), dataList, R.layout.layout_main_grideview_item, from, to);
        displayApps.setAdapter(simpleAdapter);
        displayApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        getPresenter().getIconDrawble();

    }

    private void initData() {

        //图标
        TypedArray icno = getResources().obtainTypedArray(R.array.hht_xt_items_image);

        //图标下的文字
        String name[] = getResources().getStringArray(R.array.hht_xt_items_text);
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", icno.getResourceId(i, 0));
            map.put("text", name[i]);
            dataList.add(map);
        }
    }


    @Override
    protected HHT_XT_PersenterImp createPresenter() {
        return new HHT_XT_PersenterImp(getActivity().getApplication());
    }
}
