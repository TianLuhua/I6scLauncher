package com.boyue.boyuelauncher.widget.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;

public class WiFiSettingDialog extends DialogFragment implements View.OnClickListener {

    private TextView title;
    private TextView content;
    private Button leftBt;
    private Button rightBt;

    private WiFiSettingDialogOnListener wiFiSettingDialogOnListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Stlye_wifi_settings_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootVire = inflater.inflate(R.layout.dialog_settings_wifi, null, false);
        initView(rootVire);
        return rootVire;
    }

    private void initView(View rootVire) {
        title = rootVire.findViewById(R.id.dialog_title);
        content = rootVire.findViewById(R.id.dialog_content);
        leftBt = rootVire.findViewById(R.id.dialog_left);
        rightBt = rootVire.findViewById(R.id.dialog_right);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_left:
                if (wiFiSettingDialogOnListener == null) return;
                wiFiSettingDialogOnListener.onLeftClick(v);
                break;

            case R.id.dialog_right:
                if (wiFiSettingDialogOnListener == null) return;
                wiFiSettingDialogOnListener.onrightClick(v);
                break;
        }
    }


    public void setWiFiSettingDialogOnListener(WiFiSettingDialogOnListener wiFiSettingDialogOnListener) {
        this.wiFiSettingDialogOnListener = wiFiSettingDialogOnListener;
    }

    public interface WiFiSettingDialogOnListener {

        void onLeftClick(View view);

        void onrightClick(View view);
    }
}
