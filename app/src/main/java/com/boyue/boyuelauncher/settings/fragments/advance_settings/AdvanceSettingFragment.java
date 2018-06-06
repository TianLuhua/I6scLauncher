package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_Factory_SettingDialog;

public class AdvanceSettingFragment extends AbstractMVPFragment<AdvanceSettingView, AdvanceSettingPersenter> implements AdvanceSettingView, View.OnClickListener {

    //ro.fota.device
    private TextView deviceModelText;
    //ro.build.version.incremental
    private TextView firmwareVersionText;
    private TextView freeCapacityText;
    private RelativeLayout factorySettingSwitch;


    public static AdvanceSettingFragment newInstance() {
        return new AdvanceSettingFragment();
    }

    public AdvanceSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_advance, null, false);

        initView(rootview);

        return rootview;
    }

    private void initView(View rootview) {
        deviceModelText = rootview.findViewById(R.id.device_model_value);
        firmwareVersionText = rootview.findViewById(R.id.firmware_version_value);
        freeCapacityText = rootview.findViewById(R.id.free_capacity_value);
        factorySettingSwitch = rootview.findViewById(R.id.factory_setting);
        factorySettingSwitch.setOnClickListener(this);

        getPresenter().getSystemParameter();
    }

    @Override
    protected AdvanceSettingPersenter createPresenter() {
        return new AdvanceSettingPersenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.factory_setting:
                final Setting_Factory_SettingDialog dialog = new Setting_Factory_SettingDialog();
                dialog.setNotification(new Setting_Factory_SettingDialog.Notification() {
                    @Override
                    public void onLeftClick(View v) {
                        //恢复出厂设置
                        getContext().sendBroadcast(new Intent(
                                "android.intent.action.MASTER_CLEAR"));
                    }

                    @Override
                    public void onRightClick(View v) {
                        dialog.dismiss();

                    }
                });
                dialog.show(getFragmentManager(), Config.DialogGlod.SETTING_FACTORY_SETTING);
                break;
        }

    }

    @Override
    public void setSystemParameter(String capacity, String deviceModle, String firmwareVersion) {
        if (freeCapacityText == null) return;
        freeCapacityText.setText(capacity);
        deviceModelText.setText(deviceModle);
        firmwareVersionText.setText(firmwareVersion);
    }
}
