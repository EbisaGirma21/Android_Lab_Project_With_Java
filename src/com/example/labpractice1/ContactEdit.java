package com.example.labpractice1;


import com.example.labpractice1.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ContactEdit extends Activity implements OnClickListener {
	EditText name,phone, email;
	Button confirm,send;
	Intent intent;
	String username, userPhone,userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout_contact_edit);
        
//        receiving my info from previous contact page
        Intent receivedIntent = getIntent();
        String myName = receivedIntent.getStringExtra("name");
        String myPhone = receivedIntent.getStringExtra("phone");
        String myEmail = receivedIntent.getStringExtra("email");
       
        
        name=(EditText) findViewById(R.id.nameEdit);
        phone=(EditText) findViewById(R.id.phoneEdit);
        email=(EditText) findViewById(R.id.emailEdit);
        
//     setting the received info
        name.setText(myName);
        phone.setText(myPhone);
        email.setText(myEmail);
        
        send=(Button) findViewById(R.id.send);
        confirm=(Button) findViewById(R.id.confirm);
        confirm.setOnClickListener( this);
        send.setOnClickListener( this);
      
        
    }

	@Override
	public void onClick(View v) {
		username=name.getText().toString();
		userPhone=phone.getText().toString();
		userEmail=email.getText().toString();
		if(v.getId()==R.id.confirm){
			if(!(username.isEmpty())&& !(userPhone.isEmpty())&&!(userEmail.isEmpty())){
				Intent sharedata=new Intent();
				sharedata.putExtra("name", username);
				sharedata.putExtra("phone", userPhone);
				sharedata.putExtra("email", userEmail);
				setResult(2023,sharedata);
				finish();
			}else{
				Toast.makeText(getApplicationContext(), "The field is empity", Toast.LENGTH_SHORT).show();

			}
		}
		if(v.getId()==R.id.send){
			 Intent sender = new Intent(Intent.ACTION_SENDTO);
			    sender.setData(Uri.parse("mailto:" + userEmail));
			    sender.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
			    sender.putExtra(Intent.EXTRA_TEXT, username);

			    if (sender.resolveActivity(getPackageManager()) != null) {
			        startActivity(sender);
			    } else {
			    	Toast.makeText(getApplicationContext(), "No email client found", Toast.LENGTH_SHORT).show();
			    }
		}

	}


	
	
    
}
