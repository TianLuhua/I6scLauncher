package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.boyue.boyuelauncher.widget.dialogfragment.Setting_text_01_tutton_03_Dialog;

public class ProtectEyeFragment extends AbstractMVPFragment<ProtectEyeView, ProtectEyePersenter> implements ProtectEyeView {

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

    //是否设置了防沉迷密码
    private boolean hasFcmPassWord;

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
    LogUtils.e("tlh","ProtectEyeFragment-------onResume");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setNotfication((Notfication) context);
    }

    private void initView(View rootview) {

        screenBrightnessSeekBar = rootview.findViewById(R.id.max_volume_screen);
        screenBrightnessSeekBar.setMax(Config.Screen.SCREEN_BRIGHTNESS_MAX - Config.Screen.SCREEN_BRIGHTNESS_MIN);
        screenBrightnessSeekBar.setProgress(ScreenUtils.getScreenBrightness() - Config.Screen.SCREEN_BRIGHTNESS_MIN);
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
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "从不");

                        getPresenter().setRegularRestTime();
                        break;

                    case R.id.item_01:
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "20");

                        if ( getPresenter().hasePassWord()) {
                            getPresenter().setRegularRestTime();
                        } else {
                            showRegularRestDialog();
                        }


                        break;
                    case R.id.item_02:
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "40");

                        if (getPresenter().hasePassWord()) {
                            getPresenter().setRegularRestTime();
                        } else {
                            showRegularRestDialog();
                        }
                        break;

                    case R.id.item_03:
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "60");

                        if (getPresenter().hasePassWord()) {
                            getPresenter().setRegularRestTime();
                        } else {
                            showRegularRestDialog();
                        }
                        break;

                    default:
                        break;

                }

            }


        });

    }


    private void showRegularRestDialog() {
        final Setting_RegularRest_NoticeDialog dialog = new Setting_RegularRest_NoticeDialog();
        dialog.setCancelable(false);
        dialog.setOnclickListener(new Setting_text_01_tutton_03_Dialog.OnclickListener() {
            @Override
            public void onLeftClick(View v) {
                dialog.dismiss();
//                regularRestRadioGroup.clearCheck();
//                regularRestRadioGroup.check(R.id.item_00);

            }

            @Override
            public void onMiddleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {
                ToastUtil.showShortToast("马上去开启设置密码！");
                if (notfication == null) return;
                dialog.dismiss();
                notfication.gotoSetFcmPassWord();


            }
        });
        dialog.show(getChildFragmentManager(), Config.DialogGlod.SETTING_REGULARREST_NOTICE);
    }

    @Override
    protected ProtectEyePersenter createPresenter() {
        return new ProtectEyePersenter();
    }


    //用户点击设置Fcm密码时候，自动跳转
    private Notfication notfication;

    public void setNotfication(Notfication notfication) {
        this.notfication = notfication;

    }

    public interface Notfication {

        void gotoSetFcmPassWord();

    }


}
