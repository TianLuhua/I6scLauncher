package com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.xiaoban;

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
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjxt.HHT_zjxt_Fragment;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;

import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_300WORDS_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_300WORDS_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_ENGLISH_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_ENGLISH_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_HEALTH_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_HEALTH_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_KONWLEGE_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_KONWLEGE_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_MATH_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_MATH_PACKAGE_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_PINYIN_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_PINYIN_PACKAGE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_POETRY_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.HHT_XT_ZJXT_POETRY_PACKAGE;

public class HHT_zjyy_Xiaoban_01_Fragment extends ItemBaseFragment {


    private GridView gridLayout;
    private FragmentItemAdapter fragmentItemAdapter;
    private ItemDataCallBack callBack;
    private Context mContext;

    public static HHT_zjyy_Xiaoban_01_Fragment newInstance() {
        return new HHT_zjyy_Xiaoban_01_Fragment();
    }

    public HHT_zjyy_Xiaoban_01_Fragment() {
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
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
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
                TypedArray icnos = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_xiaoban_items_page01_image);
                //图标下的文字
                TypedArray names = mContext.getResources().obtainTypedArray(R.array.hht_xt_zjyy_xiaoban_items_page01_text);

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
