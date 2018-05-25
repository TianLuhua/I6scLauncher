package com.boyue.boyuelauncher.main.fragment.hht_ly_fragment;

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

public class HHT_LY_Fragment extends AbstractMVPFragment<HHT_LY_View, HHT_LY_PersenterImp> implements HHT_LY_View {
    public static final String INTERFACE_RESULT = HHT_LY_Fragment.class.getName() + "PR";


    public static HHT_LY_Fragment newInstance() {
        return new HHT_LY_Fragment();
    }

    public HHT_LY_Fragment() {
        // Required empty public constructor
    }

    private AppCompatImageView iocnView;
    private GridView displayApps;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_hht_ly, null);
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
        String[] from = {"icon", "name"};
        int[] to = {R.id.img, R.id.text};
        simpleAdapter = new SimpleAdapter(getActivity(), dataList, R.layout.main_gridview_item, from, to);
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
        int icno[] = getResources().getIntArray(R.array.hht_ly_items_image);

        //图标下的文字
        String name[] = getResources().getStringArray(R.array.hht_ly_items_text);
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < icno.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("icon", icno[i]);
            map.put("name", name[i]);
            dataList.add(map);
        }
    }


    @Override
    protected HHT_LY_PersenterImp createPresenter() {
        return new HHT_LY_PersenterImp(getActivity().getApplicationContext());
    }
}
