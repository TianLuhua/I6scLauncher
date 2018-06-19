package com.boyue.boyuelauncher.widget.dialogfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.wifimanager.listener.OnWiFiSettingDialogOnListener;

public class Setting_WiFi_AddNetworkDialog extends AlertDialog.Builder implements View.OnClickListener {

    private TextView title;
    private Button leftBt;
    private Button rightBt;
    private EditText textName, textPassWord;

    private OnWiFiSettingDialogOnListener onWiFiSettingDialogOnListener;

    public Setting_WiFi_AddNetworkDialog(Context context, int stlye_wifi_settings_dialog) {
        super(context, stlye_wifi_settings_dialog);
        View rootView = LayoutInflater.from(context).inflate(R.layout.dialog_settings_wifi_addnetwork, null);
        setView(rootView);
        initView(rootView);
    }


    private void initView(View rootVire) {
        title = rootVire.findViewById(R.id.dialog_title);
        leftBt = rootVire.findViewById(R.id.dialog_left);
        rightBt = rootVire.findViewById(R.id.dialog_right);
        textName = rootVire.findViewById(R.id.dialog_net_name_editor);
        textPassWord = rootVire.findViewById(R.id.dialog_net_pwd_editor);
        leftBt.setOnClickListener(this);
        rightBt.setOnClickListener(this);
    }

    //设置标题
    public void setTitleText(int titlRes) {
        if (title == null) return;
        title.setText(titlRes);
    }


    //设置wifi的名字
    public void setNetName(String name) {
        textName.setText(name.toCharArray(), 0, name.length());
    }

    //设置两个Button的名字
    public void setBtnString(int leftStringRes, int rightStringRes) {
        if (leftBt == null && rightBt == null) return;
        leftBt.setText(leftStringRes);
        rightBt.setText(rightStringRes);
    }

    //获取wifi的名字
    public String getNetName() {
        return textName.getText().toString();
    }

    //获取passWord
    public String getNetPassword() {
        return textPassWord.getText().toString();
    }

    //密码框请求焦点
    public void passWordEditorRequstFocuse() {
        textPassWord.requestFocus();
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


    public void setWiFiSettingDialogOnListener(OnWiFiSettingDialogOnListener onWiFiSettingDialogOnListener) {
        this.onWiFiSettingDialogOnListener = onWiFiSettingDialogOnListener;
    }


}
