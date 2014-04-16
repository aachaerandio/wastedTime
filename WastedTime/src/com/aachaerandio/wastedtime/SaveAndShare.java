package com.aachaerandio.wastedtime;

import com.aachaerandio.wastedtime.service.TimeService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SaveAndShare extends Activity {

	private TimeService timeService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		timeService = new TimeService(this);
		
		setContentView(R.layout.socialmedia);

		TextView text = (TextView) findViewById(R.id.wastedTime);

		Intent intent = getIntent();
		// intent.getStringExtra("elapsedTime");
		text.setText(intent.getStringExtra("elapsedTime"));
	}

}
