package com.example.labpractice1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;



public class MainGridView extends Activity implements OnItemClickListener, OnQueryTextListener{

	GridView gridView;
	SearchView itemSearcher;;
	
	ArrayAdapter<String> adapter;
	 String[] datasrc={
			 "PDF Reader",
			 "My Class",
			 "Welcome party",
			 "Caller",
	 };
	
	 List<String> itemOnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gridview);
        
        gridView=(GridView) findViewById(R.id.grid);  // connecting gridView objects
        itemSearcher=(SearchView) findViewById(R.id.search);

//        MyClassAdapter adapter = new MyClassAdapter(this,datasrc);
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_2 ,android.R.id.text1,datasrc);
        
        itemOnAdapter = new ArrayList<String>(Arrays.asList(datasrc));
        
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        itemSearcher.setOnQueryTextListener(this);
    }
    
    @Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
    	
    	if(position==0){
			String filename ="file:///android:assets/S&M ch_1.pdf";
			Uri path = Uri.parse(filename);
			Intent toviewpdf = new Intent();
			toviewpdf.setAction(Intent.ACTION_VIEW);
			toviewpdf.setData(path);
			toviewpdf.setType("application/pdf");
			toviewpdf.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			if(toviewpdf.resolveActivity(getPackageManager())!=null){
			startActivity(toviewpdf);
			}else{Toast.makeText(this, "No apps Found", Toast.LENGTH_SHORT).show();}
			
	
		}
	if(position==1){
Intent my_class = new Intent(this,MyClassGrid.class);
			startActivity(my_class);
		}
	if(position==2){
		Intent party = new Intent(this,WelcomeParty.class);
		startActivity(party);
	}
	if(position==3){
		Toast.makeText(this, "Fourth Item Clicked", Toast.LENGTH_SHORT).show();
	}


    }

	@Override
	public boolean onQueryTextChange(String searchedItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String searchedItem) {
		if(itemOnAdapter.contains(searchedItem)){
			Toast.makeText(this, "Item is exist", Toast.LENGTH_SHORT).show();
			adapter.getFilter().filter(searchedItem);
		}else{
			Toast.makeText(this, "Item does't exist", Toast.LENGTH_SHORT).show();
		}
		
		return false;
	}
    
}
