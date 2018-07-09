package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.ProgressBar;

import com.boyue.boyuelauncher.Config;
import com.boyue.boyuelauncher.base.AbstractPresenter;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.SPUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;
import com.boyue.boyuelauncher.utils.Utils;

public class VolumeSettingPersenter extends AbstractPresenter<VolumeSettingView> {

    private Context mContext;
    private VolumeSettingMode mode;
    private AudioManager audioManager;
    private SPUtils spUtils;


    public VolumeSettingPersenter(Context mContext) {
        this.mContext = mContext;
        this.spUtils = SPUtils.getInstance(Config.PassWordKey.SPNMAE);
        this.mode = new VolumeSettingMode(mContext, new VolumeSettingMode.CallBack() {
            @Override
            public void setSystMaxVolume(int systMaxVolume, int currentMaxStreamVolume, int bootMaxVolume, int currentBootMaxVolume) {
                VolumeSettingView view = getView();
                if (view == null) return;
                view.setSystMaxVolume(systMaxVolume, currentMaxStreamVolume, bootMaxVolume, currentBootMaxVolume);
            }


        }, spUtils);
        this.audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
    }

    public void getSystemMaxVolume() {
        mode.getSystemMaxVolume();
    }

    public void setSystemMaxVolume(final int progress) {
        ThreadPoolManager.newInstance().addExecuteTask(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_ACTION);
                intent.putExtra(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_KEY, progress);
                Utils.getApp().sendBroadcast(intent);
                LogUtils.e("tlh", "com.booyue.android.stream.max---Action:" + progress);
            }
        });

        //将用户设置的最大音量保存至sp
        spUtils.put(Config.BoYueAction.BOOYUE_STREAMMAXVOLUME_KEY, progress);


        //如果系统档当前的音量大于用户设置的最大音量，就将当前的音量设置成用户设置的音量值
        if (mode.getSystemCurrentStreamVolume() > progress) {
             setSystemCurrentVolume(progress);
        }
    }

    private void setSystemCurrentVolume(int currentVolume) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
    }


    //保存用户设置的开机音量最大值
    public void setSystemBootMaxVolume(int bootMaxVolume) {

        spUtils.put(Config.BoYueAction.BOOYUE_BOOTMAXVOLUME_KEY, bootMaxVolume);

        //如果系统档当前的开机音量大于用户设置的最大开机音量，就将当前的音量设置成用户设置的音量值
        if (mode.getSystemCurrentBootVolume() > bootMaxVolume) {

        }

    }

    @Override
    public void detachView() {
        super.detachView();
        if (mode != null) {
            mode.onDestroy();
        }
    }
}
