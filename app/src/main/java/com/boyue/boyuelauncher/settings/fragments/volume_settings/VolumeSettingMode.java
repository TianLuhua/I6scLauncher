package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.content.Context;
import android.media.AudioManager;

import com.boyue.boyuelauncher.base.BaseMode;

public class VolumeSettingMode implements BaseMode {


    private Context mContext;
    private CallBack callBack;

    private AudioManager audioManager;


    public VolumeSettingMode(Context mContext, CallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
    }


    public void getSystMaxVolume() {

        //此处需要和驱动组确认，这里开机用的那条通道
        int systMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentSystVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int bootMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentBootVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (callBack == null) return;
        callBack.setSystMaxVolume(systMaxVolume, currentSystVolume, bootMaxVolume, currentBootVolume);
    }


    @Override
    public void onDestroy() {
        if (mContext != null) mContext = null;
        if (audioManager != null) audioManager = null;
        if (callBack != null) callBack = null;
    }


    public static interface CallBack {

        void setSystMaxVolume(int systMaxVolume, int currentSystVolume, int bootMaxVolume, int currentBootVolume);
    }

}
