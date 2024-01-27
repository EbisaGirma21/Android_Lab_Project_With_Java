package com.example.labpractice1;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class LinearLayoutList extends Activity implements OnItemClickListener{

	 GridView gridview;
	 LinearLayoutAdapter adapter;
	 
	 String[] datasrc={
			 "Contact information",
			 "Send Message",
			 "Music Play List",
			 "Homework Play List",
			 "Caller",
			 "NewsBeat",
	 };
	     
	     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gridview);
    
        gridview=(GridView)findViewById(R.id.grid);
        adapter = new LinearLayoutAdapter(this,datasrc);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(this);
   
  
}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		if(position==0){
			Intent  contactInfo   = new Intent(this,Contact.class);	
			startActivity(contactInfo);
		}
	if(position==1){
		Intent message_sender = new Intent(this,MessageSender.class);
		startActivity(message_sender);
		}
	if(position==2){
		Intent music_player = new Intent(this,BSMusicPlayer.class);
		startActivity(music_player);
	}
	if(position==3){
			
		Intent music_player = new Intent(this,HomeMusicPlayList.class);
		startActivity(music_player);
	}	
	if(position==4){
	 			
		String phoneNumber = "tel:*805*5674342093567#";

        Intent caller = new Intent(Intent.ACTION_CALL);
        caller.setData(Uri.parse(phoneNumber));

        if (caller.resolveActivity(getPackageManager()) != null) {
            startActivity(caller);
        } 
	}				


	}
	
    
}
