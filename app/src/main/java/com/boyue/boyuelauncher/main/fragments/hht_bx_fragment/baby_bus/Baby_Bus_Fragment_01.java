package com.boyue.boyuelauncher.main.fragments.hht_bx_fragment.baby_bus;

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

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_00;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_01;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_02;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_03;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_04;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_05;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_06;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_ZXBX_BABY_BUS_07;

/**
 * Created by Tianluhua on 2018\6\28 0028.
 */
public class Baby_Bus_Fragment_01 extends ItemBaseFragment {


    private GridView gridLayout;
    private FragmentItemAdapter fragmentItemAdapter;
    private ItemDataCallBack callBack;
    private Context mContext;


    public static Baby_Bus_Fragment_01 newInstance() {
        return new Baby_Bus_Fragment_01();
    }

    public Baby_Bus_Fragment_01() {
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
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_00);
                        break;
                    case 1:
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_01);
                        break;
                    case 2:
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_02);
                        break;
                    case 3:
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_03);
                        break;
                    case 4:
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_04);
                        break;
                    case 5:
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_05);
                        break;
                    case 6:
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_06);
                        break;
                    case 7:
                        ActivityUtils.startApplicationWithPackageName(HHT_ZXBX_BABY_BUS_07);
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
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_bx_baby_bus_items_image_page_01);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_bx_baby_bus_items_text_page_01);

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
