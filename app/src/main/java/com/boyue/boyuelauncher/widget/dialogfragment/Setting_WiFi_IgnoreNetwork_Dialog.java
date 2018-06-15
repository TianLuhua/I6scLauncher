package com.boyue.boyuelauncher.widget.dialogfragment;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.wifimanager.listener.OnWiFiSettingDialogOnListener;

public class Setting_WiFi_IgnoreNetwork_Dialog extends AlertDialog.Builder implements View.OnClickListener {

    private TextView title;
    private TextView content;
    private Button leftBt;
    private Button rightBt;

    private OnWiFiSettingDialogOnListener onWiFiSettingDialogOnListener;

    public Setting_WiFi_IgnoreNetwork_Dialog(Context context, int stlye_wifi_settings_dialog) {
        super(context, stlye_wifi_settings_dialog);
        View rootView = LayoutInflater.from(context).inflate(R.layout.dialog_settings_wifi_ignore_network, null);
        setView(rootView);
        initView(rootView);
    }


    private void initView(View rootVire) {
        title = rootVire.findViewById(R.id.dialog_title);
        content = rootVire.findViewById(R.id.dialog_content);
        leftBt = rootVire.findViewById(R.id.dialog_left);
        rightBt = rootVire.findViewById(R.id.dialog_right);
        leftBt.setOnClickListener(this);
        rightBt.setOnClickListener(this);
    }

    public void setTitleText(int titlRes) {
        if (title == null) return;
        title.setText(titlRes);
    }

    public void setContent(String contentString) {
        if (content == null) return;
        content.setText(contentString);
    }

    public void setBtnString(int leftStringRes, int rightStringRes) {
        if (leftBt == null && rightBt == null) return;
        leftBt.setText(leftStringRes);
        rightBt.setText(rightStringRes);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_left:
                if (onWiFiSettingDialogOnListener == null) return;
                onWiFiSettingDialogOnListener.onLeftClick(v);
                break;

            case R.id.dialog_right:
                if (onWiFiSettingDialogOnListener == null) return;
                onWiFiSettingDialogOnListener.onRightClick(v);
                break;
        }
    }


    public void setOnWiFiSettingDialogOnListener(OnWiFiSettingDialogOnListener onWiFiSettingDialogOnListener) {
        this.onWiFiSettingDialogOnListener = onWiFiSettingDialogOnListener;
    }


}
