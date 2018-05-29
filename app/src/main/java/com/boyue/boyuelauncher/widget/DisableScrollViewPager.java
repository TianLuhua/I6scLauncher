package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DisableScrollViewPager extends ViewPager {

    private boolean isCanScroll;

    public DisableScrollViewPager(Context context) {
        super(context);
    }

    public DisableScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setScanScroll(boolean isCanScroll) {

        this.isCanScroll = isCanScroll;

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return (!isCanScroll ? false : super.onInterceptTouchEvent(ev));
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return (!isCanScroll ? false : super.onTouchEvent(ev));
    }
}
