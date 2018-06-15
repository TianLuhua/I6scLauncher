package com.boyue.boyuelauncher.main;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.support.v4.app.Fragment;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.main.fragments.hht_ar_fragment.HHT_AR_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_bx_fragment.HHT_BX_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_ly_fragment.HHT_LY_Fragment;
import com.boyue.boyuelauncher.main.fragments.hht_xt_fragment.HHT_XT_Fragment;
import com.boyue.boyuelauncher.utils.LogUtils;
import com.boyue.boyuelauncher.utils.ThreadPoolManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianluhua on 2018/5/29.
 */
public class MainModeImp implements MainMode {

    private final String TAG = MainModeImp.class.getCanonicalName();

    private CallBack callBack;
    private Context mContext;

    //监听系统音量变化，改变主界面的音量值
    private SettingsContentObserver mSettingsContentObserver;
    private AudioManager audioManager;

    public MainModeImp(Context mContext, CallBack callBack) {
        this.callBack = callBack;
        this.mContext = mContext;
        audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        registerVolumeChangeReceiver();
    }


    @Override
    public void getCurrentVolume() {
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (callBack == null) return;
        callBack.setCurrentVolume(currentVolume);
    }

    @Override
    public void getFragments() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HHT_XT_Fragment.newInstance());
        fragments.add(HHT_AR_Fragment.newInstance());
        fragments.add(HHT_LY_Fragment.newInstance());
        fragments.add(HHT_BX_Fragment.newInstance());
        if (callBack == null) return;
        callBack.setFragments(fragments);
    }


    @Override
    public void onDestroy() {
        LogUtils.e(TAG, "onDestroy!");
        unregisterVolumeChangeReceiver();
    }


    private void registerVolumeChangeReceiver() {
        mSettingsContentObserver = new SettingsContentObserver(mContext, new Handler());
        mContext.getApplicationContext().getContentResolver().registerContentObserver(android.provider.Settings.System.CONTENT_URI, true, mSettingsContentObserver);
    }

    private void unregisterVolumeChangeReceiver() {
        mContext.getApplicationContext().getContentResolver().unregisterContentObserver(mSettingsContentObserver);
    }

    public class SettingsContentObserver extends ContentObserver {
        Context context;

        public SettingsContentObserver(Context c, Handler handler) {
            super(handler);
            context = c;
        }

        @Override
        public boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            if (callBack == null) return;
            callBack.volumeChange(currentVolume);
        }
    }
}
