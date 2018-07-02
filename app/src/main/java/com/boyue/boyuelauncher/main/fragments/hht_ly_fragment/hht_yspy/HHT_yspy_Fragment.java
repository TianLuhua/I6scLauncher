package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy;

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

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_ACTION_KLOK;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE_KEY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_LDEG;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_THCZ;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_XXHJ;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_YSZL;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_ZQYY;

/**
 * Created by Tianluhua on 2018/6/7.
 */

public class HHT_yspy_Fragment extends ItemBaseFragment {

    private GridView gridLayout;
    private FragmentItemAdapter fragmentItemAdapter;
    private ItemDataCallBack callBack;
    private Context mContext;

    public static HHT_yspy_Fragment newInstance() {
        return new HHT_yspy_Fragment();
    }

    public HHT_yspy_Fragment() {
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
                        ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YSPY_ZQYY);
                        getActivity().overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                        break;
                    case 1:
                        ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YSPY_THCZ);
                        getActivity().overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                        break;
                    case 2:
                        ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YSPY_YSZL);
                        getActivity().overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                        break;
                    case 3:
                        ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YSPY_XXHJ);
                        getActivity().overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
                        break;
                    case 4:
                        ActivityUtils.setActivityConfig(ACTIVITY_ACTION_KLOK, HHTLY_KLOK_PAGE_KEY, HHTLY_YSPY_LDEG);
                        getActivity().overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
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
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_ly_yspy_image);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_ly_yspy_text);

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


//
}
