package com.boyue.boyuelauncher.main.fragments.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.HideSystemUIUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.TitleBar;

/**
 * Created by Tianluhua on 2018/6/6.
 */

public abstract class HHT_Abstract_Activity extends AppCompatActivity {

    protected TitleBar titleBar;
    protected FrameLayout content;

    private float downY;
    private float downX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideSystemUIUtils.hideSystemUI(this);
        setContentView(R.layout.activity_hht);

    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }

    protected void initView() {
        titleBar = findViewById(R.id.title_bar);
        content = findViewById(R.id.content);
        content.addView(getConentView(LayoutInflater.from(getApplicationContext())));

    }

    //设置内容
    protected abstract View getConentView(LayoutInflater inflater);


    //向右滑动
    protected abstract void slide_to_the_right();

    //向左滑动
    protected abstract void slide_to_the_left();


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //在触发时回去到起始坐标
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //将按下时的坐标存储
                LogUtils.e("tlh", "HHT_Abstract_Activity---onTouchEvent---ACTION_DOWN");
                downX = x;
                downY = y;
                break;
            case MotionEvent.ACTION_UP:
                LogUtils.e("tlh", "HHT_Abstract_Activity---onTouchEvent---ACTION_UP");
                //获取到距离差
                float dx = x - downX;
                float dy = y - downY;
                //防止是按下也判断
                if (Math.abs(dx) > 2 && Math.abs(dy) > 2) {
                    //通过距离差判断方向
                    int orientation = getOrientation(dx, dy);
                    switch (orientation) {
                        case 'r':
                            slide_to_the_right();
                            break;
                        case 'l':
                            slide_to_the_left();
                            break;
                    }
                }
                break;

            case MotionEvent.ACTION_MOVE:
                LogUtils.e("tlh", "HHT_Abstract_Activity---onTouchEvent---ACTION_MOVE");

                break;
        }
        return super.onTouchEvent(event);
    }


    /**
     * 根据距离差判断 滑动方向
     *
     * @param dx X轴的距离差
     * @param dy Y轴的距离差
     * @return 滑动的方向
     */
    private int getOrientation(float dx, float dy) {
        if (Math.abs(dx) > Math.abs(dy)) {
            //X轴移动
            return dx > 0 ? 'r' : 'l';
        } else {
            //Y轴移动
            return dy > 0 ? 'b' : 't';
        }
    }
}
