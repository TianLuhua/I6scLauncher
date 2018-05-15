package com.boyue.boyuelauncher.widget;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Tianluhua on 2018/5/15.
 */
public class WIFIStatusView extends AppCompatImageView {

    private WifiManager wifiManager;


    public WIFIStatusView(Context context) {
        super(context,null);
    }

    public WIFIStatusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public WIFIStatusView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }


    private final BroadcastReceiver wifiBroadcasterReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
                switch (wifiState) {
                    case WifiManager.WIFI_STATE_DISABLED:
                        //Wifi关闭
                        getDrawable().setLevel(5);
                        break;
                    case WifiManager.WIFI_STATE_ENABLED:
                        //Wifi打开
                        getDrawable().setLevel(6);
                        break;
                }
            } else if (WifiManager.RSSI_CHANGED_ACTION.equals(action)) {
                //信号强度变化
                 int currentWiFiStrength=getCurrentWiFiStrength();
                 getDrawable().setLevel(currentWiFiStrength);

            }

        }
    };

    private int getCurrentWiFiStrength() {
        // Wifi的连接速度及信号强度：
        int strength = 0;
        WifiInfo info = wifiManager.getConnectionInfo();
        if (info.getBSSID() != null) {
            // 链接信号强度，5为获取的信号强度值在5以内
            strength = WifiManager.calculateSignalLevel(info.getRssi(), 5);
        }
        return strength;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);//wifi的打开与关闭
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);//wifi连接成功
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);//wifi信号强度
        getContext().registerReceiver(wifiBroadcasterReceiver,intentFilter,null,getHandler());

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(wifiBroadcasterReceiver);
    }
}
