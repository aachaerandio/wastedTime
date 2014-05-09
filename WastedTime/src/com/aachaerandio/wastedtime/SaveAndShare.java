package com.aachaerandio.wastedtime;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aachaerandio.wastedtime.components.Chronometer;
import com.aachaerandio.wastedtime.service.TimeBean;
import com.aachaerandio.wastedtime.service.TimeBean.WastedTimeIcon;
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
		final Long data = intent.getLongExtra("elapsedTime", 0L);
		final Integer icon = intent.getIntExtra("icon", 0);
		time.setText(Chronometer.formatTime(data));
		final String image = "ICON" + icon;
		saveBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText text = (EditText) findViewById(R.id.editText);
				
				//WastedTimeIcon.valueOf()

				TimeBean timeBean = new TimeBean();
				timeBean.setComment(text.getText().toString());
				timeBean.setIcon(WastedTimeIcon.valueOf(image));
				timeBean.setElapsedTime(data);
				
				timeService.insert(timeBean);		
				
				setResult(RESULT_OK);     
				finish();
			}
		});
	}

}
