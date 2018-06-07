package com.boyue.boyuelauncher.wifimanager.entity;

/**
 * Wifi实体类
 * Created by tianluhua on 2018/5/11.
 */
public class WifiModel {
    private String wifiName;//ssid
    private String wifiDetail;//detail
    private int intensity;//信号强度
    private int wifiType;//wifi加密方式 0:none  1:wep  2:wpa
    private boolean showDetail;//是否显示详细
    private boolean isConnect;//是否连接

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getWifiDetail() {
        return wifiDetail;
    }

    public void setWifiDetail(String wifiDetail) {
        this.wifiDetail = wifiDetail;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public boolean isShowDetail() {
        return showDetail;
    }

    public void setShowDetail(boolean showDetail) {
        this.showDetail = showDetail;
    }

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }

    public int getWifiType() {
        return wifiType;
    }

    public void setWifiType(int wifiType) {
        this.wifiType = wifiType;
    }

    @Override
    public String toString() {
        return "WifiModel{" +
                "wifiName='" + wifiName + '\'' +
                ", wifiDetail='" + wifiDetail + '\'' +
                ", intensity=" + intensity +
                ", wifiType=" + wifiType +
                ", showDetail=" + showDetail +
                ", isConnect=" + isConnect +
                '}';
    }
}
