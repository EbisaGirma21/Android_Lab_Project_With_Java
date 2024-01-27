package com.example.labpractice1;

import com.example.labpractice1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Contact extends Activity implements OnClickListener {
	
	Button edit;
	Intent intent;
	String username, phone,email;
	TextView myName,myPhone, myEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_contact_info);
        edit=(Button) findViewById(R.id.edit);
        
        myName=(TextView) findViewById(R.id.myName);
        myPhone=(TextView) findViewById(R.id.myPhone);
        myEmail=(TextView) findViewById(R.id.MyEmail);
        
        edit.setOnClickListener( this);
      
        
    }
	@Override
	public void onClick(View v) {
		
		
		if(v.getId()==R.id.edit){
	        intent   = new Intent(this,ContactEdit.class);
	        intent.putExtra("name",myName.getText().toString());
	        intent.putExtra("phone",myPhone.getText().toString());
	        intent.putExtra("email",myEmail.getText().toString());
        
	        
	        startActivityForResult(intent, 2023);

		}

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==2023){
			username=data.getStringExtra("name");
			phone=data.getStringExtra("phone");
			email=data.getStringExtra("email");	
			
			myName.setText(""+username);
			myPhone.setText(""+phone);
			myEmail.setText(""+email);
			
		}
	}

}
