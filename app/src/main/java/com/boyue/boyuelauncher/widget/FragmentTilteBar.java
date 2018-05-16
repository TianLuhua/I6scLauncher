package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.boyue.boyuelauncher.R;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class FragmentTilteBar extends RelativeLayout implements View.OnClickListener {

    private ImageView backButton;
    private ImageView settingsButton;

    public FragmentTilteBar(Context context) {
        this(context, null);
    }

    public FragmentTilteBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FragmentTilteBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context mContext) {
        View.inflate(mContext, R.layout.fragment_title_bar, this);
        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(this);
        settingsButton = findViewById(R.id.settings);
        settingsButton.setOnClickListener(this);
    }

    private OnTitleBarClickListener onTitleBarClickListener;

    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener) {
        this.onTitleBarClickListener = onTitleBarClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                if (onTitleBarClickListener != null)
                    onTitleBarClickListener.onBackClick(v);
                break;

            case R.id.settings:
                if (onTitleBarClickListener != null)
                    onTitleBarClickListener.onSettingsClick(v);
                break;

            default:
                break;
        }
    }

    public interface OnTitleBarClickListener {

        //返回按钮事件回调
        void onBackClick(View view);

        //设置按钮事件回调
        void onSettingsClick(View view);
    }


}
