package com.example.labpractice1;



import org.apache.http.protocol.HTTP;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class MessageSender extends Activity implements OnClickListener {
	
	EditText messagefield;
	Button send;
	
   @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	 setContentView(R.layout.relative_layout_message_sent);
	 
	 messagefield = (EditText) findViewById(R.id.textField);
	 send = (Button) findViewById(R.id.sender);
	 
	 send.setOnClickListener( this);
	
}

@Override
public void onClick(View view) {
	if(view.getId()==R.id.sender){
		   String msg_content = messagefield.getText().toString();	 				  				   
		   Intent sender = new Intent();
		   sender.setAction(Intent.ACTION_SEND);
		   sender.putExtra(Intent.EXTRA_TEXT, msg_content);
		   sender.setType(HTTP.PLAIN_TEXT_TYPE);
		   if(sender.resolveActivity(getPackageManager())!= null){
			   startActivity(sender);
		   }

//		 String Dial = messagefield.getText().toString();	
//		 Intent caller = new Intent();
//		 caller.setAction(Intent.ACTION_CALL);
//		 caller.setData(Uri.parse("tel:"+Dial));
//		 startActivity(caller);
		   }
	
}	
   
   

}