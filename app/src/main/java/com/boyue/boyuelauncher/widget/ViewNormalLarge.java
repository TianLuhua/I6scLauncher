package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.widget.Toast;

import com.boyue.boyuelauncher.animation.EnlargeAndNarrowAnimation;

/**
 * Created by Tianluhua on 2018/5/22.
 */

public class ViewNormalLarge extends AppCompatImageView {

    private float viewH;
    private float viewW;
    private EnlargeAndNarrowAnimation animation;

    public ViewNormalLarge(Context context) {
        super(context);
    }

    public ViewNormalLarge(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewNormalLarge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                viewH = getHeight() / 2;
                viewW = getWidth() / 2;
                if (animation == null){

                    animation = new EnlargeAndNarrowAnimation(1.0f, 1.20f, 1.0f, 1.20f, viewW, viewH);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(getContext(),"Hello  world",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                }
                animation.setDuration(200);
                animation.start(this);

//                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.view_normal_to_large);


                break;
        }
        return super.onTouchEvent(event);
    }

}