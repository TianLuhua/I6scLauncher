package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class MainTilteBar extends RelativeLayout implements View.OnClickListener {

    private TextView volumeNumberView;
    private ImageView settingsButton;
    private WIFIStatusView wifiStatusView;

    public MainTilteBar(Context context) {
        this(context, null);
    }

    public MainTilteBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainTilteBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context mContext) {
        View.inflate(mContext, R.layout.main_title_bar, this);
        volumeNumberView = findViewById(R.id.set_system_volume);
        volumeNumberView.setOnClickListener(this);
        settingsButton = findViewById(R.id.settings);
        settingsButton.setOnClickListener(this);
        wifiStatusView = findViewById(R.id.wifistatusview);
        wifiStatusView.setOnClickListener(this);
    }

    private OnTitleBarClickListener onTitleBarClickListener;

    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener) {
        this.onTitleBarClickListener = onTitleBarClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_system_volume:
                if (onTitleBarClickListener != null)
                    onTitleBarClickListener.onBackClick(v);
                break;

            case R.id.settings:
                if (onTitleBarClickListener != null)
                    onTitleBarClickListener.onSettingsClick(v);
                break;
            case R.id.wifistatusview:
                if (onTitleBarClickListener != null)
                    onTitleBarClickListener.onWiFiManagerClick(v);
                break;

            default:
                break;
        }
    }

    public void setVolumeMumber(int volumeMumber) {
        if (volumeNumberView == null) return;
        volumeNumberView.setText(String.valueOf(volumeMumber));

    }

    public void setVolumeMumberColor(int volumeMumberColor) {
        if (volumeNumberView == null) return;
        volumeNumberView.setTextColor(volumeMumberColor);

    }

    public interface OnTitleBarClickListener {

        //返回按钮事件回调
        void onBackClick(View view);

        //设置按钮事件回调
        void onSettingsClick(View view);

        //设置WIFIManager事件的回调
        void onWiFiManagerClick(View view);
    }


}
