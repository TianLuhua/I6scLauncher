package com.boyue.boyuelauncher.wifimanager;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
 * Created by Tianluhua on 2018/5/16.
 */
public class WiFiManagerActivity extends AbstractMVPActivity<WiFiManagerView, WiFiManagerPersenterImp> implements WiFiManagerView, View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    private RecyclerView dataView;
    private TextView manuallyAddNetwork;
    private CheckBox wlanSwitch;

    private ArrayList<WifiModel> dataList=new ArrayList<>();
    private WifiAdapter dataAdapter;//wifi列表适配器

    @Override
    protected int getContentViewID() {
        return R.layout.activity_wifimanager;
    }

    @Override
    protected void initView() {

        AppCompatImageView backBtn = findViewById(R.id.title_bar).findViewById(R.id.left_icon);
        backBtn.setOnClickListener(this);
        TextView tilte = findViewById(R.id.title_bar).findViewById(R.id.title);
        tilte.setText(R.string.wifi_setting);

        manuallyAddNetwork = findViewById(R.id.manually_add_network);
        manuallyAddNetwork.setOnClickListener(this);
        wlanSwitch = findViewById(R.id.wlan_switch);
        wlanSwitch.setOnCheckedChangeListener(this);

        dataView = findViewById(R.id.dataView);
        dataAdapter = new WifiAdapter(WiFiManagerActivity.this, dataList);
        dataView.setLayoutManager(new LinearLayoutManager(WiFiManagerActivity.this));
        dataView.setAdapter(dataAdapter);



//        dataAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                WifiModel data = dataList.get(position);
//                if (data.isConnect()) {
//                    //获取当前连接wifi信息
//                } else {
//                    //connectWifi(data.getWifiName(), data.getWifiType(), WiFiManagerActivity.this);
//                    //连接当前wifi
//                }
//                LogUtils.e("tlh", "H:" + dataView.getHeight() + ",dataView.getWidth():" + dataView.getWidth());
//            }
//
//            @Override
//            public void onItemLongClick(int position) {
//            }
//        });
//        dataAdapter.setDataActionListener(new DataActionListener() {
//            @Override
//            public void onShow(int position) {
//                WifiModel data = dataList.get(position);
//                data.setShowDetail(!data.isShowDetail());
//                dataAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onIgnore(int position) {
//                final WifiModel data = dataList.get(position);
//                final Setting_WiFiDialog dialog = new Setting_WiFiDialog();
//                dialog.setTitle(R.string.ignore_network);
//                dialog.setContent(data.getWifiName());
//                dialog.setBtnString(R.string.cancel, R.string.ignore);
//                dialog.setCancelable(false);
//                dialog.setOnWiFiSettingDialogOnListener(new OnWiFiSettingDialogOnListener() {
//                    @Override
//                    public void onLeftClick(View view) {
//                        getPresenter().igonreNetwork(data);
//                    }
//
//                    @Override
//                    public void onrightClick(View view) {
//                        dialog.dismiss();
//
//                    }
//                });
//
//                dialog.show(getSupportFragmentManager(), "igonre");
//            }
//        });
        getPresenter().checkPermission();

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
                getPresenter().setWifiEnabled();
                break;
        }
    }

    @Override
    public void wifiDisable(boolean disAble) {

    }

    @Override
    public void scnnering() {

    }

    @Override
    public void scnnered(ArrayList<WifiModel> dataList) {
        LogUtils.e("tll","scnnered:"+dataList.size());
        this.dataList = dataList;
        dataAdapter.notifyDataSetChanged();



    }

    @Override
    public void currentConnected(WifiInfo wifiInfo) {

    }

    @Override
    public void connectFail() {

    }

}
