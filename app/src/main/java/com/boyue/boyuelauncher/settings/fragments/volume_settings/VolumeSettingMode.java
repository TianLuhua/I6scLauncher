package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.content.Context;
import android.media.AudioManager;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.BaseMode;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.SystemPropertiesUtils;

import static com.boyue.boyuelauncher.Config.BoYueAction.BOOT_VOLUME;


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


    //当前开机音量的最大值
    public int getSystemBootMaxVolume() {
        return audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }


    //获取用户设置的开机音量最大值
    public int getSystemurrentBootMaxVolume() {
        float volume = Float.valueOf(SystemPropertiesUtils.getString(BOOT_VOLUME, "" + 0.5));
        LogUtils.e("tlh", "VolumeSettingMode---getSystemurrentBootMaxVolume:" + volume);
        return (int) (volume * 15);
    }

    //用户设置的开机音量最大值
    public void setSystemurrentBootMaxVolume(int volume) {
        float temp = (float) volume / 15;
        //保留一位小数
        float i = ((float) (Math.round(temp * 10)) / 10);
        LogUtils.e("tlh", "VolumeSettingMode---setSystemurrentBootMaxVolume:" + volume + "," + i);
        SystemPropertiesUtils.set(BOOT_VOLUME, "" + i);
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
