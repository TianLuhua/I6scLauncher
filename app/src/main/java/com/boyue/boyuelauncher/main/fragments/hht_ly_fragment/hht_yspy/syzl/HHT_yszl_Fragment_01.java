package com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.hht_yspy.syzl;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.LazyLoadFragment;

public class HHT_yszl_Fragment_01 extends LazyLoadFragment {

    public static HHT_yszl_Fragment_01 newInstance() {
        return new HHT_yszl_Fragment_01();
    }

    public HHT_yszl_Fragment_01() {
        // Required empty public constructor
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_hht_yspy_yszl;
    }

    @Override
    protected void lazyLoad() {

    }


//
//    @Override
//    protected View getConentView(LayoutInflater inflater) {
//        return inflater.inflate(R.layout.activity_hht_yspy_yszl,null);
//    }
//
//    @Override
//    protected void slide_to_the_right() {
//
//    }
//
//    @Override
//    protected void slide_to_the_left() {
//
//    }
//
//    @Override
//    protected void initView() {
//        super.initView();
//        titleBar.setTitle(R.string.hht_ly_yspy_yszl);
//        titleBar.setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
//            @Override
//            public void onLeftIconClick(View view) {
//                finish();
//            }
//
//            @Override
//            public void onTitleClick(View view) {
//
//            }
//
//            @Override
//            public void onRightIconClick(View view) {
//
//            }
//        });
//    }
}