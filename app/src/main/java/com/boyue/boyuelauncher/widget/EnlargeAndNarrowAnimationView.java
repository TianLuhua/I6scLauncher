package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.boyue.boyuelauncher.widget.animation.EnlargeAndNarrowAnimation;

/**
 * Created by Tianluhua on 2018/5/22.
 */

public class EnlargeAndNarrowAnimationView extends AppCompatImageView {

    private float viewH;
    private float viewW;
    private EnlargeAndNarrowAnimation animation;

    public EnlargeAndNarrowAnimationView(Context context) {
        super(context);
    }

    public EnlargeAndNarrowAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EnlargeAndNarrowAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                viewH = getHeight() / 2;
                viewW = getWidth() / 2;
                if (animation == null) {

                    animation = new EnlargeAndNarrowAnimation(1.0f, 1.05f, 1.0f, 1.05f, viewW, viewH);

                }
                animation.setDuration(200);
                animation.start(this);

//                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.view_normal_to_large);


                break;
        }
        return super.onTouchEvent(event);
    }

}