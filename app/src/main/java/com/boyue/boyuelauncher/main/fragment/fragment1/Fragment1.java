package com.boyue.boyuelauncher.main.fragment.fragment1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.widget.FragmentTilteBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public class Fragment1 extends AbstractMVPFragment<Fragment_1_View, Fragment_1_Persenter> implements Fragment_1_View {

    public static final String INTERFACE_RESULT = Fragment1.class.getName() + "NPNR";


    private AppCompatImageView iocn;
    private GridView displayApps;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> dataList;


    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_1, null);
        FragmentTilteBar tilteBar = view.findViewById(R.id.title_bar);
        tilteBar.setOnTitleBarClickListener(new FragmentTilteBar.OnTitleBarClickListener() {
            @Override
            public void onBackClick(View view) {
                Toast.makeText(getContext(), "BACK", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSettingsClick(View view) {
                Toast.makeText(getContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
            }
        });
//        Button btn = (Button) view.findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    mFunctionManager.invokeFunction(INTERFACE_RESULT);
//                } catch (FunctionExcepstion functionExcepstion) {
//                    functionExcepstion.printStackTrace();
//                }
//            }
//        });

        init(view);
        return view;
    }


    @Override
    public void displayIocn(Bitmap icon) {

    }

    private void init(View rootView) {
        iocn = rootView.findViewById(R.id.iocn);
        displayApps = rootView.findViewById(R.id.display_apps);
        //初始化数据
        initData();
        String[] from = {"img", "text"};
        int[] to = {R.id.item_img, R.id.item_text};

        simpleAdapter=new SimpleAdapter(getActivity(), dataList, R.layout.gridview_item, from, to);
        displayApps.setAdapter(simpleAdapter);
        displayApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });



    }

    private void initData() {
        //图标
        int icno[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        //图标下的文字
        String name[] = {"时钟", "信号", "宝箱", "秒钟", "大象", "FF"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < icno.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text", name[i]);
            dataList.add(map);
        }
    }

    @Override
    protected Fragment_1_Persenter createPresenter() {
        return new Fragment_1_Persenter();
    }


}
