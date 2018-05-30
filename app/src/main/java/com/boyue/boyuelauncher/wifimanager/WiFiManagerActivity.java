package com.boyue.boyuelauncher.wifimanager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.KeyboardUtil;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.wifimanager.adpter.WifiAdapter;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;
import com.boyue.boyuelauncher.wifimanager.listener.DataActionListener;
import com.boyue.boyuelauncher.wifimanager.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianluhua on 2018/5/16.
 */
public class WiFiManagerActivity extends AbstractMVPActivity<WiFiManagerView, WiFiManagerPersenterImp> implements WiFiManagerView, View.OnClickListener {

    private boolean isGranted;//是否有权限
    private static final int REQUEST_CODE = 11000;//权限请求code

    private WifiManager wifiManager;//wifi管理器
    private WifiReceiver wifiReceiver;//广播接受器
    private WifiAdapter dataAdapter;//wifi列表适配器

    private List<ScanResult> scanResultList;//扫描wifi列表
    private List<WifiConfiguration> wifiConfigList;//配置好的wifi列表
    private List<WifiModel> dataList;//wifi列表显示


    private AppCompatImageView backBtn;
    private TextView tilte;
    private RecyclerView dataView;

    @Override
    protected int getContentViewID() {
        return R.layout.activity_wifimanager;
    }

    @Override
    protected void initView() {

        backBtn = findViewById(R.id.title_bar).findViewById(R.id.left_icon);
        backBtn.setOnClickListener(this);
        tilte = findViewById(R.id.title_bar).findViewById(R.id.title);
        tilte.setText(R.string.wifi_setting);

        scanResultList = new ArrayList<>();
        wifiConfigList = new ArrayList<>();

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        dataAdapter = new WifiAdapter(WiFiManagerActivity.this, dataList = new ArrayList<>());
        dataView = findViewById(R.id.dataView);
        dataView.setLayoutManager(new LinearLayoutManager(WiFiManagerActivity.this));
        dataView.setAdapter(dataAdapter);
        dataAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                WifiModel data = dataList.get(position);
                if (data.isConnect()) {
                    getCurrentWifi();
                } else {
                    connectWifi(data.getWifiName(), data.getWifiType(), WiFiManagerActivity.this);
                }
            }

