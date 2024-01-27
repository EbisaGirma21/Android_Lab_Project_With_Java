package com.example.labpractice1;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MyClassGrid extends Activity implements OnItemClickListener{

	 GridView gridview;
	 MyClassAdapter adapter;
	 
	 String[] datasrc;
	     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gridview);
    
        gridview=(GridView)findViewById(R.id.grid);
        datasrc=getResources().getStringArray(R.array.datasrc);
        
        adapter = new MyClassAdapter(this,datasrc);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(this);
   
  
}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		if(position==0){
			Intent  linear_layout   = new Intent(this,LinearLayoutList.class);	
			startActivity(linear_layout);
		}
		if(position==1){
			Toast.makeText(this, "No Number Found", Toast.LENGTH_SHORT).show();
			}
		if(position==2){
			Toast.makeText(this, "No Number Found", Toast.LENGTH_SHORT).show();
		}
		if(position==3){	
			Toast.makeText(this, "No Number Found", Toast.LENGTH_SHORT).show();
		}
		if(position==4){
			Toast.makeText(this, "No Number Found", Toast.LENGTH_SHORT).show();
		}
		if(position==5){
			Toast.makeText(this, "No Number Found", Toast.LENGTH_SHORT).show();
		}		
		if(position==6){
			Toast.makeText(this, "No Number Found", Toast.LENGTH_SHORT).show();
		}	


	}
	
    
}
