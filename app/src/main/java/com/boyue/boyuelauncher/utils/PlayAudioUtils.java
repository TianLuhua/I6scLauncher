package com.boyue.boyuelauncher.utils;

import android.content.Intent;

import com.boyue.boyuelauncher.service.PlayAudioService;

import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_AUDIO_KEY;

/**
 * Created by Tianluhua on 2018\7\13 0013.
 */
public class PlayAudioUtils {

    /**
     * 播放音频
     *
     * @param flag 标识不同的音频类型
     */
    public static void startPlayAudio(int flag) {
        Intent intent = new Intent(Utils.getApp(), PlayAudioService.class);
        intent.putExtra(HHTLY_AUDIO_KEY, flag);
        Utils.getApp().startService(intent);
    }

}
