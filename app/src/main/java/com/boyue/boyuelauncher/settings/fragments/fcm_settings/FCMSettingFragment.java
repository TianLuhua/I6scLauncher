package com.boyue.boyuelauncher.settings.fragments.fcm_settings;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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
import com.boyue.boyuelauncher.utils.ToastUtil;
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
        //启用密码
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

        //初始化UI,会回调到方法：setSystmStatus(boolean pwdIsEnable, boolean pwdFcmIsEnable)
        getPresenter().getSystmStatus();
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
    public void onCheckedChanged(CompoundButton buttonView, boolean isEnable) {


        switch (buttonView.getId()) {
            //启用密码
            case R.id.enable_password_switch:
                LogUtils.e("tlh", "fcm--enable_password-->:" + isEnable);

                enAblePassword(isEnable);
                updateUI(isEnable);

                break;
            //防沉迷开关
            case R.id.fcm_switch_switch:
                LogUtils.e("tlh", "fcm--fcm_switch_switch-->:" + isEnable);

                enAbleFCMPassword(isEnable);

                break;

        }

    }

    /**
     * 是否启用fcm密码
     *
     * @param isEnable
     */
    private void enAblePassword(boolean isEnable) {
        getPresenter().enAblePassword(isEnable);


        //显示密码提示框（初始化密码：0000），没什么实际作用
        showFcmEnableNoteDialog(!isEnable);
    }

    /**
     * 系统密码是否启用
     *
     * @param isEnable
     */
    private void enAbleFCMPassword(boolean isEnable) {

        getPresenter().disAbleFcmPassWord(isEnable);
    }


    /**
     * 禁止/开启：修改密码、开机锁屏、定时锁屏等功能
     *
     * @param disAble
     */
    private void updateUI(boolean disAble) {

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
    private void showFcmEnableNoteDialog(boolean show) {
        if (show) return;
        FragmentManager fragmentManager = getFragmentManager();
        //防止出现多个密码框
        if (fragmentManager.findFragmentByTag(Config.DialogGlod.SETTING_ENABLE_FCM_PASSWORD) == null) {
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
            dialog.show(fragmentManager, Config.DialogGlod.SETTING_ENABLE_FCM_PASSWORD);
        }

    }

    //用于保存用户第一次匹配密码是否匹配成功
    public boolean isMatch = false;

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
                        isMatch=false;
                        dialog.dismiss();
                    }

                    @Override
                    public void delete() {
                        LogUtils.e("tlh", "delete");
                    }

                    @Override
                    public void hasInputNumbers(String pwd) {
                        LogUtils.e("tlh", "hasInputNumbers:" + pwd);


                        if (!isMatch) {

                            //拿到用户输入的密码，去和之前存储的密码匹配
                            if (getPresenter().matchingPwd(pwd)) {
                                isMatch = true;
                                //配对ok,提示用户输入新密码
                                dialog.setTieltT(R.string.input_new_pwd, R.color.color_333);
                            } else {
                                //配对失败，提示用户密码输入错误
                                dialog.setTieltT(R.string.input_pwd_error, R.color.color_red);
                            }

                        } else {
                            //需要用户输入两次相同的密码，才能保存
                            if (getPresenter().saveingPwd(pwd)) {

                                StringBuilder builder = new StringBuilder();
                                builder.append(getString(R.string.modify_pwd_ok));
                                builder.append(pwd);
                                ToastUtil.showLongToast(builder.toString());
                                dialog.dismiss();

                            } else {

                                dialog.setTieltT(R.string.input_agin_new_pwd, R.color.color_333);
                                LogUtils.e("tlh","再次输入新密码！");
                            }
                        }


                        dialog.cleanPwdStatus();

                    }
                });
                dialog.show(getFragmentManager(), Config.DialogGlod.SETTING_FCM_CHANGEPASSWORD);
                break;
        }
    }

    @Override
    public void setSystmStatus(boolean pwdIsEnable, boolean pwdFcmIsEnable) {

        fcmSwitchSwitchcheckBox.setChecked(pwdFcmIsEnable);
        enablePwdCheckBox.setChecked(pwdIsEnable);
    }
}
