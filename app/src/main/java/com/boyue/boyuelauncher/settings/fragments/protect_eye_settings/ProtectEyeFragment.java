package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ScreenUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_RegularRest_NoticeDialog;
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_Text_01_Tutton_03_Dialog;

public class ProtectEyeFragment extends AbstractMVPFragment<ProtectEyeView, ProtectEyePersenter> implements ProtectEyeView, View.OnClickListener {

    //屏幕亮度
    private SeekBar screenBrightnessSeekBar;

    //护眼传感器
    private TextView protectEyeSenserTitle;
    private CheckBox protectEyeSenserCheckBox;

    //防蓝光护眼
    private TextView protectEyeBlueBrightness;
    private CheckBox protectEyeBlueBrightnessCheckBox;

    //定时休息
    private RadioGroup regularRestRadioGroup;
    private RadioButton radioButton_00, radioButton_01, radioButton_02, radioButton_03;
    //保存当前被点击的RadioButton，等待防沉迷界面状态回调：是否开启防沉迷密码，然后设置RadioButton的状态
    private RadioButton cruuentClickRadioButton;


    public static ProtectEyeFragment newInstance() {
        return new ProtectEyeFragment();
    }

    public ProtectEyeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_protect_eye, null, false);

        initView(rootview);

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.e("tlh", "ProtectEyeFragment-------onResume");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setNotfication((Notfication) context);
    }

    private void initView(View rootview) {

        screenBrightnessSeekBar = rootview.findViewById(R.id.max_volume_screen);
        screenBrightnessSeekBar.setMax(Config.Screen.SCREEN_BRIGHTNESS_MAX - Config.Screen.SCREEN_BRIGHTNESS_MIN);
        LogUtils.e("tlh", "ScreenUtils.getScreenBrightness():" + (ScreenUtils.getScreenBrightness() - Config.Screen.SCREEN_BRIGHTNESS_MIN));
        screenBrightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int i = progress + Config.Screen.SCREEN_BRIGHTNESS_MIN;
                ScreenUtils.setScreenBrightness(i);
                LogUtils.e("tlh", "screenBrightness---progress:" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        protectEyeSenserTitle = rootview.findViewById(R.id.protect_eye_senser).findViewById(R.id.item_title);
        protectEyeSenserTitle.setText(R.string.protect_eye_senser);
        protectEyeSenserCheckBox = rootview.findViewById(R.id.protect_eye_senser).findViewById(R.id.item_group);
        protectEyeSenserCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //需要驱动组给接口
                ToastUtil.showShortToast("护眼传感器：" + isChecked);
                getPresenter().sevaProtectSensorStatus(isChecked);

            }
        });


        protectEyeBlueBrightness = rootview.findViewById(R.id.protect_eye_blue).findViewById(R.id.item_title);
        protectEyeBlueBrightness.setText(R.string.protect_eye_blue_light);
        protectEyeBlueBrightnessCheckBox = rootview.findViewById(R.id.protect_eye_blue).findViewById(R.id.item_group);
        protectEyeBlueBrightnessCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //需要驱动组给接口
                ToastUtil.showShortToast("蓝光护眼开关：" + isChecked);
            }
        });


        regularRestRadioGroup = rootview.findViewById(R.id.regular_rest).findViewById(R.id.item_group);

        regularRestRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.item_00:
                        regularRestTimeValue = Config.Settings.VALUE_NEVER;
                        setRegularRestTime(regularRestTimeValue);
                        break;
                    case R.id.item_01:
                        regularRestTimeValue = Config.Settings.VALUE_20M;
                        break;
                    case R.id.item_02:
                        regularRestTimeValue = Config.Settings.VALUE_40M;
                        break;
                    case R.id.item_03:
                        regularRestTimeValue = Config.Settings.VALUE_60M;
                        break;
                }
            }
        });

        radioButton_00 = rootview.findViewById(R.id.item_00);
        radioButton_00.setOnClickListener(this);
        radioButton_01 = rootview.findViewById(R.id.item_01);
        radioButton_01.setOnClickListener(this);
        radioButton_02 = rootview.findViewById(R.id.item_02);
        radioButton_02.setOnClickListener(this);
        radioButton_03 = rootview.findViewById(R.id.item_03);
        radioButton_03.setOnClickListener(this);

        //初始化界面
        getPresenter().initView();

    }

    //定时休息的时间
    private int regularRestTimeValue;

    @Override
    public void onClick(View v) {
        //是否开启密码
        boolean hasOpenPWD = getPresenter().hasePassWord();
        switch (v.getId()) {
            case R.id.item_00:
                regularRestTimeValue = Config.Settings.VALUE_NEVER;
                cruuentClickRadioButton = radioButton_00;

                break;
            case R.id.item_01:
                regularRestTimeValue = Config.Settings.VALUE_20M;
                cruuentClickRadioButton = radioButton_01;
                if (!hasOpenPWD) {
                    showRegularRestDialog();
                } else {
                    setRegularRestTime(regularRestTimeValue);
                }
                break;

            case R.id.item_02:
                regularRestTimeValue = Config.Settings.VALUE_40M;
                cruuentClickRadioButton = radioButton_02;
                if (!hasOpenPWD) {
                    showRegularRestDialog();
                } else {
                    setRegularRestTime(regularRestTimeValue);
                }
                break;

            case R.id.item_03:
                regularRestTimeValue = Config.Settings.VALUE_60M;
                cruuentClickRadioButton = radioButton_03;
                if (!hasOpenPWD) {
                    showRegularRestDialog();
                } else {
                    setRegularRestTime(regularRestTimeValue);
                }
                break;
        }

    }


    @Override
    protected ProtectEyePersenter createPresenter() {
        return new ProtectEyePersenter(getContext());
    }


    //用户点击设置Fcm密码时候，自动跳转回调接口
    private Notfication notfication;

    public void setNotfication(Notfication notfication) {
        this.notfication = notfication;

    }

    //从FCMSettingFragment发来的通知，是否开启了防沉迷密码
    public void hasOpenFcmPassWord(boolean hasOpen) {

        if (cruuentClickRadioButton == null) return;
        LogUtils.e("tlh", "ProtectEyeFragment--hasOpenFcmPassWord:" + hasOpen);
        if (hasOpen) {
            cruuentClickRadioButton.setChecked(true);
        } else {
            regularRestRadioGroup.check(R.id.item_00);
        }

        setRegularRestTime(regularRestTimeValue);

    }

    /**
     * 设置定时休眠的时间
     *
     * @param value
     */
    private void setRegularRestTime(int value) {
        getPresenter().setRegularRestTime(value);
    }

    private void showRegularRestDialog() {
        final Setting_RegularRest_NoticeDialog dialog = new Setting_RegularRest_NoticeDialog();
        dialog.setCancelable(false);
        dialog.setOnclickListener(new Setting_Text_01_Tutton_03_Dialog.OnclickListener() {
            @Override
            public void onLeftClick(View v) {
                //用户点击了取消，默认选到不开启
                regularRestRadioGroup.check(R.id.item_00);
                dialog.dismiss();

            }

            @Override
            public void onMiddleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                ToastUtil.showShortToast("马上去开启设置密码！");
                if (notfication == null) return;
                notfication.gotoSetFcmPassWord();
                dialog.dismiss();
            }
        });
        dialog.show(getChildFragmentManager(), Config.DialogGlod.SETTING_REGULARREST_NOTICE);
    }

    @Override
    public void setInitView(int screenBrightness, boolean isOpenProtectSener, int regularRestTime) {
        screenBrightnessSeekBar.setProgress(screenBrightness);
        protectEyeSenserCheckBox.setChecked(isOpenProtectSener);
        switch (regularRestTime) {
            case Config.Settings.VALUE_NEVER:
                regularRestRadioGroup.check(R.id.item_00);
                break;
            case Config.Settings.VALUE_20M:
                regularRestRadioGroup.check(R.id.item_01);
                break;
            case Config.Settings.VALUE_40M:
                regularRestRadioGroup.check(R.id.item_02);
                break;
            case Config.Settings.VALUE_60M:
                regularRestRadioGroup.check(R.id.item_03);
                break;
        }
    }

    public interface Notfication {

        //通知跳转到防沉迷密码开启界面
        void gotoSetFcmPassWord();

    }


}
