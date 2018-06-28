package com.boyue.boyuelauncher.widget.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by Tianluhua on 2018/5/22.
 */

public class EnlargeAndNarrowAnimation extends ScaleAnimation {

    private ScaleAnimation narrowAnimation;
    private EnlargeAndNarrowAnimationListener mAnimationListener;
    private View mView;


    public EnlargeAndNarrowAnimation(float fromX, float toX, float fromY, float toY) {
        super(fromX, toX, fromY, toY);
        narrowAnimation = new ScaleAnimation(toX, fromX, toY, fromY, 0, 0);
        init();
    }

    public EnlargeAndNarrowAnimation(float fromX, float toX, float fromY, float toY, float pivotX, float pivotY) {
        super(fromX, toX, fromY, toY, pivotX, pivotY);
        narrowAnimation = new ScaleAnimation(toX, fromX, toY, fromY, pivotX, pivotY);
        init();
    }

    public EnlargeAndNarrowAnimation(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
        super(fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue);
        narrowAnimation = new ScaleAnimation(toX, fromX, toY, fromY, pivotXType, pivotXValue, pivotYType, pivotYValue);
        init();
    }

    private void init() {
        narrowAnimation.setFillAfter(false);
        narrowAnimation.setAnimationListener(narrowAnimationListener);
        super.setFillAfter(false);
        super.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (mView == null) return;
                narrowAnimation.setDuration(getDuration());
                mView.startAnimation(narrowAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private AnimationListener narrowAnimationListener = new AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            if (mAnimationListener == null) return;
            mAnimationListener.onAnimationStart(mView);

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (mAnimationListener == null) return;
            mAnimationListener.onAnimationEnd(mView);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    public void start(View view) {
        this.mView = view;
        if (view == null) return;
        view.startAnimation(this);
    }


    public void setNarrowAnimationListener(EnlargeAndNarrowAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public interface EnlargeAndNarrowAnimationListener {

        void onAnimationStart(View view);

        void onAnimationEnd(View view);
    }

}
