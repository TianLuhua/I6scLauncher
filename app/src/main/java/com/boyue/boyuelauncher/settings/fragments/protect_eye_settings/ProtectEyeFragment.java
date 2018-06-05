package com.boyue.boyuelauncher.settings.fragments.protect_eye_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ScreenUtils;
import com.boyue.boyuelauncher.utils.ToastUtil;

public class ProtectEyeFragment extends Fragment {

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

    private void initView(View rootview) {

        screenBrightnessSeekBar = rootview.findViewById(R.id.max_volume_screen);
        screenBrightnessSeekBar.setMax(Config.Screen.SCREEN_BRIGHTNESS_MAX - Config.Screen.SCREEN_BRIGHTNESS_MIN);
        screenBrightnessSeekBar.setProgress(ScreenUtils.getScreenBrightness()- Config.Screen.SCREEN_BRIGHTNESS_MIN);
        LogUtils.e("tlh", "ScreenUtils.getScreenBrightness():" + (ScreenUtils.getScreenBrightness()- Config.Screen.SCREEN_BRIGHTNESS_MIN));
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
                ToastUtil.showShortToast(getContext(), "护眼传感器：" + isChecked);

            }
        });


        protectEyeBlueBrightness = rootview.findViewById(R.id.protect_eye_blue).findViewById(R.id.item_title);
        protectEyeBlueBrightness.setText(R.string.protect_eye_blue_light);
        protectEyeBlueBrightnessCheckBox = rootview.findViewById(R.id.protect_eye_blue).findViewById(R.id.item_group);
        protectEyeBlueBrightnessCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //需要驱动组给接口
                ToastUtil.showShortToast(getContext(), "蓝光护眼开关：" + isChecked);

            }
        });


        regularRestRadioGroup = rootview.findViewById(R.id.regular_rest).findViewById(R.id.item_group);

        regularRestRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.item_00:
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "从不");
                        break;
                    case R.id.item_01:
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "20");
                        break;
                    case R.id.item_02:
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "40");
                        break;
                    case R.id.item_03:
                        LogUtils.e("tlh", "regularRestRadioGroup:" + "60");
                        break;
                    default:
                        break;

                }

            }
        });
        regularRestRadioGroup.check(R.id.item_00);
    }
}
