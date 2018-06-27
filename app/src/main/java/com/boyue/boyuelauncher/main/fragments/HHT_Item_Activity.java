package com.boyue.boyuelauncher.main.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.adapter.SystemFragmentPagerAdapter;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.widget.TitleBar;

import java.util.List;

import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_KLOK_PAGE;

/**
 * Created by Tianluhua on 2018/6/26.
 */

public class HHT_Item_Activity extends AbstractMVPActivity<HHT_Item_View, HHT_Item_Persenter> implements HHT_Item_View, View.OnClickListener, ViewPager.OnPageChangeListener {


    //火火兔乐园---卡拉ok
    public static final int HHTLY_KLOK_TTMTV = 0X001;
    public static final int HHTLY_KLOK_JDEG = 0X002;

    //火火兔乐园---艺术培养
    public static final int HHTLY_YSPY_ZQYY = 0X003;
    public static final int HHTLY_YSPY_THCZ = 0X004;
    public static final int HHTLY_YSPY_YSZL = 0X005;

    //火火兔乐园---益智游戏
    public static final int HHTLY_YZYX = 0X006;

    //火火兔乐园---英文儿歌
    public static final int HHTLY_YWEG = 0X007;

    //火火兔学堂---早教学堂
    public static final int HHTXT_ZJXT = 0X008;

    //早教英语--小班
    public static final int HHTXT_ZJYY_XIAOBAN = 0x009;
    //早教英语--中班
    public static final int HHTXT_ZJYY_ZHONGBAN = 0x0010;
    //早教英语--大班
    public static final int HHTXT_ZJYY_DABAN = 0x0011;
    //早教英语--多纳英语
    public static final int HHTXT_ZJYY_ENGLISH = 0x0012;

    private ViewPager viewPager;
    private SystemFragmentPagerAdapter adapter;
    private TitleBar titleBar;

    private int page;
    private int currentPageSize;
    private int currentPage;

    private ImageView previousPage, nextPage;

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_hht_klok_item;
    }

    @Override
    protected void initView() {
        titleBar = findViewById(R.id.title_bar);
        page = getIntent().getIntExtra(HHTLY_KLOK_PAGE, 0);
        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            @Override
            public void onLeftIconClick(View view) {
                finish();
                //Activity淡入淡出效果
                overridePendingTransition(R.anim.activity_in_alpha_0_to_1, R.anim.activity_out_alpha_1_to_0);
            }

            @Override
            public void onTitleClick(View view) {

            }

            @Override
            public void onRightIconClick(View view) {

            }
        });

        switch (page) {
            case HHTLY_KLOK_TTMTV:
                titleBar.setTitle(R.string.hht_ly_klok_ttmtv);
                break;
            case HHTLY_KLOK_JDEG:
                titleBar.setTitle(R.string.hht_ly_klok_jdeg);
                break;
            case HHTXT_ZJYY_XIAOBAN:
                titleBar.setTitle(R.string.hht_xt_zjyy_bnyyxb);
                break;
            case HHTXT_ZJYY_ZHONGBAN:
                titleBar.setTitle(R.string.hht_xt_zjyy_bnyyzb);
                break;
            case HHTXT_ZJYY_DABAN:
                titleBar.setTitle(R.string.hht_xt_zjyy_bnyydb);
                break;
            case HHTXT_ZJYY_ENGLISH:
                titleBar.setTitle(R.string.hht_xt_zjyy_dnyy);
                break;
            case HHTXT_ZJXT:
                titleBar.setTitle(R.string.hht_xt_item_name_102);
                break;

            case HHTLY_YWEG:
                titleBar.setTitle(R.string.hht_ly_item_name_102);
                break;

            case HHTLY_YZYX:
                titleBar.setTitle(R.string.hht_ly_yzyx);
                break;


            case HHTLY_YSPY_ZQYY:
                titleBar.setTitle(R.string.hht_ly_yspy_zqyy);
                break;
            case HHTLY_YSPY_THCZ:
                titleBar.setTitle(R.string.hht_ly_yspy_thcz);
                break;
            case HHTLY_YSPY_YSZL:
                titleBar.setTitle(R.string.hht_ly_yspy_yszl);
                break;


        }

        viewPager = findViewById(R.id.pager);
        adapter = new SystemFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        previousPage = findViewById(R.id.previous_page);
        previousPage.setOnClickListener(this);
        nextPage = findViewById(R.id.next_page);
        nextPage.setOnClickListener(this);
    }

    @Override
    protected HHT_Item_Persenter createPresenter() {
        return new HHT_Item_Persenter();
    }


    @Override
    protected void onResume() {
        super.onResume();
        //获取加载数据，会在setFragments处返回
        getPresenter().getFragments(page);
    }

    @Override
    public void setFragments(List<Fragment> ttmvDataFragments) {
        adapter.setFragments(ttmvDataFragments);
        this.currentPageSize = ttmvDataFragments.size();
        //如果只有一页，那就默认不显示翻页按钮
        if (this.currentPage == 1) {
            previousPage.setVisibility(View.INVISIBLE);
            nextPage.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previous_page:
                currentPage--;
                if (currentPage == currentPageSize - 1)
                    currentPage = currentPageSize - 1;
                viewPager.setCurrentItem(currentPage, false);

                break;
            case R.id.next_page:
                currentPage++;
                if (currentPage == 0)
                    currentPage = 0;
                viewPager.setCurrentItem(currentPage, false);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        if (0 < position && position < currentPageSize - 1) {
            previousPage.setVisibility(View.VISIBLE);
            nextPage.setVisibility(View.VISIBLE);
        }

        if (position == 0) {
            previousPage.setVisibility(View.INVISIBLE);
            nextPage.setVisibility(View.VISIBLE);
        }

        if (position == currentPageSize - 1) {
            previousPage.setVisibility(View.VISIBLE);
            nextPage.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
