package com.aachaerandio.wastedtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SaveAndShare extends Activity{
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socialmedia);
        
       TextView text = (TextView) findViewById(R.id.wastedTime);
        
		Intent intent = getIntent();
		//intent.getStringExtra("elapsedTime");
		text.setText(intent.getStringExtra("elapsedTime"));

		
		
	}
	

}
