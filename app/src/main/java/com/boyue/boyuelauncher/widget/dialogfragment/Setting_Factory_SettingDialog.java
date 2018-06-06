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

public class Setting_Factory_SettingDialog extends DialogFragment implements View.OnClickListener {

    private Button cancle;
    private TextView recover;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Stlye_wifi_settings_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootVire = inflater.inflate(R.layout.dialog_factory_setting, null, false);
        initView(rootVire);
        return rootVire;
    }

    private void initView(View rootVire) {
        cancle = rootVire.findViewById(R.id.dialog_right);
        recover = rootVire.findViewById(R.id.dialog_left);
        cancle.setOnClickListener(this);
        recover.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (notification == null) return;
        switch (v.getId()) {
            case R.id.dialog_right:
                notification.onRightClick(v);
                break;
            case R.id.dialog_left:
                notification.onLeftClick(v);
                break;
        }

    }

    private Notification notification;

    public void setNotification(Notification notification) {
        this.notification = notification;

    }

    public static interface Notification {

        void onLeftClick(View v);

        void onRightClick(View v);

    }
}