            @Override
            public void onItemLongClick(int position) {
            }
        });
        dataAdapter.setDataActionListener(new DataActionListener() {
            @Override
            public void onShow(int position) {
                WifiModel data = dataList.get(position);
                data.setShowDetail(!data.isShowDetail());
                dataAdapter.notifyDataSetChanged();
            }
        });
        checkPermission(WiFiManagerActivity.this);

    }


    @Override
    protected WiFiManagerPersenterImp createPresenter() {
        return new WiFiManagerPersenterImp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        wifiReceiver = new WifiReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);//wifi的打开与关闭
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);//wifi扫描
        intentFilter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);//wifi验证密码
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);//wifi连接成功
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);//wifi信号强度
        registerReceiver(wifiReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        if (wifiReceiver != null) {
            unregisterReceiver(wifiReceiver);
            super.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
            ToastUtil.showShortToast(WiFiManagerActivity.this, "当前未连接wifi");
        }
    }


    /**
     * 连接Wifi
     */
    private void connectWifi(final String ssid, final int wifiType, final Activity activity) {
        int networkId = -1;
        for (WifiConfiguration configuration : wifiConfigList) {
            String configId = configuration.SSID.replaceAll("\"", "");
            if (configId.equals(ssid)) {
                networkId = configuration.networkId;
                break;
            }
        }
        if (networkId != -1) {//已经连接配置过
            wifiManager.disconnect();
            wifiManager.enableNetwork(networkId, true);
            ToastUtil.showShortToast(activity, "启动连接：" + true);
        } else {//新的连接
            if (wifiType != 0) {//需要密码
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("输入密码");
                LayoutInflater factory = LayoutInflater.from(this);
                View view = factory.inflate(R.layout.lay_dialog_input, null);
                final EditText etDialogInput = (EditText) view.findViewById(R.id.etDialogInput);
                builder.setView(view);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String code = etDialogInput.getText().toString();
                        if (TextUtils.isEmpty(code)) {
                            ToastUtil.showShortToast(activity, "请输入密码");
                            return;
                        }
                        WifiConfiguration wifiConfig = createWifiInfo(ssid, code, wifiType);
                        int netId = wifiManager.addNetwork(wifiConfig);
                        if (netId != -1) {
                            wifiManager.saveConfiguration();
                        }
                        boolean flag = wifiManager.enableNetwork(netId, true);
                        ToastUtil.showShortToast(activity, "启动连接：" + flag);
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
                ToastUtil.showShortToast(activity, "启动连接：" + flag);
            }
        }
    }


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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_icon:
                this.finish();
                break;
        }
    }


    /**
     * wifi广播
     */
    class WifiReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!isGranted) {
                return;
            }
            String action = intent.getAction();
            if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
                switch (wifiState) {
                    case WifiManager.WIFI_STATE_DISABLED:
                        ToastUtil.showShortToast(context, "Wifi关闭");
                        break;
                    case WifiManager.WIFI_STATE_ENABLED:
                        wifiManager.startScan();//Wifi打开,启动扫描
                        break;
                }
            } else if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
                loadData();//扫描完成
            } else if (WifiManager.RSSI_CHANGED_ACTION.equals(action)) {
                wifiManager.startScan();//信号强度变化，重新扫描
            } else if (WifiManager.SUPPLICANT_STATE_CHANGED_ACTION.equals(action)) {
                WifiInfo info = wifiManager.getConnectionInfo();
                SupplicantState state = info.getSupplicantState();
                if (state == SupplicantState.COMPLETED) {
                    wifiManager.startScan();//验证成功,启动扫描
                }
                int errorCode = intent.getIntExtra(WifiManager.EXTRA_SUPPLICANT_ERROR, -1);
                if (errorCode == WifiManager.ERROR_AUTHENTICATING) {
                    ToastUtil.showShortToast(context, "验证失败");
                }
            } else if (WifiManager.SUPPLICANT_STATE_CHANGED_ACTION.equals(action)) {
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                if (wifiInfo != null) {
                    String wifiSSID = wifiInfo.getSSID();
                    ToastUtil.showShortToast(context, wifiSSID + "连接成功");
                }

            }
        }
    }

    /**
     * 检查权限
     */
    private void checkPermission(Activity mContext) {
        int perm = ContextCompat.checkSelfPermission(mContext, Config.Permission.LOCATION_PERMISSION);
        if (perm == PackageManager.PERMISSION_GRANTED) {
            isGranted = true;
            openWifi();//打开WIFI
        } else {
            isGranted = false;
            ToastUtil.showLongToast(mContext, "扫描WIFI缺少定位权限，请授予权限");
            ActivityCompat.requestPermissions(mContext,
                    new String[]{Config.Permission.LOCATION_PERMISSION}, REQUEST_CODE);
        }
    }

    /**
     * 打开wifi
     */
    private void openWifi() {
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled()) {
            wifiManager.startScan();//启动扫描
//            dataEmpty.setText("扫描中...");
        } else {
            wifiManager.setWifiEnabled(true);
        }
    }

    /**
     * 获取wifi列表
     */
    private void loadData() {
        scanResultList.clear();
        wifiConfigList.clear();
        scanResultList.addAll(wifiManager.getScanResults());
        wifiConfigList.addAll(wifiManager.getConfiguredNetworks());
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
//            dataEmpty.setVisibility(View.GONE);
            dataView.setVisibility(View.VISIBLE);
            dataAdapter.notifyDataSetChanged();
        } else {
//            dataEmpty.setVisibility(View.VISIBLE);
//            dataEmpty.setText(R.string.data_empty);
            dataView.setVisibility(View.GONE);
        }
    }

}
