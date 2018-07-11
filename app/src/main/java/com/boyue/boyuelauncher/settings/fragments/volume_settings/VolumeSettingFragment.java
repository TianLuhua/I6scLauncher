package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
    private SeekBar bootMaxVolumeSeekBar;
    private TextView bootfMaxVolumeLeve;


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
                LogUtils.e("tlh", "maxVolumeSeekBar:" + progress + fromUser);
                maxVolumeLeve.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int volume = seekBar.getProgress();
                getPresenter().setSystemMaxVolume(volume);
                if (getPresenter().getSystemurrentBootMaxVolume() > volume) {
                    bootMaxVolumeSeekBar.setProgress(volume);
                }

            }
        });
        maxVolumeLeve = rootview.findViewById(R.id.max_volume_leve);

        bootMaxVolumeSeekBar = rootview.findViewById(R.id.power_off_max_volume);
        bootMaxVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                LogUtils.e("tlh", "powerOffMaxVolumeSeekBar:" + progress);
                bootfMaxVolumeLeve.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //最大开机音量受到系统最音量的限制
                int systemVoluem = getPresenter().getSystemCurrentMaxStreamVolume();
                if (seekBar.getProgress() > systemVoluem) {
                    seekBar.setProgress(systemVoluem);
                    getPresenter().setSystemBootMaxVolume(systemVoluem);
                } else {
                    getPresenter().setSystemBootMaxVolume(seekBar.getProgress());
                }
            }
        });
        bootfMaxVolumeLeve = rootview.findViewById(R.id.power_off_max_volume_leve);
        getPresenter().getSystemMaxVolume();
    }

    @Override
    protected VolumeSettingPersenter createPresenter() {
        return new VolumeSettingPersenter(getActivity().getApplicationContext());
    }


    @Override
    public void setSystMaxVolume(int systemMaxVolume, int currentMaxStreamVolume, int bootMaxVolume, int currentBootMaxVolume) {


        LogUtils.e("tlh", "systemMaxVolume:" + systemMaxVolume + ",currentMaxStreamVolume:" + currentMaxStreamVolume + ",bootMaxVolume:" + bootMaxVolume + ",currentBootMaxVolume:" + currentBootMaxVolume);
        //系统最大音量相关(系统允许的和用户设定的)
        maxVolumeSeekBar.setMax(systemMaxVolume);
        maxVolumeSeekBar.setProgress(currentMaxStreamVolume);

        //开机最大音量相关(系统允许的和用户设定的)
        bootMaxVolumeSeekBar.setMax(bootMaxVolume);
        bootMaxVolumeSeekBar.setProgress(currentBootMaxVolume);
    }
}
