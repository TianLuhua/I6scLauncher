package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import com.boyue.boyuelauncher.base.BaseView;

public interface VolumeSettingView extends BaseView {


    void setSystMaxVolume(int systMaxVolume,int currentMaxStreamVolume, int bootMaxVolume,int currentBootMaxVolume);

}
