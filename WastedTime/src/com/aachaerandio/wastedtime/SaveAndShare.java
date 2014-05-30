package com.aachaerandio.wastedtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aachaerandio.wastedtime.components.Chronometer;
import com.aachaerandio.wastedtime.service.TimeBean;
import com.aachaerandio.wastedtime.service.TimeBean.WastedTimeIcon;
import com.aachaerandio.wastedtime.service.TimeService;
import com.aachaerandio.wastedtime.util.Constants;

public class SaveAndShare extends Activity {

	private TimeService timeService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.socialmedia);

		timeService = new TimeService(this);

		final TextView time = (TextView) findViewById(R.id.wastedTime);
		Button saveBtn = (Button) findViewById(R.id.save);
		final EditText text = (EditText) findViewById(R.id.editText);

		Intent intent = getIntent();
		final Long data = intent.getLongExtra(Constants.ELAPSED_TIME, 0L);
		final Integer icon = intent.getIntExtra(Constants.ICON, 0);
		time.setText(Chronometer.formatShare(data));
		// final String image = "ICON" + icon;
		saveBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//EditText text = (EditText) findViewById(R.id.editText);

				// WastedTimeIcon.valueOf()

				TimeBean timeBean = new TimeBean();
				timeBean.setComment(text.getText().toString());
				timeBean.setIcon(WastedTimeIcon.values()[icon]);
				timeBean.setElapsedTime(data);

				timeService.insert(timeBean);

				setResult(RESULT_OK);
				finish();
			}
		});

		// Prueba twitter
		ImageButton smt = (ImageButton) findViewById(R.id.socialmedia1);
		smt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent tweetIntent = new Intent(Intent.ACTION_SEND);
				String shareText = time.getText().toString() +" wasted "+ text.getText().toString();
				shareText += " #wastedTimeApp"; 
				tweetIntent.putExtra(Intent.EXTRA_TEXT, shareText);
				tweetIntent.setType("text/plain");
				startActivity(Intent.createChooser(tweetIntent, "Choose"));
			}
		});

/*		LinearLayout linearbar = (LinearLayout) findViewById(R.id.linearbar);
		// Create SocialAuthAdapter object
		// Add Bar to library
		adapter = new SocialAuthAdapter(new ResponseListener());
		// Add providers to object
		adapter.addProvider(Provider.FACEBOOK, R.drawable.facebook);
		adapter.addProvider(Provider.TWITTER, R.drawable.twitter);

		// For twitter use add callback method. Put your own callback url here.
		// adapter.addCallBack(Provider.TWITTER, "http://socialauth.in/");
		adapter.enable(linearbar);
*/
	}

}
/*
private final class ResponseListener implements DialogListener {
	public void onComplete(Bundle values) {

		editText = (EditText) findViewById(R.id.editText);
		adapter.updateStatus(editText.getText().toString(),
				new MessageListener(), false);
	}

	public void onError(DialogError error) {
		Log.d("ShareBar", "Error");
	}

	public void onCancel() {
		Log.d("ShareBar", "Cancelled");
	}

}
*/