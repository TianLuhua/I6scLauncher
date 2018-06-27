package com.boyue.boyuelauncher.main.fragments;

import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.jdeg.HHT_Klok_Jdeg_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.jdeg.HHT_Klok_Jdeg_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.jdeg.HHT_Klok_Jdeg_03_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_03_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_04_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_klok.ttmtv.HHT_Klok_ttmtv_05_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.htcz.HHT_htcz_Fragment_01;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.htcz.HHT_htcz_Fragment_02;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.syzl.HHT_yszl_Fragment_01;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.zqyy.HHT_zqyy_Fragment_01;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg.fragment.HHT_yweg_fragment_01;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg.fragment.HHT_yweg_fragment_02;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yweg.fragment.HHT_yweg_fragment_03;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yzyx.HHT_yzyx_Fragment_01;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yzyx.HHT_yzyx_Fragment_02;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjxt.HHT_zjxt_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.daban.HHT_zjyy_Daban_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.daban.HHT_zjyy_Daban_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.duona.HHT_zjyy_Duona_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.duona.HHT_zjyy_Duona_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.xiaoban.HHT_zjyy_Xiaoban_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.xiaoban.HHT_zjyy_Xiaoban_02_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.zhongban.HHT_zjyy_zhongban_01_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.hht_zjyy.zhongban.HHT_zjyy_zhongban_02_Fragment;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;

import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_KLOK_JDEG;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_KLOK_TTMTV;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_THCZ;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_YSZL;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YSPY_ZQYY;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YWEG;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTLY_YZYX;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJXT;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_DABAN;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_ENGLISH;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_XIAOBAN;
import static com.boyue.boyuelauncher.main.fragments.HHT_Item_Activity.HHTXT_ZJYY_ZHONGBAN;

/**
 * Created by Tianluhua on 2018/6/26.
 */

public class HHT_Item_Persenter extends AbstractPresenter<HHT_Item_View> {


