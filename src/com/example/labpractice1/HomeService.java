package com.example.labpractice1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class HomeService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            int trackResourceId = intent.getIntExtra("trackResourceId", 0);
            if (trackResourceId != 0) {
                playMusic(trackResourceId);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    private void playMusic(int trackResourceId) {
        mediaPlayer.reset();
        mediaPlayer = MediaPlayer.create(this, trackResourceId);
        mediaPlayer.start();
    }

    public void pauseMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void stopMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }
}
