package com.boyue.boyuelauncher.wifimanager;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_WiFi_AddNetworkDialog;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;
import com.boyue.boyuelauncher.wifimanager.listener.OnWiFiSettingDialogOnListener;

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
        removeWifiBySsid("\"" + data.getWifiName() + "\"");
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
    public void connectWifi(WifiModel data) {
        connectWifi(data.getWifiName(), data.getWifiType());
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
     * 连接Wifi，分为需要密码和不需要密码
     */
    private void connectWifi(final String ssid, final int wifiType) {
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
                final Setting_WiFi_AddNetworkDialog build = new Setting_WiFi_AddNetworkDialog((WiFiManagerActivity) getView(), R.style.Stlye_wifi_settings_dialog);
                final AlertDialog dialog = build.create();
                build.setTitleText(R.string.connect_network);
                build.setBtnString(R.string.cancel, R.string.ok);
                build.setCancelable(false);
                build.setNetName(ssid);
                build.passWordEditorRequstFocuse();
                dialog.show();
                build.setWiFiSettingDialogOnListener(new OnWiFiSettingDialogOnListener() {
                    @Override
                    public void onLeftClick(View view) {
                        dialog.dismiss();

                    }

                    @Override
                    public void onRightClick(View view) {
                        String code = build.getNetPassword();
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
                        dialog.dismiss();
                    }
                });

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
        if (isConfigedList == null)
            return;
        for (WifiConfiguration existingConfig : isConfigedList) {
            //系统保存的WiFi的名字带有引号，所以这里需要在名字首末添加分号，需要用：\" 转义
            if (existingConfig.SSID.equals("\"" + model.getWifiName() + "\"")) {
                model.setConfiged(true);
            } else {
                model.setConfiged(false);
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
                    LogUtils.e("tll", "remove----  成功！:" + targetSsid);
                    //移除成功，通知系统重新扫描
                    wifiManager.startScan();
                } else {
                    LogUtils.e("tll", "remove----  失败！");
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
    public void verificationing(String status) {
        getView().verificationing(status);
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
    public void disconnected() {
        getView().disconnected();

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
