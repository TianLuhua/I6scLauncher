package com.boyue.boyuelauncher.settings.fragments.advance_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.ActivityUtils;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.VerticalImageSpan;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_Factory_SettingDialog;

import static com.boyue.boyuelauncher.Config.BoYueAction.ACTIVITY_SYSTEM_UPDATE;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.FILE_MANGER_LAUNCHER;
import static com.boyue.boyuelauncher.Config.BoYueLauncherResource.FILE_MANGER_PACKAGE;

public class AdvanceSettingFragment extends AbstractMVPFragment<AdvanceSettingView, AdvanceSettingPersenter> implements AdvanceSettingView, View.OnClickListener {

    private TextView deviceModelText;
    private TextView firmwareVersionText;
    private TextView freeCapacityText;
    private RelativeLayout factorySettingSwitch;
    private RelativeLayout fileManager;
    private TextView versionUpdateText;


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
        fileManager = rootview.findViewById(R.id.file_manager);
        fileManager.setOnClickListener(this);
        factorySettingSwitch = rootview.findViewById(R.id.factory_setting);
        factorySettingSwitch.setOnClickListener(this);
        versionUpdateText = rootview.findViewById(R.id.version_update);
        versionUpdateText.setOnClickListener(this);
        getPresenter().getSystemParameter();
    }

    @Override
    protected AdvanceSettingPersenter createPresenter() {
        return new AdvanceSettingPersenter(getActivity().getApplicationContext());
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
                        getPresenter().startFactorySetting();
                    }

                    @Override
                    public void onRightClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show(getFragmentManager(), Config.DialogGlod.SETTING_FACTORY_SETTING);
                break;
            case R.id.file_manager:
                LogUtils.e("tlh", "AdvanceSettingFragment---file_manger");
                ActivityUtils.startApplicationWithComponent(FILE_MANGER_PACKAGE, FILE_MANGER_LAUNCHER);
                break;
            case R.id.version_update:
                //启动固件升级界面
                ActivityUtils.setActivityConfig(ACTIVITY_SYSTEM_UPDATE);
                break;
        }

    }

    @Override
    public void setSystemParameter(String capacity, String deviceModle, String firmwareVersion, boolean hasUpdateVersion) {
        if (freeCapacityText == null) return;
        freeCapacityText.setText(capacity);
        deviceModelText.setText(deviceModle);
        firmwareVersionText.setText(firmwareVersion);

        if (hasUpdateVersion) {
            showVersionUpdateText();
        } else {
            versionUpdateText.setVisibility(View.INVISIBLE);
        }
    }


    //显示有新版本提示
    private void showVersionUpdateText() {
        ImageSpan imgSpan = new VerticalImageSpan(getContext(), R.mipmap.ic_system_settings_advance_update);
        String text = getResources().getString(R.string.firmware_version_update);
        SpannableStringBuilder spannableString = new SpannableStringBuilder(text);
        spannableString.setSpan(imgSpan, text.indexOf('['),
                text.indexOf(']') + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        versionUpdateText.setText(spannableString);
    }
}
