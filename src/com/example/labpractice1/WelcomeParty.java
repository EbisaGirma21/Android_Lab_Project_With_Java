package com.example.labpractice1;

import com.example.labpractice1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeParty extends Activity implements OnClickListener {
	EditText phoneNumber,passcode;
	Button submit;
	String phone,code;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_party);
        
        phoneNumber=(EditText) findViewById(R.id.phoneNumber);
        passcode=(EditText) findViewById(R.id.passcode);
        
        submit=(Button) findViewById(R.id.submit);
      
      
        submit.setOnClickListener( this);
      
        
    }




	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.submit){
	      Intent  intent   = new Intent(this,PartyGrid.class);
	        
			phone=phoneNumber.getText().toString();
			code=passcode.getText().toString();
			
			if(!(phone.isEmpty())&& !(code.isEmpty())){
				if(code.equalsIgnoreCase("@2023")){
					
					 intent.putExtra("phoneNumber",phoneNumber.getText().toString());
				     startActivity(intent);
	           
				}else{
					Toast.makeText(getApplicationContext(), "Incorrect Passcode", Toast.LENGTH_SHORT).show();
				}
			
			}else{
				Toast.makeText(getApplicationContext(), "Please fill both field", Toast.LENGTH_SHORT).show();
			}
			
		}
		

	}

    
}
