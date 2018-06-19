package com.boyue.boyuelauncher.wifimanager;

import android.content.DialogInterface;
import android.net.wifi.WifiInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_WiFi_AddNetworkDialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_WiFi_IgnoreNetwork_Dialog;
import com.boyue.boyuelauncher.wifimanager.adpter.WifiAdapter;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;
import com.boyue.boyuelauncher.wifimanager.listener.DataActionListener;
import com.boyue.boyuelauncher.wifimanager.listener.OnItemClickListener;
import com.boyue.boyuelauncher.wifimanager.listener.OnWiFiSettingDialogOnListener;

import java.util.ArrayList;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public class WiFiManagerActivity extends AbstractMVPActivity<WiFiManagerView, WiFiManagerPersenterImp> implements WiFiManagerView, View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    private RecyclerView dataView;
    private TextView manuallyAddNetwork;
    private CheckBox wlanSwitch;
    private ImageView wifiSColseIcon;
    private RelativeLayout wifiStatusGroup;
    private TextView wifiStatussName, wifiStatussStatus, wifiStatussIpaddress, wifiStatussMac;

    private TextView wifiStatusLabel;
    private WifiAdapter dataAdapter;//wifi列表适配器

    @Override
    protected int getContentViewID() {
        return R.layout.activity_wifimanager;
    }

    @Override
    protected void initView() {
        //设置title
        final AppCompatImageView backBtn = findViewById(R.id.title_bar).findViewById(R.id.left_icon);
        backBtn.setOnClickListener(this);
        TextView tilte = findViewById(R.id.title_bar).findViewById(R.id.title);
        tilte.setText(R.string.wifi_setting);
        //initView
        wifiSColseIcon = findViewById(R.id.wifi_close_icon);

        wifiStatusGroup = findViewById(R.id.wifi_enable_note);
        wifiStatussName = findViewById(R.id.wifi_statuss_name);
        wifiStatussStatus = findViewById(R.id.wifi_statuss_status);
        wifiStatussIpaddress = findViewById(R.id.wifi_statuss_ipaddress);
        wifiStatussMac = findViewById(R.id.wifi_statuss_mac);

        wifiStatusLabel = findViewById(R.id.wifi_disable_note);
        manuallyAddNetwork = findViewById(R.id.manually_add_network);
        manuallyAddNetwork.setOnClickListener(this);
        wlanSwitch = findViewById(R.id.wlan_switch);
        wlanSwitch.setOnCheckedChangeListener(this);
        dataView = findViewById(R.id.dataView);
        dataAdapter = new WifiAdapter(getApplicationContext());
        dataAdapter.setDataActionListener(new DataActionListener() {
            @Override
            public void onIgnore(final WifiModel data, final int position) {
//互联网络
                final Setting_WiFi_IgnoreNetwork_Dialog alBuild = new Setting_WiFi_IgnoreNetwork_Dialog(WiFiManagerActivity.this, R.style.Stlye_wifi_settings_dialog);
                StringBuilder builder = new StringBuilder();
                builder.append("     你确定要忽略 \"");
                builder.append(data.getWifiName());
                builder.append("\" 网络？");
                alBuild.setCancelable(false);
                alBuild.setContent(builder.toString());
                final AlertDialog dialog = alBuild.create();
                dialog.show();
                alBuild.setOnWiFiSettingDialogOnListener(new OnWiFiSettingDialogOnListener() {
                    @Override
                    public void onLeftClick(View view) {
                        //点击了忽略网络
                        getPresenter().igonreNetwork(data, position);
                        dialog.dismiss();

                    }

                    @Override
                    public void onRightClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        dataAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(final WifiModel data, int position) {
//手动连接网络
                getPresenter().connectWifi(data);


            }

            @Override
            public void onItemLongClick(int position) {

            }
        });
        dataView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dataView.setAdapter(dataAdapter);
        //获取系统初始化状态
        getPresenter().checkWifiStatus();
    }


    @Override
    protected WiFiManagerPersenterImp createPresenter() {
        //创建Persenter
        return new WiFiManagerPersenterImp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册wifi相关广播
        getPresenter().registerReceiver();
    }

    @Override
    protected void onPause() {
        //取消wifi相关广播
        getPresenter().unregisterReceiver();
        super.onPause();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_icon:
                this.finish();
                break;
            case R.id.manually_add_network:
//手动添加网络
                final Setting_WiFi_AddNetworkDialog build = new Setting_WiFi_AddNetworkDialog(WiFiManagerActivity.this, R.style.Stlye_wifi_settings_dialog);
                final AlertDialog dialog = build.create();
                build.setTitleText(R.string.manually_add_network);
                build.setBtnString(R.string.cancel, R.string.ok);
                build.setCancelable(false);
                dialog.show();
                build.setWiFiSettingDialogOnListener(new OnWiFiSettingDialogOnListener() {
                    @Override
                    public void onLeftClick(View view) {
                        dialog.dismiss();

                    }

                    @Override
                    public void onRightClick(View view) {
                        getPresenter().addNetwork(build.getNetName(), build.getNetPassword(), 2);
                        dialog.dismiss();
                    }
                });

                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.wlan_switch:
                LogUtils.e("tlh", "onCheckedChanged:" + isChecked);
                getPresenter().setWifiEnabled(isChecked);
                break;
        }
    }


    @Override
    public void startScnner() {
        //开始扫描
        if (wifiStatusLabel.getVisibility() == View.INVISIBLE)
            wifiStatusLabel.setVisibility(View.VISIBLE);
        if (wifiStatusGroup.getVisibility() == View.VISIBLE)
            wifiStatusGroup.setVisibility(View.INVISIBLE);
        wifiStatusLabel.setText(R.string.scnnering);
    }

    @Override
    public void scnnered(ArrayList<WifiModel> dataList) {
        //扫描完毕，返回数据
        dataAdapter.setDataList(dataList);

    }

    @Override
    public void notAvailableWifi() {
        //扫描完毕，附近没有可用WIFI
        if (wifiStatusLabel.getVisibility() == View.INVISIBLE)
            wifiStatusLabel.setVisibility(View.VISIBLE);
        if (wifiStatusGroup.getVisibility() == View.VISIBLE)
            wifiStatusGroup.setVisibility(View.INVISIBLE);
        wifiStatusLabel.setText(R.string.not_available_wifi);
    }

    @Override
    public void disconnected() {
        //扫描完毕，附近没有可用WIFI
        if (wifiStatusLabel.getVisibility() == View.INVISIBLE)
            wifiStatusLabel.setVisibility(View.VISIBLE);
        if (wifiStatusGroup.getVisibility() == View.VISIBLE)
            wifiStatusGroup.setVisibility(View.INVISIBLE);
        wifiStatusLabel.setText(R.string.disconnected);
    }

    @Override
    public void closeWifi() {
        LogUtils.e("tlh", "WiFiManagerActivity---closeWifi()");
        //关闭WIFI
        dataAdapter.clear();
        if (wifiStatusLabel.getVisibility() == View.INVISIBLE)
            wifiStatusLabel.setVisibility(View.VISIBLE);
        if (wifiStatusGroup.getVisibility() == View.VISIBLE)
            wifiStatusGroup.setVisibility(View.INVISIBLE);
        wifiStatusLabel.setText(R.string.wifi_enable);
    }

    @Override
    public void getWifiStatus(boolean wifiEnable) {
        if (wlanSwitch == null) return;
        wlanSwitch.setChecked(wifiEnable);
        updateUI(wifiEnable);
    }

    private void updateUI(boolean wifiEnable) {
        wifiSColseIcon.setVisibility(wifiEnable ? View.INVISIBLE : View.VISIBLE);
        wifiStatusLabel.setVisibility(wifiEnable ? View.VISIBLE : View.INVISIBLE);
        wifiStatusGroup.setVisibility(wifiEnable ? View.INVISIBLE : View.VISIBLE);
        wifiStatusLabel.setText(wifiEnable ? R.string.scnnering : R.string.wifi_enable);
    }

    @Override
    public void verificationFail() {
        //连接失败
        if (wifiStatusLabel.getVisibility() == View.INVISIBLE)
            wifiStatusLabel.setVisibility(View.VISIBLE);
        wifiStatusLabel.setText(R.string.verification_fail);
    }

    @Override
    public void verificationing(String status) {
        ToastUtil.showShortToast(status);
        LogUtils.e("tlh", "WiFiManagerActivity---verificationing:" + status);

        if (wifiStatusLabel.getVisibility() == View.INVISIBLE)
            wifiStatusLabel.setVisibility(View.VISIBLE);

        if (wifiStatusGroup.getVisibility() == View.VISIBLE)
            wifiStatusGroup.setVisibility(View.INVISIBLE);
        wifiStatusLabel.setText(status);
    }

    @Override
    public void verificationSuceess(WifiInfo wifiInfo) {
        LogUtils.e("tlh", "verificationSuceess:" + wifiInfo.toString());
        //连接成功
        if (wifiStatusLabel.getVisibility() == View.VISIBLE)
            wifiStatusLabel.setVisibility(View.INVISIBLE);
        if (wifiStatusGroup.getVisibility() == View.INVISIBLE)
            wifiStatusGroup.setVisibility(View.VISIBLE);
        //去掉引号
        wifiStatussName.setText(wifiInfo.getSSID().replaceAll("\"", ""));
        wifiStatussStatus.setText(R.string.connected);
        wifiStatussIpaddress.setText(intToIp(wifiInfo.getIpAddress()));
        wifiStatussMac.setText(wifiInfo.getMacAddress());
    }

    private String intToIp(int i) {
        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "."
                + ((i >> 24) & 0xFF);
    }


}
