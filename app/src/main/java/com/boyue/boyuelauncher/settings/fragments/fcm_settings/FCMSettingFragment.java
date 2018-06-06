package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_FCM_ChangePassWordDialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_Fcm_Enable_NoteDialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_text_01_tutton_03_Dialog;


public class FCMSettingFragment extends AbstractMVPFragment<FCMSettingView, FCMSettingPersenter> implements FCMSettingView, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox enablePwdCheckBox;

    //更改密码
    private TextView modifyPasswordTitle;
    private AppCompatImageView modifyImageIcon;

    //防沉迷开关
    private TextView fcmSwitchTitle;
    private CheckBox fcmSwitchSwitchcheckBox;

    //定时锁定
    private TextView timingLockingTitle;
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
        //更改密码
        enablePwdCheckBox = rootview.findViewById(R.id.enable_password_switch);
        enablePwdCheckBox.setOnCheckedChangeListener(this);

        //防沉迷开关
        modifyPasswordTitle = rootview.findViewById(R.id.modify_password_title);
        modifyImageIcon = rootview.findViewById(R.id.modify_password_switch);
        modifyImageIcon.setOnClickListener(this);

        //防沉迷开关
        fcmSwitchTitle = rootview.findViewById(R.id.fcm_switch_title);
        fcmSwitchSwitchcheckBox = rootview.findViewById(R.id.fcm_switch_switch);
        fcmSwitchSwitchcheckBox.setOnCheckedChangeListener(this);

        //定时锁定
        timingLockingTitle = rootview.findViewById(R.id.timing_locking_title);
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

                enableFcmPassword(isChecked);

                break;
            //防沉迷开关
            case R.id.fcm_switch_switch:
                LogUtils.e("tlh", "fcm--fcm_switch_switch-->:" + isChecked);
                break;

        }

    }

    /**
     * 是否启用fcm密码
     *
     * @param disAble
     */
    private void enableFcmPassword(boolean disAble) {

        if (!disAble) {

            //禁止防沉迷密码生效
            getPresenter().disAbleFcmPassWord();

        } else {

            showFcmEnableNoteDialog();
        }


        disAbleOtherFunction(disAble);
    }

    /**
     * 禁止/开启：修改密码、开机锁屏、定时锁屏等功能
     *
     * @param disAble
     */
    private void disAbleOtherFunction(boolean disAble) {


        Resources resources = getResources();
        int color_333 = resources.getColor(R.color.color_333);
        int color_999 = resources.getColor(R.color.color_999);

        //更改密码
        modifyPasswordTitle.setTextColor(disAble ? color_333 : color_999);
        modifyImageIcon.setImageResource(disAble ? R.mipmap.ic_system_settings_fcm_setting_modify_pwd_switch_enable : R.mipmap.ic_system_settings_fcm_setting_modify_pwd_switch_disable);
        modifyImageIcon.setClickable(disAble);

        //防沉迷开关
        fcmSwitchTitle.setTextColor(disAble ? color_333 : color_999);
        if (fcmSwitchSwitchcheckBox.isChecked())
            fcmSwitchSwitchcheckBox.setChecked(false);
        fcmSwitchSwitchcheckBox.setClickable(disAble);

        //定时锁定
        timingLockingTitle.setTextColor(disAble ? color_333 : color_999);
        timingLockingGroup.clearCheck();
        int childCount = timingLockingGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RadioButton c = (RadioButton) timingLockingGroup.getChildAt(i);
            c.setTextColor(disAble ? color_333 : color_999);
            c.setClickable(disAble);
        }

    }


    /**
     * 显示密码提示框
     */
    private void showFcmEnableNoteDialog() {
        final Setting_Fcm_Enable_NoteDialog dialog = new Setting_Fcm_Enable_NoteDialog();
        dialog.setCancelable(false);
        dialog.setOnclickListener(new Setting_text_01_tutton_03_Dialog.OnclickListener() {
            @Override
            public void onLeftClick(View v) {
                //useless

            }

            @Override
            public void onMiddleClick(View v) {
                dialog.dismiss();

            }

            @Override
            public void onRightClick(View v) {
                //useless

            }
        });
        dialog.show(getFragmentManager(), Config.DialogGlod.SETTING_ENABLE_FCM_PASSWORD);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //修改密码
            case R.id.modify_password_switch:
                LogUtils.e("tlh", "fcm--modify_password-->:");
                final Setting_FCM_ChangePassWordDialog dialog = new Setting_FCM_ChangePassWordDialog();
                dialog.setCancelable(false);
                dialog.setNotfication(new Setting_FCM_ChangePassWordDialog.Notfication() {
                    @Override
                    public void inputNumber(int number) {
                        LogUtils.e("tlh", "inputNumber:" + number);
                    }

                    @Override
                    public void cancel() {
                        LogUtils.e("tlh", "cancel");
                        dialog.dismiss();
                    }

                    @Override
                    public void delete() {
                        LogUtils.e("tlh", "delete");
                    }

                    @Override
                    public void hasInputNumbers(String pwd) {
                        LogUtils.e("tlh", "hasInputNumbers:" + pwd);
                    }
                });
                dialog.show(getFragmentManager(), Config.DialogGlod.SETTING_FCM_CHANGEPASSWORD);
                break;
        }


    }
}
