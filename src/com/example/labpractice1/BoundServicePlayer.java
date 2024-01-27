package com.example.labpractice1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class BoundServicePlayer extends Service {
	MediaPlayer mediaPlayer;
	IBinder binder = new MusicBinder();
	
	public class MusicBinder extends Binder{
		
		BoundServicePlayer getBSPlayer(){
			return BoundServicePlayer.this;
		}
	}

	@Override
 	public void onCreate() {
		
		super.onCreate();
		mediaPlayer=MediaPlayer.create(this, R.raw.ante);
		mediaPlayer.setLooping(true);
	}
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		
		return new MusicBinder();
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
