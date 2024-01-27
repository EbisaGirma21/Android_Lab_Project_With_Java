package com.example.labpractice1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyPlayerService extends Service {
	MediaPlayer mediaPlayer;
	

	
	
	@Override
	public void onCreate() {
//		mediaPlayer.setLooping(true);
		super.onCreate();
		mediaPlayer=MediaPlayer.create(this, R.raw.ante);
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		playMusic();
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(mediaPlayer.isPlaying()){
			mediaPlayer.release();
			mediaPlayer=null;
			}
	}
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	public void playMusic() {
		mediaPlayer.start();
	}
	public void pauseMusic(){
		mediaPlayer.pause();
	}
	public void stopMusic() {
		
		if(mediaPlayer.isPlaying()){
			mediaPlayer.stop();
		}
//	
	}

}
