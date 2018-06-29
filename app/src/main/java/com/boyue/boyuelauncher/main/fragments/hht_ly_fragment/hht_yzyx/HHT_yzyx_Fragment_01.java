package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yzyx;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.adapter.FragmentItemAdapter;
import com.boyue.boyuelauncher.main.fragments.base.ItemBaseFragment;
import com.boyue.boyuelauncher.main.fragments.base.ItemDataCallBack;
import com.boyue.boyuelauncher.main.fragments.entity.APPEntity;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_01;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_02;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_03;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_04;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_05;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_06;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_07;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_LY_YZYX_08;

public class HHT_yzyx_Fragment_01 extends ItemBaseFragment {


    private GridView gridLayout;
    private FragmentItemAdapter fragmentItemAdapter;
    private ItemDataCallBack callBack;
    private Context mContext;

    public static HHT_yzyx_Fragment_01 newInstance() {
        return new HHT_yzyx_Fragment_01();
    }

    public HHT_yzyx_Fragment_01() {
        // Required empty public constructor
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_base_item;
    }

    @Override
    protected void init() {
        gridLayout = findViewById(R.id.gridlayout);
        fragmentItemAdapter = new FragmentItemAdapter(getContext(), 144, 144, FragmentItemAdapter.IconType.ITEM);
        gridLayout.setAdapter(fragmentItemAdapter);
        gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_01);
                        break;
                    case 1:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_02);
                        break;
                    case 2:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_03);
                        break;
                    case 3:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_04);
                        break;
                    case 4:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_05);
                        break;
                    case 5:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_06);
                        break;
                    case 6:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_07);
                        break;
                    case 7:
                        ActivityUtils.startApplicationWithPackageName(HHT_LY_YZYX_08);
                        break;
                }
            }
        });

        callBack = new ItemDataCallBack() {
            @Override
            public void getIcon(Drawable iconDrawble) {

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
        };
        mContext = getContext();
        loadData();

    }

    //异步加载图标
    protected void loadData() {

        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                final List<APPEntity> appEntities = new ArrayList<>();
                //图标
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_ly_yzyx_items_page01_image);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_ly_yzyx_items_page01_text);

                for (int i = 0; i < names.length(); i++) {
                    APPEntity appEntity = new APPEntity();
                    appEntity.setNameRes(names.getResourceId(i, 0));
                    appEntity.setIconRes(icnos.getResourceId(i, 0));
                    appEntities.add(appEntity);
                }
                icnos.recycle();
                names.recycle();
                if (callBack == null) return;
                callBack.setItemicon(appEntities);
            }
        });

    }
}