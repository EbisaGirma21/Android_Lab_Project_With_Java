package com.example.labpractice1;

import com.example.labpractice1.R;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BSMusicPlayer extends Activity implements OnClickListener {
	
		Button playButton;
		BoundServicePlayer bservice;
		boolean bind_service_status= false;
		
		ServiceConnection connector=new ServiceConnection(){

			@Override
			public void onServiceConnected(ComponentName arg0, IBinder service) {
				BoundServicePlayer.MusicBinder binder=(BoundServicePlayer.MusicBinder)service;
				bservice=binder.getBSPlayer();
				bind_service_status=true;
				
			}


			@Override
			public void onServiceDisconnected(ComponentName arg0) {
				// TODO Auto-generated method stub
				bind_service_status=false;
				bservice=null;
			}
			
		};

		@Override
	protected void onResume() {
			super.onResume();
		 Intent service=new Intent(this,BoundServicePlayer.class);
		    bindService(service,connector,Context.BIND_AUTO_CREATE);
	};	
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_music);
        playButton=(Button) findViewById(R.id.play);
        playButton.setOnClickListener(this);
     
        
    }

	@Override
	public void onClick(View v) {
		String status=playButton.getText().toString();
		if(v.getId()==R.id.play){
			if(status.equalsIgnoreCase("Play")){
				playButton.setText("Stop");
				if(bind_service_status){
					bservice.playMusic();
				}
				
			}else if(status.equalsIgnoreCase("Stop")){
				playButton.setText("Play");
				
					stopService(new Intent(this,BoundServicePlayer.class));
					
			}
	    
		}

	}




    
}
