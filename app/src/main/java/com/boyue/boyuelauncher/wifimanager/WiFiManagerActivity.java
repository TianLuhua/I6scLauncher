package com.boyue.boyuelauncher.wifimanager;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPActivity;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_WiFiDialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_WiFi_AddNetworkDialog;
import com.boyue.boyuelauncher.wifimanager.adpter.WifiAdapter;
import com.boyue.boyuelauncher.wifimanager.entity.WifiModel;
import com.boyue.boyuelauncher.wifimanager.listener.DataActionListener;
import com.boyue.boyuelauncher.wifimanager.listener.OnItemClickListener;
import com.boyue.boyuelauncher.wifimanager.listener.OnWiFiSettingDialogOnListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianluhua on 2018/6/11.
 */
public class WiFiManagerActivity extends AbstractMVPActivity<WiFiManagerView, WiFiManagerPersenterImp> implements WiFiManagerView, View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    private RecyclerView dataView;
    private TextView manuallyAddNetwork;
    private CheckBox wlanSwitch;
    private ImageView wifiSColseIcon;
    private RelativeLayout wifiStatusGroup;
    private TextView wifiStatusLabel;

    private WifiAdapter dataAdapter;//wifi列表适配器

    @Override
    protected int getContentViewID() {
        return R.layout.activity_wifimanager;
    }

    @Override
    protected void initView() {
        //设置title
        AppCompatImageView backBtn = findViewById(R.id.title_bar).findViewById(R.id.left_icon);
        backBtn.setOnClickListener(this);
        TextView tilte = findViewById(R.id.title_bar).findViewById(R.id.title);
        tilte.setText(R.string.wifi_setting);
        //initView
        wifiSColseIcon = findViewById(R.id.wifi_close_icon);
        wifiStatusGroup = findViewById(R.id.wifi_enable_note);
        wifiStatusLabel = findViewById(R.id.wifi_disable_note);
        manuallyAddNetwork = findViewById(R.id.manually_add_network);
        manuallyAddNetwork.setOnClickListener(this);
        wlanSwitch = findViewById(R.id.wlan_switch);
        wlanSwitch.setOnCheckedChangeListener(this);
        dataView = findViewById(R.id.dataView);
        dataAdapter = new WifiAdapter(getApplicationContext());
        dataView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dataView.setAdapter(dataAdapter);
        //获取系统初始化状态
        getPresenter().initUI();
    }


    @Override
    protected WiFiManagerPersenterImp createPresenter() {
        return new WiFiManagerPersenterImp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().registerReceiver();
    }

    @Override
    protected void onPause() {
        getPresenter().unregisterReceiver();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_icon:
                this.finish();
                break;
            case R.id.manually_add_network:
                final Setting_WiFi_AddNetworkDialog dialog = new Setting_WiFi_AddNetworkDialog();
                dialog.setTitle(R.string.ignore_network);
                dialog.setBtnString(R.string.cancel, R.string.manually_add_network);
                dialog.setCancelable(false);
                dialog.show(getSupportFragmentManager(), "addNetwork");
                dialog.setWiFiSettingDialogOnListener(new OnWiFiSettingDialogOnListener() {
                    @Override
                    public void onLeftClick(View view) {

                    }

                    @Override
                    public void onrightClick(View view) {
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
                updateUI(isChecked);
                break;
        }
    }

    private void updateUI(boolean isChecked) {
        wifiSColseIcon.setVisibility(isChecked ? View.INVISIBLE : View.VISIBLE);
        wifiStatusLabel.setVisibility(isChecked ? View.INVISIBLE : View.VISIBLE);
        wifiStatusGroup.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
        if (wifiStatusLabel.getVisibility() == View.VISIBLE) {
            wifiStatusLabel.setText(R.string.wifi_enable);
        }
    }


    @Override
    public void startScnner() {
        LogUtils.e("tlh", "WiFiManagerActivity  startScnner");
    }

    @Override
    public void scnnered(ArrayList<WifiModel> dataList) {
        LogUtils.e("tlh", "WiFiManagerActivity  scnnered dataList.size():" + dataList.size());
        dataAdapter.setDataList(dataList);
    }

    @Override
    public void currentConnected(WifiInfo wifiInfo) {

    }

    @Override
    public void connectFail() {
        LogUtils.e("tlh", "WiFiManagerActivity  connectFail");
    }

    @Override
    public void closeWifi() {
        dataAdapter.clear();
    }

    @Override
    public void setInitUI(boolean wifiEnable) {
        if (wlanSwitch == null) return;
        wlanSwitch.setChecked(wifiEnable);
    }

}
