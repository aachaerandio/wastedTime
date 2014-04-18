package com.aachaerandio.wastedtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aachaerandio.wastedtime.service.TimeService;

public class SaveAndShare extends Activity {

	private TimeService timeService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		timeService = new TimeService(this);
		
		setContentView(R.layout.socialmedia);

		TextView time = (TextView) findViewById(R.id.wastedTime);
		Button saveBtn = (Button) findViewById(R.id.save);

		Intent intent = getIntent();
		String data = intent.getStringExtra("elapsedTime");
		time.setText(data);
		
		saveBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText text = (EditText) findViewById(R.id.editText);
				timeService.insert(text.toString());				
			}
		});
	}

}
