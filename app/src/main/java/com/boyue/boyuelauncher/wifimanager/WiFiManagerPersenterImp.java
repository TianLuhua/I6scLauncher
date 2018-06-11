package com.boyue.boyuelauncher.wifimanager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.KeyboardUtil;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.WIFIStatusView;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;

import java.util.ArrayList;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class WiFiManagerPersenterImp extends WiFiManagerPersenter implements WiFiManagerModeImp.Callback {

    private Context mContext;
    private WiFiManagerMode wiFiManagerMode;

    private WifiManager wifiManager;
    private boolean isGranted;


    //通过wifiManager.getConfiguredNetworks()能够获取已经配置好的wifi信息


    public WiFiManagerPersenterImp(Context mContext) {
        this.mContext = mContext;
        this.wiFiManagerMode = new WiFiManagerModeImp(mContext, this);
    }


    @Override
    public void igonreNetwork(WifiModel data) {

    }

    @Override
    public void addNetwork() {

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
    public void initUI() {
        boolean wifiEnable = wifiManager.isWifiEnabled();
        WiFiManagerView view = getView();
        if (view == null) return;
        view.setInitUI(wifiEnable);
    }


    @Override
    public void setWifiEnabled(boolean isEnable) {
        wifiManager.setWifiEnabled(isEnable);
        if (isEnable)
            checkPermission();
    }

    //检查权限
    private void checkPermission() {
        int perm = ContextCompat.checkSelfPermission(mContext, Config.Permission.LOCATION_PERMISSION);
        if (perm == PackageManager.PERMISSION_GRANTED) {
            isGranted = true;
            openWifi();//打开WIFI
        } else {
            isGranted = false;
            ToastUtil.showLongToast("扫描WIFI缺少定位权限，请授予权限");
            ActivityCompat.requestPermissions((Activity) mContext,
                    new String[]{Config.Permission.LOCATION_PERMISSION}, Config.Permission.REQUEST_CODE);
        }
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
            ToastUtil.showShortToast("启动连接：" + true);
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
                        ToastUtil.showShortToast("启动连接：" + flag);
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
                ToastUtil.showShortToast("启动连接：" + flag);
            }
        }
    }

    /**
     * 打开wifi
     */
    private void openWifi() {
        if (wiFiManagerMode == null) return;
        wiFiManagerMode.startScnner();
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
     * 获取当前连接wifi信息
     */
    private void getCurrentWifi() {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo != null) {
            StringBuffer sb = new StringBuffer();
            sb.append("\n获取SSID（所连接的WIFI的网络名称）：" + wifiInfo.getSSID());
            sb.append("\n\n获取BSSID属性（所连接的WIFI设备的MAC地址）：" + wifiInfo.getBSSID());
            sb.append("\n\n获取连接的速度：" + wifiInfo.getLinkSpeed());
            sb.append("\n\n获取SSID 是否被隐藏：" + wifiInfo.getHiddenSSID());
            sb.append("\n\n获取IP 地址：" + wifiInfo.getIpAddress());
            sb.append("\n\n获取Mac 地址（手机本身网卡的MAC地址）：" + wifiInfo.getMacAddress());
            sb.append("\n\n获取802.11n 网络的信号：" + wifiInfo.getRssi());
            sb.append("\n\n获取具体客户端状态的信息：" + wifiInfo.getSupplicantState());
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle(wifiInfo.getSSID());
            builder.setMessage(sb.toString());
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.setCancelable(false);
            builder.show();
        } else {
            ToastUtil.showShortToast("当前未连接wifi");
        }
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
        getView().scnnered(dataList);
    }

    @Override
    public void scnnerFail() {
        getView().connectFail();
    }

    @Override
    public void closeWifi() {
        getView().closeWifi();
    }
}
