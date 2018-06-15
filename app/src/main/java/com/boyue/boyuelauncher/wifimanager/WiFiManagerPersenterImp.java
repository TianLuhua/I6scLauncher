package com.boyue.boyuelauncher.wifimanager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.KeyboardUtil;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_WiFi_IgnoreNetwork_Dialog;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public class WiFiManagerPersenterImp extends WiFiManagerPersenter implements WiFiManagerModeImp.Callback {

    private Context mContext;
    private WiFiManagerMode wiFiManagerMode;

    private WifiManager wifiManager;

    public WiFiManagerPersenterImp(Context mContext) {
        this.mContext = mContext;
        this.wiFiManagerMode = new WiFiManagerModeImp(mContext, this);

    }


    @Override
    public void igonreNetwork(WifiModel data, int position) {
        LogUtils.e("tll", "WiFiManagerPersenterImp--:" + data.toString());
        removeWifiBySsid(data.getWifiName());
    }

    @Override
    public void addNetwork(String ssid, String password, int wifiType) {
        LogUtils.e("tll", "WiFiManagerPersenterImp---addNetwork:" + "ssid:" + ssid + ",password:" + password + ",wifiType:" + wifiType);
        WifiConfiguration wifiConfig = createWifiInfo(ssid, password, wifiType);
        int netId = wifiManager.addNetwork(wifiConfig);
        if (netId != -1) {
            wifiManager.saveConfiguration();
        }
        boolean flag = wifiManager.enableNetwork(netId, true);
        ToastUtil.showShortToast("输入密码----启动连接：" + flag);

    }


    @Override
    public void registerReceiver() {
        wiFiManagerMode.registerReceiver();
    }

    @Override
    public void unregisterReceiver() {
        wiFiManagerMode.unregisterReceiver();
    }

    @Override
    public void checkWifiStatus() {
        boolean wifiEnable = wifiManager.isWifiEnabled();
        WiFiManagerView view = getView();
        if (view == null) return;
        view.getWifiStatus(wifiEnable);
    }

    @Override
    public void connectWifi(WifiModel data, Activity activity) {
        connectWifi(data.getWifiName(), data.getWifiType(), activity);
    }


    @Override
    public void setWifiEnabled(boolean isEnable) {

        wifiManager.setWifiEnabled(isEnable);
        getView().getWifiStatus(isEnable);
        if (isEnable) {
            openWifi();
        } else {
            getView().closeWifi();
        }
    }

    /**
     * 打开wifi
     */
    private void openWifi() {
        if (wiFiManagerMode == null) return;
        getView().startScnner();
        wiFiManagerMode.startScnner();
    }


    /**
     * 连接Wifi
     */
    private void connectWifi(final String ssid, final int wifiType, final Activity activity) {
        int networkId = -1;
        for (WifiConfiguration configuration : wifiManager.getConfiguredNetworks()) {
            String configId = configuration.SSID.replaceAll("\"", "");
            if (configId.equals(ssid)) {
                networkId = configuration.networkId;
                break;
            }
        }
        if (networkId != -1) {//已经连接配置过
            wifiManager.disconnect();
            wifiManager.enableNetwork(networkId, true);
            ToastUtil.showShortToast("已经配置----启动连接：" + true);
        } else {//新的连接
            if (wifiType != 0) {//需要密码
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("输入密码");
                LayoutInflater factory = LayoutInflater.from(mContext);
                View view = factory.inflate(R.layout.lay_dialog_input, null);
                final EditText etDialogInput = (EditText) view.findViewById(R.id.etDialogInput);
                builder.setView(view);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String code = etDialogInput.getText().toString();
                        if (TextUtils.isEmpty(code)) {
                            ToastUtil.showShortToast("请输入密码");
                            return;
                        }
                        WifiConfiguration wifiConfig = createWifiInfo(ssid, code, wifiType);
                        int netId = wifiManager.addNetwork(wifiConfig);
                        if (netId != -1) {
                            wifiManager.saveConfiguration();
                        }
                        boolean flag = wifiManager.enableNetwork(netId, true);
                        ToastUtil.showShortToast("输入密码----启动连接：" + flag);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setCancelable(true);
                builder.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        etDialogInput.requestFocus();
                        KeyboardUtil.showSoftInput(activity);
                    }
                }, 200);
            } else {//不需要密码
                WifiConfiguration wifiConfig = createWifiInfo(ssid, "", wifiType);
                int netId = wifiManager.addNetwork(wifiConfig);
                if (netId != -1) {
                    wifiManager.saveConfiguration();
                }
                boolean flag = wifiManager.enableNetwork(netId, true);
                ToastUtil.showShortToast("不需要密码---启动连接：" + flag);
            }
        }
    }


    /**
     * 创建Wifi
     *
     * @param SSID
     * @param password
     * @param wifiType
     * @return
     */
    public WifiConfiguration createWifiInfo(String SSID, String password, int wifiType) {
        //清空config
        WifiConfiguration config = new WifiConfiguration();
        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();
        config.SSID = "\"" + SSID + "\""; //wifi名称

        if (wifiType == 0) {
            config.wepKeys[0] = "";
            config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
            config.wepTxKeyIndex = 0;
        }
        if (wifiType == 1) {
            config.hiddenSSID = false;
            config.wepKeys[0] = "\"" + password + "\"";//密码
            config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.SHARED);
            config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.IEEE8021X);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104);
            config.status = WifiConfiguration.Status.ENABLED;
        }
        if (wifiType == 2) {
            config.hiddenSSID = false;
            config.preSharedKey = "\"" + password + "\"";
            config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
            config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
            config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
            config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
            config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
            config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.NONE);
            config.allowedProtocols.set(WifiConfiguration.Protocol.WPA); // For WPA
            config.allowedProtocols.set(WifiConfiguration.Protocol.RSN); // For WPA2
            config.status = WifiConfiguration.Status.ENABLED;
        }
        return config;
    }


    /**
     * 判断当前wifi是否有保存
     *
     * @param model
     */
    private void isConfiged(List<WifiConfiguration> isConfigedList, WifiModel model) {

        for (WifiConfiguration existingConfig : isConfigedList) {
            if (existingConfig.SSID.equals("\"" + model.getWifiName() + "\"")) {
                model.setConfiged(true);
                LogUtils.e("tll", "11111111111111111:" + model.getWifiName() + ":" + model.getConfiged());
            } else {
                model.setConfiged(false);
                LogUtils.e("tll", "22222222222222222:" + model.getWifiName());
            }
        }
    }

    /**
     * 忘记某一个wifi
     *
     * @param targetSsid
     */
    private void removeWifiBySsid(String targetSsid) {
        LogUtils.e("tll", "removeWifiBySsid--targetSsid:" + targetSsid);
        List<WifiConfiguration> wifiConfigs = wifiManager.getConfiguredNetworks();
        for (WifiConfiguration wifiConfig : wifiConfigs) {
            String ssid = wifiConfig.SSID;
            LogUtils.e("tll", "removeWifiBy--wifiConfig--Ssid:" + ssid);
            if (ssid.equals(targetSsid)) {



                boolean removeOk = wifiManager.removeNetwork(wifiConfig.networkId);
                wifiManager.saveConfiguration();
                if (removeOk) {
                    LogUtils.e("tll", "removeWifiBy:" + targetSsid);
                } else {
                    LogUtils.e("tll", "remove  失败！");
                }

            }
        }
    }

    @Override
    public void setWifiManager(WifiManager wifiManager) {
        this.wifiManager = wifiManager;
    }

    @Override
    public void startScnner() {
        getView().startScnner();
    }


    @Override
    public void scnnered(ArrayList<WifiModel> dataList) {
        List<WifiConfiguration> isConfigedList = wifiManager.getConfiguredNetworks();
        //判断当前wifi是否已经保存，已经连接过
        for (WifiModel model : dataList) {
            isConfiged(isConfigedList, model);
        }
        getView().scnnered(dataList);
    }


    @Override
    public void closeWifi() {
        getView().closeWifi();
    }

    @Override
    public void verificationFail() {
        getView().verificationFail();
    }

    @Override
    public void verificationSuceess(WifiInfo wifiInfo) {
        getView().verificationSuceess(wifiInfo);
    }

    @Override
    public void notAvailableWifi() {
        getView().notAvailableWifi();
    }

    @Override
    public void detachView() {
        super.detachView();
        if (wiFiManagerMode != null) {
            wiFiManagerMode.onDestroy();
            wiFiManagerMode = null;
        }
        mContext = null;
    }


}
