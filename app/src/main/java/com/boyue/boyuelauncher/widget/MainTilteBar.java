package com.boyue.boyuelauncher.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.FileUtils;
import com.boyue.boyuelauncher.utils.LogUtils;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class MainTilteBar extends RelativeLayout implements View.OnClickListener, Animation.AnimationListener {

    private RelativeLayout bg_volumeNumberView;
    private TextView volumeNumberView;
    private ImageView settingsButton;
    private WIFIStatusView wifiStatusView;
    private ImageView sDView;
    private ImageView uSBView;

    private Animation usbAnimation;
    private Animation sdAnimation;
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

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        filter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
        filter.addAction(Intent.ACTION_MEDIA_REMOVED);
        filter.addDataScheme("file");
        getContext().registerReceiver(mediaMountedReceiver, filter);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(mediaMountedReceiver);
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

        sDView = findViewById(R.id.sd);
        uSBView = findViewById(R.id.usb);
        sDView.setOnClickListener(this);
        uSBView.setOnClickListener(this);

        usbAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);
        usbAnimation.setAnimationListener(this);

        sdAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);
        sdAnimation.setAnimationListener(this);

        settingBtnAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);
        settingBtnAnimation.setAnimationListener(this);

        wifiBtnAnimation = AnimationUtils.loadAnimation(mContext, R.anim.small_xysize);
        wifiBtnAnimation.setAnimationListener(this);

        //初始化sd卡和u盘的状态
        setShowSD(FileUtils.hasFile(Config.MountPath.SD_PATH) ? true : false);
        setShowUSB(FileUtils.hasFile(Config.MountPath.USB_PATH) ? true : false);
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
                break;

            case R.id.ic_wifistatusview:
                wifiStatusView.startAnimation(wifiBtnAnimation);

                break;
            case R.id.sd:
                if (sDView.getVisibility() == View.VISIBLE) {
                    sDView.startAnimation(sdAnimation);
                }
                break;
            case R.id.usb:
                if (uSBView.getVisibility() == View.VISIBLE) {
                    LogUtils.e("tlh", "uSBView----VISIBLE");
                    uSBView.startAnimation(usbAnimation);
                }
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

                //有些U盘和SD卡只发送Intent.ACTION_MEDIA_REMOVED广播
            } else if (action.equals(Intent.ACTION_MEDIA_UNMOUNTED) || action.equals(Intent.ACTION_MEDIA_REMOVED)) {
                LogUtils.e("tlh", "ACTION_MEDIA_UNMOUNTED+mountPath:" + mountPath);
                if (Config.MountPath.SD_PATH.equals(mountPath)) {
                    setShowSD(false);
                } else if (Config.MountPath.USB_PATH.equals(mountPath)) {
                    setShowUSB(false);
                }
            }
        }
    };

    /**
     * 显示sd卡的图标
     *
     * @param showSD
     */
    public void setShowSD(boolean showSD) {
        LogUtils.e("tlh", "setShowSD:" + showSD);
        sDView.setVisibility(showSD ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 显示usb的图标
     *
     * @param showUSB
     */
    public void setShowUSB(boolean showUSB) {
        LogUtils.e("tlh", "setShowUSB:" + showUSB);
        uSBView.setVisibility(showUSB ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == usbAnimation) {
            uSBView.clearAnimation();
            if (onTitleBarClickListener != null)
                onTitleBarClickListener.onUSBIconClick(null);
        }

        if (animation == sdAnimation) {
            sDView.clearAnimation();
            if (onTitleBarClickListener != null)
                onTitleBarClickListener.onSDIconClick(null);
        }
        if (animation == wifiBtnAnimation) {
            wifiStatusView.clearAnimation();
            if (onTitleBarClickListener != null)
                onTitleBarClickListener.onWiFiManagerClick(null);
        }

        if (animation == settingBtnAnimation) {
            settingsButton.clearAnimation();
            if (onTitleBarClickListener != null)
                onTitleBarClickListener.onSettingsClick(null);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

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
