package com.example.labpractice1;

import com.example.labpractice1.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class NewsHeadLine extends Activity implements OnClickListener {
	Button readmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_news);
        
        readmore=(Button) findViewById(R.id.readmore);

    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}




	

	}



