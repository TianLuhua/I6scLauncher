package com.boyue.boyuelauncher.wifimanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

import java.util.ArrayList;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class WiFiManagerModeImp implements WiFiManagerMode {


    private Context mContext;
    private Callback callback;

    private WifiManager wifiManager;
    private WifiReceiver wifiReceiver;

    private ArrayList<ScanResult> scanResultList;//扫描wifi列表
    private ArrayList<WifiModel> dataList;//wifi列表显示

    public WiFiManagerModeImp(Context mContext, Callback callback) {
        this.mContext = mContext;
        this.callback = callback;
        this.wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        callback.setWifiManager(wifiManager);
        this.scanResultList = new ArrayList<>();
        this.dataList = new ArrayList<>();
    }


    /**
     * 获取wifi列表
     */
    private void loadData() {
        scanResultList.clear();
        scanResultList.addAll(wifiManager.getScanResults());
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String connectWifi = "";
        if (wifiInfo != null) {
            connectWifi = wifiInfo.getSSID().replaceAll("\"", "");
        }
        if (scanResultList != null && scanResultList.size() > 0) {
            dataList.clear();
            for (ScanResult result : scanResultList) {
                if (TextUtils.isEmpty(result.SSID)) {
                    continue;
                }
                WifiModel model = new WifiModel();
                model.setWifiName(result.SSID);
                StringBuilder detail = new StringBuilder();
                detail.append("加密方案:" + result.capabilities + "\n");
                detail.append("物理地址(MAC):" + result.BSSID + "\n");
                detail.append("信号电平(RSSI):" + result.level + "\n");
                detail.append("热点频率(MHz):" + result.frequency);
                model.setWifiDetail(detail.toString());
                if (result.capabilities.contains("WEP")) {
                    model.setWifiType(1);
                } else if (result.capabilities.contains("WPA")) {
                    model.setWifiType(2);
                } else {
                    model.setWifiType(0);
                }
                model.setIntensity(wifiManager.calculateSignalLevel(result.level, 5));//信号强度
                model.setConnect(connectWifi.equals(result.SSID));//是否连接
                dataList.add(model);
            }
        }
        if (dataList.size() > 0) {
            //拿到数据，回调到Presenter
            if (callback == null) return;
            callback.scnnered(dataList);


        } else {
            //数据异常，请处理
            if (callback==null)return;
            callback.scnnerFail();
        }
    }


    @Override
    public void onDestroy() {

    }

    @Override
    public void registerReceiver() {
        wifiReceiver = new WifiReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);//wifi的打开与关闭
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);//wifi扫描
        intentFilter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);//wifi验证密码
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);//wifi连接成功
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);//wifi信号强度
        mContext.registerReceiver(wifiReceiver, intentFilter);
    }

    @Override
    public void unregisterReceiver() {
        mContext.unregisterReceiver(wifiReceiver);
    }

    @Override
    public void startScnner() {
        if (wifiManager.isWifiEnabled()) {
            wifiManager.startScan();//启动扫描
            if (callback != null) {
                callback.startScnner();
            }
        } else {
            wifiManager.setWifiEnabled(true);
        }

    }


    public static interface Callback {

        void setWifiManager(WifiManager wifiManager);

        //开始扫描
        void startScnner();

        //回调当前wifi扫描结果
        void scnnered(ArrayList<WifiModel> dataList);

        //扫描失败
        void scnnerFail();

    }


    /**
     * wifi广播
     */
    class WifiReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
                switch (wifiState) {
                    case WifiManager.WIFI_STATE_DISABLED:
                        ToastUtil.showShortToast("Wifi关闭");
                        break;
                    case WifiManager.WIFI_STATE_ENABLED:
                        wifiManager.startScan();//Wifi打开,启动扫描
                        ToastUtil.showShortToast("Wifi打开");
                        break;
                }
            } else if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
                loadData();//扫描完成
                ToastUtil.showShortToast("Wifi扫描完成");
            } else if (WifiManager.RSSI_CHANGED_ACTION.equals(action)) {
                wifiManager.startScan();//信号强度变化，重新扫描
                ToastUtil.showShortToast("信号强度变化，重新扫描");
            } else if (WifiManager.SUPPLICANT_STATE_CHANGED_ACTION.equals(action)) {
                WifiInfo info = wifiManager.getConnectionInfo();
                SupplicantState state = info.getSupplicantState();
                if (state == SupplicantState.COMPLETED) {
                    wifiManager.startScan();//验证成功,启动扫描
                    ToastUtil.showShortToast("验证成功,启动扫描");
                }
                int errorCode = intent.getIntExtra(WifiManager.EXTRA_SUPPLICANT_ERROR, -1);
                if (errorCode == WifiManager.ERROR_AUTHENTICATING) {
                    ToastUtil.showShortToast("验证失败");
                }
            } else if (WifiManager.SUPPLICANT_STATE_CHANGED_ACTION.equals(action)) {
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                if (wifiInfo != null) {
                    String wifiSSID = wifiInfo.getSSID();
                    ToastUtil.showShortToast(wifiSSID + "连接成功");
                }
            }
        }
    }
}
