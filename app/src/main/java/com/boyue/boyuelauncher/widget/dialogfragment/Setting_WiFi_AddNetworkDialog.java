package com.boyue.boyuelauncher.widget.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.wifimanager.listener.OnWiFiSettingDialogOnListener;

public class Setting_WiFi_AddNetworkDialog extends DialogFragment implements View.OnClickListener {

    private TextView title;
    private TextView content;
    private Button leftBt;
    private Button rightBt;
    private EditText textName, textPassWord;

    private OnWiFiSettingDialogOnListener onWiFiSettingDialogOnListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Stlye_wifi_settings_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootVire = inflater.inflate(R.layout.dialog_settings_wifi_addnetwork, null, false);
        initView(rootVire);
        return rootVire;
    }


    private void initView(View rootVire) {

        title = rootVire.findViewById(R.id.dialog_title);
        content = rootVire.findViewById(R.id.dialog_content);
        leftBt = rootVire.findViewById(R.id.dialog_left);
        rightBt = rootVire.findViewById(R.id.dialog_right);
        textName = rootVire.findViewById(R.id.dialog_net_name_editor);
        textPassWord = rootVire.findViewById(R.id.dialog_net_pwd_editor);
        leftBt.setOnClickListener(this);
        rightBt.setOnClickListener(this);
    }

    public void setTitle(int titlRes) {
        if (title == null) return;
        title.setText(titlRes);
    }

    public void setContent(String contentString) {
        LogUtils.e("tlh", "1111111111111setContent:" + contentString);
        if (content == null) return;
        LogUtils.e("tlh", "2222222222222setContent:" + contentString);
        content.setText(contentString);
    }

    public void setBtnString(int leftStringRes, int rightStringRes) {
        if (leftBt == null && rightBt == null) return;
        leftBt.setText(leftStringRes);
        rightBt.setText(rightStringRes);
    }

    public String getNetName() {
        return textName.getText().toString();
    }

    public String getNetPassword() {
        return textPassWord.getText().toString();
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
