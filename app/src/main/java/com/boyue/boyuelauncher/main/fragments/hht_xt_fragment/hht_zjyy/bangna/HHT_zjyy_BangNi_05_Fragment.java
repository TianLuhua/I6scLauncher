package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.bangna;

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

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_33;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_34;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_35;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_36;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_37;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_38;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_39;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJYY_BANGNI_40;

public class HHT_zjyy_BangNi_05_Fragment extends ItemBaseFragment {


    private GridView gridLayout;
    private FragmentItemAdapter fragmentItemAdapter;
    private ItemDataCallBack callBack;
    private Context mContext;
    private final ArrayList<String> videoPathList;

    public static HHT_zjyy_BangNi_05_Fragment newInstance() {
        return new HHT_zjyy_BangNi_05_Fragment();
    }

    public HHT_zjyy_BangNi_05_Fragment() {
        // Required empty public constructor
        videoPathList = new ArrayList<>();
        videoPathList.add(HHT_XT_ZJYY_BANGNI_33);
        videoPathList.add(HHT_XT_ZJYY_BANGNI_34);
        videoPathList.add(HHT_XT_ZJYY_BANGNI_35);
        videoPathList.add(HHT_XT_ZJYY_BANGNI_36);
        videoPathList.add(HHT_XT_ZJYY_BANGNI_37);
        videoPathList.add(HHT_XT_ZJYY_BANGNI_38);
        videoPathList.add(HHT_XT_ZJYY_BANGNI_39);
        videoPathList.add(HHT_XT_ZJYY_BANGNI_40);
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
                ActivityUtils.startBoYueVideoPlayer(videoPathList.get(position));
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
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_bangni_items_page05_image);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_bangni_items_page05_text);

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