    public void getFragments(final int currentPage) {
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                List<Fragment> fragments = new ArrayList<>();
                switch (currentPage) {
                    //火火兔乐园--卡拉ok---兔兔MTV
                    case HHTLY_KLOK_TTMTV:
                        Fragment ttmtv_01 = HHT_Klok_ttmtv_01_Fragment.newInstance();
                        Fragment ttmtv_02 = HHT_Klok_ttmtv_02_Fragment.newInstance();
                        Fragment ttmtv_03 = HHT_Klok_ttmtv_03_Fragment.newInstance();
                        Fragment ttmtv_04 = HHT_Klok_ttmtv_04_Fragment.newInstance();
                        Fragment ttmtv_05 = HHT_Klok_ttmtv_05_Fragment.newInstance();
                        fragments.clear();
                        fragments.add(ttmtv_01);
                        fragments.add(ttmtv_02);
                        fragments.add(ttmtv_03);
                        fragments.add(ttmtv_04);
                        fragments.add(ttmtv_05);
                        getView().setFragments(fragments);
                        break;
                    //火火兔乐园--卡拉ok---经典儿歌
                    case HHTLY_KLOK_JDEG:
                        Fragment jdeg_01 = HHT_Klok_Jdeg_01_Fragment.newInstance();
                        Fragment jdeg_02 = HHT_Klok_Jdeg_02_Fragment.newInstance();
                        Fragment jdeg_03 = HHT_Klok_Jdeg_03_Fragment.newInstance();
                        fragments.clear();
                        fragments.add(jdeg_01);
                        fragments.add(jdeg_02);
                        fragments.add(jdeg_03);
                        getView().setFragments(fragments);
                        break;
                    //火火兔乐园--英文儿歌
                    case HHTLY_YWEG:
                        Fragment hhtly_yweg_01 = HHT_yweg_fragment_01.newInstance();
                        Fragment hhtly_yweg_02 = HHT_yweg_fragment_02.newInstance();
                        Fragment hhtly_yweg_03 = HHT_yweg_fragment_03.newInstance();
                        fragments.add(hhtly_yweg_01);
                        fragments.add(hhtly_yweg_02);
                        fragments.add(hhtly_yweg_03);
                        getView().setFragments(fragments);
                        break;
                    //火火兔乐园--艺术培养--智趣音乐
                    case HHTLY_YSPY_ZQYY:
                        Fragment hhtly_yspy_zqyy = HHT_zqyy_Fragment_01.newInstance();
                        fragments.add(hhtly_yspy_zqyy);
                        getView().setFragments(fragments);
                        break;
                    //火火兔乐园--艺术培养--艺术之旅
                    case HHTLY_YSPY_YSZL:
                        Fragment hhtly_yspy_yszl = HHT_yszl_Fragment_01.newInstance();
                        fragments.add(hhtly_yspy_yszl);
                        getView().setFragments(fragments);
                        break;
                    //火火兔乐园--艺术培养--画图创作
                    case HHTLY_YSPY_THCZ:
                        Fragment hhtly_yspy_htcz_01 = HHT_htcz_Fragment_01.newInstance();
                        Fragment hhtly_yspy_htcz_02 = HHT_htcz_Fragment_02.newInstance();
                        fragments.add(hhtly_yspy_htcz_01);
                        fragments.add(hhtly_yspy_htcz_02);
                        getView().setFragments(fragments);
                        break;
                    //火火兔乐园--益智游戏
                    case HHTLY_YZYX:
                        Fragment hhtly_yzyx_01 = HHT_yzyx_Fragment_01.newInstance();
                        Fragment hhtly_yzyx_02 = HHT_yzyx_Fragment_02.newInstance();
                        fragments.add(hhtly_yzyx_01);
                        fragments.add(hhtly_yzyx_02);
                        getView().setFragments(fragments);
                        break;

                    //早教学堂
                    case HHTXT_ZJXT:
                        Fragment hht_zjxt = HHT_zjxt_Fragment.newInstance();
                        fragments.add(hht_zjxt);
                        getView().setFragments(fragments);
                        break;
                    //早教英语--小班
                    case HHTXT_ZJYY_XIAOBAN:
                        Fragment hht_zjyy_Xiaoban_01 = HHT_zjyy_Xiaoban_01_Fragment.newInstance();
                        Fragment hht_zjyy_Xiaoban_02 = HHT_zjyy_Xiaoban_02_Fragment.newInstance();
                        fragments.add(hht_zjyy_Xiaoban_01);
                        fragments.add(hht_zjyy_Xiaoban_02);
                        getView().setFragments(fragments);
                        break;
                    //早教英语--中班
                    case HHTXT_ZJYY_ZHONGBAN:
                        Fragment hht_zjyy_zhongban_01 = HHT_zjyy_zhongban_01_Fragment.newInstance();
                        Fragment hht_zjyy_zhongban_02 = HHT_zjyy_zhongban_02_Fragment.newInstance();
                        fragments.add(hht_zjyy_zhongban_01);
                        fragments.add(hht_zjyy_zhongban_02);
                        getView().setFragments(fragments);
                        break;
                    //早教英语--大班
                    case HHTXT_ZJYY_DABAN:
                        Fragment hht_zjyy_daban_01 = HHT_zjyy_Daban_01_Fragment.newInstance();
                        Fragment hht_zjyy_daban_02 = HHT_zjyy_Daban_02_Fragment.newInstance();
                        fragments.add(hht_zjyy_daban_01);
                        fragments.add(hht_zjyy_daban_02);
                        getView().setFragments(fragments);
                        break;
                    //早教英语--多纳英语
                    case HHTXT_ZJYY_ENGLISH:
                        Fragment hht_zjyy_duoan_01 = HHT_zjyy_Duona_01_Fragment.newInstance();
                        Fragment hht_zjyy_duoan_02 = HHT_zjyy_Duona_02_Fragment.newInstance();
                        fragments.add(hht_zjyy_duoan_01);
                        fragments.add(hht_zjyy_duoan_02);
                        getView().setFragments(fragments);

                        break;


                }
            }
        });


    }
}
