package com.boyue.boyuelauncher.settings.fragments.volume_settings;

import com.boyue.boyuelauncher.base.BaseView;

public interface VolumeSettingView extends BaseView {


    void setSystMaxVolume(int systMaxVolume, int currentSystVolume, int bootMaxVolume, int currentBootVolume);

}
