package com.example.labpractice1;



import java.util.Random;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class PartyGrid extends Activity implements OnItemClickListener{

	 GridView gridview;
	 PartyAdapter adapter;
	 String phoneNumber;
	 
	 String[] datasrc = {
	"1","2","3"	,"4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24",	 
	 };
	     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.party_grid_layout);
    
        gridview=(GridView)findViewById(R.id.grid);
        
        Intent receivedIntent = getIntent();
        phoneNumber = receivedIntent.getStringExtra("phoneNumber");
        
        adapter = new PartyAdapter(this,datasrc);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(this);
   
  
}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// Generate a random number between 0 and 23
//		Random random = new Random();
//		int theNumber = random.nextInt(24); 
		
		if(position==0){
			
			String phone = "tel:"+phoneNumber;

	        Intent caller = new Intent(Intent.ACTION_CALL);
	        caller.setData(Uri.parse(phone));

	        if (caller.resolveActivity(getPackageManager()) != null) {
	            startActivity(caller);
	        } 
		
		}else{
			Toast.makeText(getApplicationContext(), "The card is empity! try another ", Toast.LENGTH_SHORT).show();
		}


	}
	
    
}
