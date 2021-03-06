package com.boyue.boyuelauncher.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.boyue.boyuelauncher.R;

import java.io.IOException;

import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_AR;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_LY;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_PROTECT_EYE;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_XT;
import static com.boyue.boyuelauncher.Config.HandlerGlod.HHT_ZXBX;
import static com.boyue.boyuelauncher.Config.PassWordKey.HHTLY_AUDIO_KEY;

/**
 * Created by Tianluhua on 2018\7\2 0002.
 */
public class PlayAudioService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        Log.e("tlh", "onCreate");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("tlh", "onHandleIntent");
        stopPlayer();
        switch (intent.getIntExtra(HHTLY_AUDIO_KEY, -1)) {
            case HHT_XT:
                //火火兔学堂
                break;
            //火火兔AR
            case HHT_AR:
                break;
            //火火兔乐园
            case HHT_LY:
                break;
            //在线宝箱
            case HHT_ZXBX:
                try {
                    mediaPlayer.setDataSource(PlayAudioService.this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hht_zxbx));
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            //护眼提示音
            case HHT_PROTECT_EYE:
                try {
                    mediaPlayer.setDataSource(PlayAudioService.this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hht_protext_eye));
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void stopPlayer() {
        if (mediaPlayer == null) return;
        if (mediaPlayer.isPlaying()) {
            Log.e("tlh", "isPlaying");
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.e("tlh", "onPrepared");
        mediaPlayer.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.e("tlh", "onCompletion");
        stopSelf();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("tlh", "onDestroy");
        mediaPlayer.release();
        mediaPlayer = null;
    }

}
