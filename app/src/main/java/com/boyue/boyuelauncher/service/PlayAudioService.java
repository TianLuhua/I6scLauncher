package com.boyue.boyuelauncher.service;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;

import com.boyue.boyuelauncher.R;
import com.boyue.boyuelauncher.utils.LogUtils;

import java.io.IOException;

import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_AUDIO_KEY;

/**
 * Created by Tianluhua on 2018\7\2 0002.
 */
public class PlayAudioService extends IntentService implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PlayAudioService(String name) {
        super(name);
    }

    public PlayAudioService() {
        super("Audio");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //在线宝箱
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnPreparedListener(this);
        }
        switch (intent.getIntExtra(HHTLY_AUDIO_KEY, -1)) {
            //火火兔学堂
            case 0:
                stopMediaPlay();
                break;
            //火火兔AR
            case 1:
                stopMediaPlay();
                break;
            case 2:
                stopMediaPlay();
                //火火图乐园
                break;
            case 3:
                stopMediaPlay();
                try {
                    LogUtils.e("tlh", "PlayAudioService---onHandleIntent----path:" + "android.resource://" + getPackageName() + "/" + R.raw.hht_zxbx);
                    mediaPlayer.setDataSource("android.resource://" + getPackageName() + "/" + R.raw.hht_zxbx);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;


        }

    }

    private void stopMediaPlay() {
        if (mediaPlayer == null) return;
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer = null;
    }
}
