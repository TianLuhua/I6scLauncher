package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.base.AbstractMVPFragment;
import com.boyue.boyuelauncher.utils.LogUtils;

public class VolumeSettingFragment extends AbstractMVPFragment<VolumeSettingView, VolumeSettingPersenter> implements VolumeSettingView {

    //限制最大音量
    private SeekBar maxVolumeSeekBar;
    private TextView maxVolumeLeve;

    //限制开机最大音量
    private SeekBar powerOffMaxVolumeSeekBar;
    private TextView powerOffMaxVolumeLeve;
    private ActivityManager am;


    public static VolumeSettingFragment newInstance() {
        return new VolumeSettingFragment();
    }

    public VolumeSettingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_settings_voleme_setting, null, false);
        initView(rootview);

        return rootview;
    }

    private void initView(View rootview) {
        maxVolumeSeekBar = rootview.findViewById(R.id.max_volume_screen);
        maxVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                LogUtils.e("tlh", "maxVolumeSeekBar:" + progress);
                maxVolumeLeve.setText(String.valueOf(progress));
                getPresenter().setSystMaxVolume(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        maxVolumeLeve = rootview.findViewById(R.id.max_volume_leve);


        powerOffMaxVolumeSeekBar = rootview.findViewById(R.id.power_off_max_volume);
        powerOffMaxVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                LogUtils.e("tlh", "powerOffMaxVolumeSeekBar:" + progress);
                powerOffMaxVolumeLeve.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        powerOffMaxVolumeLeve = rootview.findViewById(R.id.power_off_max_volume_leve);
        getPresenter().getSystMaxVolume();


    }

    @Override
    protected VolumeSettingPersenter createPresenter() {
        return new VolumeSettingPersenter(getActivity().getApplicationContext());
    }


    @Override
    public void setSystMaxVolume(int systMaxVolume, int currentSystVolume, int bootMaxVolume, int currentBootVolume) {
        maxVolumeSeekBar.setMax(systMaxVolume);
        maxVolumeSeekBar.setProgress(currentSystVolume);
        powerOffMaxVolumeSeekBar.setMax(bootMaxVolume);
        powerOffMaxVolumeSeekBar.setProgress(currentBootVolume);
    }
}
