package com.boyue.boyuelauncher.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.io.File;

public class SDAndUSBStatusView extends RelativeLayout implements View.OnClickListener {


    private AppCompatImageView sDView;
    private AppCompatImageView uSBView;

    public SDAndUSBStatusView(Context context) {
        super(context);
        initLayout(context);
    }

    public SDAndUSBStatusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public SDAndUSBStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context mContext) {
        LayoutInflater.from(mContext).inflate(R.layout.custome_layout_sd_usb, this);
        sDView = findViewById(R.id.sd);
        uSBView = findViewById(R.id.usb);
        sDView.setOnClickListener(this);
        uSBView.setOnClickListener(this);

        sDView.setVisibility(sdAndusbIsMounted(Config.MountPath.SD_PATH) ? View.VISIBLE : View.INVISIBLE);
        uSBView.setVisibility(sdAndusbIsMounted(Config.MountPath.SD_PATH) ? View.VISIBLE : View.INVISIBLE);

    }


    public void setShowSD(boolean showSD) {
        if (sDView.getVisibility() == View.VISIBLE) return;
        sDView.setVisibility(showSD ? View.VISIBLE : View.INVISIBLE);
    }

    public void setShowUSB(boolean showUSB) {
        if (uSBView.getVisibility() == View.VISIBLE) return;
        uSBView.setVisibility(showUSB ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sd:
                if (sDView.getVisibility()==View.VISIBLE)
                    onSDAndUSDViewClickListener.onSDIconClick(v);
                break;

            case R.id.usb:
                if (uSBView.getVisibility()==View.VISIBLE)
                    onSDAndUSDViewClickListener.onUSBIconClick(v);
                break;
        }

    }

    private OnSDAndUSDViewClickListener onSDAndUSDViewClickListener;

    public void setOnTitleBarClickListener(OnSDAndUSDViewClickListener onSDAndUSDViewClickListener) {
        this.onSDAndUSDViewClickListener = onSDAndUSDViewClickListener;
    }

    public interface OnSDAndUSDViewClickListener {

        void onSDIconClick(View view);

        void onUSBIconClick(View view);
    }


    private final BroadcastReceiver mediaMountedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null) return;
            String action = intent.getAction();
            Uri uri = intent.getData();
            String mountPath = uri.getPath();

            if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {

                LogUtils.e("tlh", "ACTION_MEDIA_MOUNTED+mountPath:" + mountPath);

                if (Config.MountPath.SD_PATH.equals(mountPath)) {
                    setShowSD(true);
                } else if (Config.MountPath.USB_PATH.equals(mountPath)) {
                    setShowUSB(true);
                }


            } else if (action.equals(Intent.ACTION_MEDIA_UNMOUNTED)) {

                LogUtils.e("tlh", "ACTION_MEDIA_UNMOUNTED+mountPath:" + mountPath);

                if (Config.MountPath.SD_PATH.equals(mountPath)) {
                    setShowSD(false);
                } else if (Config.MountPath.USB_PATH.equals(mountPath)) {
                    setShowUSB(false);
                }


            }

        }
    };

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        filter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
        filter.addDataScheme("file");
        getContext().registerReceiver(mediaMountedReceiver, filter);


    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(mediaMountedReceiver);
    }

    private boolean sdAndusbIsMounted(String path) {
        if (new File(path).exists()) {
            LogUtils.e("tlh", "path--->:" + path + "," + "true");
            return true;
        } else {
            LogUtils.e("tlh", "path--->:" + path + "," + "false");
            return false;
        }
    }

}
