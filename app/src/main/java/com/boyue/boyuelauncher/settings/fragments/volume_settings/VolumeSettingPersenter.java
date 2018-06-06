package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import android.content.Context;
import android.view.View;

import com.boyue.boyuelauncher.base.AbstractPresenter;

public class VolumeSettingPersenter extends AbstractPresenter<VolumeSettingView> {

    private Context mContext;
    private VolumeSettingMode mode;


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
}
