package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.boyue.boyuelauncher.R;

public class TitleBar extends RelativeLayout implements View.OnClickListener {


    private AppCompatImageView leftIcon;
    private AppCompatImageView rightIcon;
    private AppCompatTextView title;
    private boolean showRightIcon = false;

    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {

        View.inflate(context, R.layout.custome_title_bar, this);
        leftIcon = findViewById(R.id.left_icon);
        rightIcon = findViewById(R.id.right_icon);
        title = findViewById(R.id.title);
        leftIcon.setOnClickListener(this);
        title.setOnClickListener(this);
        rightIcon.setOnClickListener(this);

        if (!showRightIcon) {
            rightIcon.setVisibility(View.INVISIBLE);
        }

    }

    public void setShowRightIcon(boolean showRightIcon) {

        this.showRightIcon = showRightIcon;
        rightIcon.setVisibility(this.showRightIcon ? View.VISIBLE : View.INVISIBLE);

    }

    public void setTitle(int resId) {

        title.setText(getResources().getText(resId));
    }

    public void setLeftIcon(int resId) {
        leftIcon.setBackgroundResource(resId);
    }

    public void setRightIcon(int resId) {
        if (rightIcon.getVisibility() == View.INVISIBLE) {
            rightIcon.setVisibility(View.VISIBLE);
        }
        rightIcon.setBackgroundResource(resId);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_icon:
                if (onTitleBarClickListener == null) return;
                onTitleBarClickListener.onLeftIconClick(v);
                break;
            case R.id.right_icon:
                if (onTitleBarClickListener == null || showRightIcon) return;
                onTitleBarClickListener.onRightIconClick(v);
                break;
            case R.id.title:
                if (onTitleBarClickListener == null) return;
                onTitleBarClickListener.onTitleClick(v);
                break;
        }


    }


    private OnTitleBarClickListener onTitleBarClickListener;

    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener) {
        this.onTitleBarClickListener = onTitleBarClickListener;
    }


    public interface OnTitleBarClickListener {

        //左边图标点击事件回调
        void onLeftIconClick(View view);

        //Title点击事件回调
        void onTitleClick(View view);

        //右边图标点击事件回调
        void onRightIconClick(View view);
    }

}
