package com.example.labpractice1;

import com.example.labpractice1.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MusicPlayList extends Activity implements OnClickListener {
	
	Button playButton;
	MediaPlayer mediaPlayer;
	MyPlayerService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_music);
        
        mediaPlayer = MediaPlayer.create(this, R.raw.antemalet);
        playButton=(Button) findViewById(R.id.play);
       
    
        playButton.setOnClickListener(this);
     
      
        
    }



	@Override
	public void onClick(View v) {
		String status=playButton.getText().toString();
		if(v.getId()==R.id.play){
			if(status.equalsIgnoreCase("Play")){
				playButton.setText("Stop");
				 Intent service=new Intent(this,MyPlayerService.class);
			     startService(service);
			}else if(status.equalsIgnoreCase("Stop")){
				playButton.setText("Play");
				stopService(new Intent(this,MyPlayerService.class));
			}
	    
		}
//	

	}
	
    
}
