package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.content.Context;
import android.media.AudioManager;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.SPUtils;

import static com.boyue.boyuelauncher.Config.BoYueAction.BOOYUE_BOOTMAXVOLUME_KEY;

public class VolumeSettingMode implements BaseMode {


    private Context mContext;
    private CallBack callBack;

    private AudioManager audioManager;
    private SPUtils spUtils;


    public VolumeSettingMode(Context mContext, CallBack callBack, SPUtils spUtils) {
        this.mContext = mContext;
        this.callBack = callBack;
        this.audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        this.spUtils = spUtils;
    }


    public void getSystemMaxVolume() {

        //此处需要和驱动组确认，这里开机用的那条通道
        if (callBack == null) return;
        callBack.setSystMaxVolume(getSystStreamMaxVolume(), getSystemCurrentMaxStreamVolume(), getSystemBootMaxVolume(), getSystemurrentBootMaxVolume());
    }

    //系统默认的最大值
    public int getSystStreamMaxVolume() {
        return audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }

    //用户设定的最大值
    public int getSystemCurrentMaxStreamVolume() {
        return spUtils.getInt(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_KEY);
    }

    //系统当前的音量值
    public int getSystemCurrentStreamVolume() {
        return audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    //系统设置的开机音量最大值
    public int getSystemBootMaxVolume() {
        return audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }


    //用户设置的开机音量最大值
    public int getSystemurrentBootMaxVolume() {
        return spUtils.getInt(BOOYUE_BOOTMAXVOLUME_KEY);
    }

    //当前开机音量的最大值
    public int getSystemCurrentBootVolume() {
        return audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onDestroy() {
        if (mContext != null) mContext = null;
        if (audioManager != null) audioManager = null;
        if (callBack != null) callBack = null;
    }


    public static interface CallBack {

        void setSystMaxVolume(int systMaxVolume, int currentMaxStreamVolume, int bootMaxVolume, int currentBootMaxVolume);
    }

}
