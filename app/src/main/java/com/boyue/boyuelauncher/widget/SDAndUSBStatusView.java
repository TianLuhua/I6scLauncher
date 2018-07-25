package com.boyue.boyuelauncher.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.io.File;

public class SDAndUSBStatusView extends RelativeLayout implements View.OnClickListener {


    private AppCompatImageView sDView;
    private AppCompatImageView uSBView;
    private Animation usbAnimation;
    private Animation sdAnimation;

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
        usbAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);
        sdAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);

        //初始化sd卡和u盘的状态
        sDView.setVisibility(sdAndusbIsMounted(Config.MountPath.SD_PATH) ? View.VISIBLE : View.INVISIBLE);
        uSBView.setVisibility(sdAndusbIsMounted(Config.MountPath.USB_PATH) ? View.VISIBLE : View.INVISIBLE);

    }


    /**
     * 显示sd卡的图标
     *
     * @param showSD
     */
    public void setShowSD(boolean showSD) {
        sDView.setVisibility(showSD ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 显示usb的图标
     *
     * @param showUSB
     */
    public void setShowUSB(boolean showUSB) {
        uSBView.setVisibility(showUSB ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sd:
                if (sDView.getVisibility() == View.VISIBLE){
                    sDView.startAnimation(sdAnimation);
                    onSDAndUSDViewClickListener.onSDIconClick(v);
                }
                break;

            case R.id.usb:
                if (uSBView.getVisibility() == View.VISIBLE){
                    uSBView.startAnimation(usbAnimation);
                    onSDAndUSDViewClickListener.onUSBIconClick(v);
                }
                break;
        }

    }

    private OnSDAndUSDViewClickListener onSDAndUSDViewClickListener;

    public void setOnTitleBarClickListener(OnSDAndUSDViewClickListener onSDAndUSDViewClickListener) {
        this.onSDAndUSDViewClickListener = onSDAndUSDViewClickListener;
    }

    public interface OnSDAndUSDViewClickListener {

        //sd卡图标点击事件回调
        void onSDIconClick(View view);

        //u盘点击事件回调
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
                    //U盘挂载广播
                    context.sendBroadcast(new Intent(Config.BoYueAction.COM_BOYUE_ACTION_USB_MOUNTED));
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

    //机器刚刚起来时候，初始化sd卡和u盘的状态
    private boolean sdAndusbIsMounted(String path) {
        if (new File(path).list() != null) {
            LogUtils.e("tlh", "path--->:" + path + "," + "true");
            return true;
        } else {
            LogUtils.e("tlh", "path--->:" + path + "," + "false");
            return false;
        }
    }

}
