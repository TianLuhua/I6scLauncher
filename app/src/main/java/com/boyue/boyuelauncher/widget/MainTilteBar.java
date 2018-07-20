package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class MainTilteBar extends RelativeLayout implements View.OnClickListener, SDAndUSBStatusView.OnSDAndUSDViewClickListener {

    private TextView volumeNumberView;
    private RelativeLayout bg_volumeNumberView;
    private ImageView settingsButton;
    private WIFIStatusView wifiStatusView;

    private SDAndUSBStatusView sdAndUSBStatusView;
    private Animation settingBtnAnimation;
    private Animation wifiBtnAnimation;


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
        View.inflate(mContext, R.layout.custome_main_title_bar, this);
        volumeNumberView = findViewById(R.id.ic_set_system_volume);
        bg_volumeNumberView = findViewById(R.id.bg_set_system_volume);
        bg_volumeNumberView.setOnClickListener(this);
        settingsButton = findViewById(R.id.ic_settings);
        settingsButton.setOnClickListener(this);
        wifiStatusView = findViewById(R.id.ic_wifistatusview);
        wifiStatusView.setOnClickListener(this);
        //SDAndUSBStatusView
        sdAndUSBStatusView = findViewById(R.id.ic_media);
        sdAndUSBStatusView.setOnTitleBarClickListener(this);
        settingBtnAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);
        wifiBtnAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);
    }

    private OnTitleBarClickListener onTitleBarClickListener;

    public void setOnTitleBarClickListener(OnTitleBarClickListener onTitleBarClickListener) {
        this.onTitleBarClickListener = onTitleBarClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bg_set_system_volume:
                if (onTitleBarClickListener != null)
                    onTitleBarClickListener.onBackClick(v);
                break;

            case R.id.ic_settings:
                settingsButton.startAnimation(settingBtnAnimation);
                if (onTitleBarClickListener != null)
                    onTitleBarClickListener.onSettingsClick(v);
                break;
            case R.id.ic_wifistatusview:
                wifiStatusView.startAnimation(wifiBtnAnimation);
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

    @Override
    public void onSDIconClick(View view) {
        if (onTitleBarClickListener != null)
            onTitleBarClickListener.onSDIconClick(view);
    }

    @Override
    public void onUSBIconClick(View view) {
        if (onTitleBarClickListener != null)
            onTitleBarClickListener.onUSBIconClick(view);

    }

    public interface OnTitleBarClickListener {

        //返回按钮事件回调
        void onBackClick(View view);

        //设置按钮事件回调
        void onSettingsClick(View view);

        //设置WIFIManager事件的回调
        void onWiFiManagerClick(View view);

        //设置SD图标事件的回调
        void onSDIconClick(View view);

        //设置USB图标事件的回调
        void onUSBIconClick(View view);
    }


}
