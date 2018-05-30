package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.LogUtils;

public class FCMSettingFragment extends AbstractMVPFragment<FCMSettingView, FCMSettingPersenter> implements FCMSettingView, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox enablePwdCheckBox, fcmSwitchSwitchcheckBox;
    private AppCompatImageView modifyImageIcon;
    private RadioGroup timingLockingGroup;

    public static FCMSettingFragment newInstance() {
        return new FCMSettingFragment();
    }

    public FCMSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_fcm_setting, null, false);
        initView(rootview);

        return rootview;
    }

    private void initView(View rootview) {
        enablePwdCheckBox = rootview.findViewById(R.id.enable_password_switch);
        enablePwdCheckBox.setOnCheckedChangeListener(this);

        modifyImageIcon = rootview.findViewById(R.id.modify_password_switch);
        modifyImageIcon.setOnClickListener(this);

        fcmSwitchSwitchcheckBox = rootview.findViewById(R.id.fcm_switch_switch);
        fcmSwitchSwitchcheckBox.setOnCheckedChangeListener(this);

        timingLockingGroup = rootview.findViewById(R.id.timing_locking_item_group);
        timingLockingGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected FCMSettingPersenter createPresenter() {
        return new FCMSettingPersenter();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //定时锁定
        switch (checkedId) {
            case R.id.timing_locking_item_00:
                LogUtils.e("tlh", "fcm--timing_shutdown_item_00");
                break;
            case R.id.timing_locking_item_01:
                LogUtils.e("tlh", "fcm--timing_shutdown_item_01");
                break;
            case R.id.timing_locking_item_02:
                LogUtils.e("tlh", "fcm--timing_shutdown_item_02");
                break;
            case R.id.timing_locking_item_03:
                LogUtils.e("tlh", "fcm--timing_shutdown_item_03");
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            //启用密码
            case R.id.enable_password_switch:
                LogUtils.e("tlh", "fcm--enable_password-->:" + isChecked);
                break;
            //防沉迷开关
            case R.id.fcm_switch_switch:
                LogUtils.e("tlh", "fcm--fcm_switch_switch-->:" + isChecked);
                break;

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //修改密码
            case R.id.modify_password_switch:
                LogUtils.e("tlh", "fcm--modify_password-->:");
                break;
        }


    }
}
