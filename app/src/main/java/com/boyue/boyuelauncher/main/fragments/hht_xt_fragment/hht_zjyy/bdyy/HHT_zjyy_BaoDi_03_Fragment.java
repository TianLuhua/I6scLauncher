package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.bdyy;

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

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_01;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_02;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_03;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_04;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_05;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_06;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_07;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_DABAN_08;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_16;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_17;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_18;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_19;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_20;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_21;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_22;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_23;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BAODI_24;

public class HHT_zjyy_BaoDi_03_Fragment extends ItemBaseFragment {


    private GridView gridLayout;
    private FragmentItemAdapter fragmentItemAdapter;
    private ItemDataCallBack callBack;
    private Context mContext;
    private final ArrayList<String> videoPathList;

    public static HHT_zjyy_BaoDi_03_Fragment newInstance() {
        return new HHT_zjyy_BaoDi_03_Fragment();
    }

    public HHT_zjyy_BaoDi_03_Fragment() {
        // Required empty public constructor
        videoPathList = new ArrayList<>();
        videoPathList.add(HHT_XT_ZJYY_BAODI_17);
        videoPathList.add(HHT_XT_ZJYY_BAODI_18);
        videoPathList.add(HHT_XT_ZJYY_BAODI_19);
        videoPathList.add(HHT_XT_ZJYY_BAODI_20);
        videoPathList.add(HHT_XT_ZJYY_BAODI_21);
        videoPathList.add(HHT_XT_ZJYY_BAODI_22);
        videoPathList.add(HHT_XT_ZJYY_BAODI_23);
        videoPathList.add(HHT_XT_ZJYY_BAODI_24);
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
                ActivityUtils.startBoYueVideoPlayer(videoPathList, position);
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
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_baodi_items_page02_image);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_baodi_items_page03_text);

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
