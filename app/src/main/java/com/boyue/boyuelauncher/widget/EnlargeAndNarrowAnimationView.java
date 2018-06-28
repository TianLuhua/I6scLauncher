package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.animation.EnlargeAndNarrowAnimation;

/**
 * Created by Tianluhua on 2018/5/22.
 * 放大后，然后再按照同样的速率缩小。不会突然变小
 */

public class EnlargeAndNarrowAnimationView extends AppCompatImageView {

    private EnlargeAndNarrowAnimation animation;
    private int duration = 100;
    private float enlargeMultiple = 1.02f;

    public EnlargeAndNarrowAnimationView(Context context) {
        super(context);
        initAnimation();
    }

    public EnlargeAndNarrowAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAnimation();
    }

    public EnlargeAndNarrowAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAnimation();
    }

    void initAnimation() {
        ViewTreeObserver observer = getViewTreeObserver();
        OnGlobalLayoutListener globalLayoutListener = new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                float viewH = getHeight() / 2;
                float viewW = getWidth() / 2;
                LogUtils.e("tlh", "EnlargeAndNarrowAnimationView---viewH:" + viewH);
                animation = new EnlargeAndNarrowAnimation(1.0f, enlargeMultiple, 1.0f, enlargeMultiple, viewW, viewH);
            }
        };
        observer.addOnGlobalLayoutListener(globalLayoutListener);

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getEnlargeMultiple() {
        return enlargeMultiple;
    }

    public void setEnlargeMultiple(float enlargeMultiple) {
        this.enlargeMultiple = enlargeMultiple;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtils.e("tlh", "EnlargeAndNarrowAnimationView---onTouchEvent---ACTION_DOWN");
                if (animation != null) {
                    animation.setDuration(duration);
                    animation.start(this);
                }

                break;

            case MotionEvent.ACTION_UP:
                LogUtils.e("tlh", "EnlargeAndNarrowAnimationView---ACTION_UP---ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                LogUtils.e("tlh", "EnlargeAndNarrowAnimationView---ACTION_UP---ACTION_MOVE");
                break;
        }
        return super.onTouchEvent(event);
    }

}