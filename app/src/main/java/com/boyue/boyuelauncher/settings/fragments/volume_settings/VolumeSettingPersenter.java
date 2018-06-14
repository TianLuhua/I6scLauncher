package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Contacts;
import android.view.View;

import com.boyue.boyuelauncher.base.AbstractPresenter;

public class VolumeSettingPersenter extends AbstractPresenter<VolumeSettingView> {

    private Context mContext;
    private VolumeSettingMode mode;
    private AudioManager audioMa;


    public VolumeSettingPersenter(Context mContext) {
        this.mContext = mContext;
        this.mode = new VolumeSettingMode(mContext, new VolumeSettingMode.CallBack() {
            @Override
            public void setSystMaxVolume(int systMaxVolume, int currentSystVolume, int bootMaxVolume, int currentBootVolume) {
                VolumeSettingView view = getView();
                if (view == null) return;
                view.setSystMaxVolume(systMaxVolume, currentSystVolume,bootMaxVolume,currentBootVolume);
            }


        });
    }

    public void getSystMaxVolume() {
        mode.getSystMaxVolume();
    }


    @Override
    public void detachView() {
        super.detachView();
        if (mode != null) {
            mode.onDestroy();
        }
    }

    public void setSystMaxVolume(int progress) {

        //设置为最大音量

        audioMa = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        audioMa.setStreamVolume(AudioManager.STREAM_MUSIC, progress,AudioManager.FLAG_SHOW_UI);
    }
}
