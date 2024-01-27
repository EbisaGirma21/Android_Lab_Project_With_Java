package com.example.labpractice1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;





public class HomeMusicPlayList extends Activity implements OnClickListener, OnItemClickListener {
    ListView listView;
    HomeMusicAdapter adapter;
    TextView song;
    Button play;

    String[] tracksName = {
            "Ante Neh",
            "Yekirbe",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_music);
        
        song=(TextView) findViewById(R.id.current_playing);
        play = (Button) findViewById(R.id.play);
        listView = (ListView) findViewById(R.id.list);
        adapter = new HomeMusicAdapter(this, tracksName);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(this);
        play.setOnClickListener(this);

    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
		String status=play.getText().toString();
    	if(position==0){
    		
    		if(status.equalsIgnoreCase("Play")){
    			play.setText("Stop");
    		}
    		song.setText(tracksName[position]);
    		 Intent service=new Intent(this,HomeService.class);
    		 service.putExtra("trackResourceId", R.raw.ante);
		     startService(service);
    	}
    	if(position==1){
    		if(status.equalsIgnoreCase("Play")){
    			play.setText("Stop");
    		}
    		song.setText(tracksName[position]);
   		 Intent service=new Intent(this,HomeService.class);
   		 service.putExtra("trackResourceId", R.raw.yekirbe);
		     startService(service);
   	}
        
    }

	public void onClick(View v) {
		String status=play.getText().toString();
		if(v.getId()==R.id.play){
			if(status.equalsIgnoreCase("Play")){
				play.setText("Stop");
	    		song.setText(tracksName[0]);
				 Intent service=new Intent(this,HomeService.class);
	    		 service.putExtra("trackResourceId", R.raw.ante);
			     startService(service);
			}else if(status.equalsIgnoreCase("Stop")){
				play.setText("Play");
				stopService(new Intent(this,HomeService.class));
			}
	    
		}

	}

	



  
}
