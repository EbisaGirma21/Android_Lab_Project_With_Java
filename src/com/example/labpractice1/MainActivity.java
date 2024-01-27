package com.example.labpractice1;

import com.example.labpractice1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	EditText pwd,uname;
	Button login,signup;
	TextView forget;
	String password,username;
	Intent intent;
	GridView gridList;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout_login);
        
        uname=(EditText) findViewById(R.id.editText1);
        pwd=(EditText) findViewById(R.id.editText2);
        
        login=(Button) findViewById(R.id.button1);
        forget=(TextView) findViewById(R.id.textView1);
      
        login.setOnClickListener( this);
      
        
    }




	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1){
	        intent   = new Intent(this,MainGridView.class);
	        
			username=uname.getText().toString();
			password=pwd.getText().toString();
			
			if(username.equalsIgnoreCase("android") && password.equalsIgnoreCase("12345")){
            startActivity(intent);
            finish();
//				Toast.makeText(getApplicationContext(), "Successfully Logged in", Toast.LENGTH_SHORT).show();
			
			}else{
				Toast.makeText(getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show();

			}
		}
		if(v.getId()==R.id.textView1){
			Toast.makeText(getApplicationContext(), "Your Password is 12345", Toast.LENGTH_SHORT).show();

		}

	}




	
	
    
}
