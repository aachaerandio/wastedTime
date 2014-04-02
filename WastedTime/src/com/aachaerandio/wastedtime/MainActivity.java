package com.aachaerandio.wastedtime;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final Boolean ON = true;
	private static final Boolean OFF = false;
	
	private Boolean flag = OFF;
	private com.aachaerandio.wastedtime.components.Chronometer chrono;
	private String state = "inactive";
	Long memoChrono;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageButton redButton = (ImageButton) findViewById(R.id.redButton);
		chrono =  (com.aachaerandio.wastedtime.components.Chronometer) findViewById(R.id.chronometer);
		
		redButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				chrono.setVisibility(TextView.VISIBLE);

				if (state == "inactive") {
					//chrono.setBase(SystemClock.elapsedRealtime());
					chrono.start();
					state = "active";
				}
				else {
					memoChrono = SystemClock.elapsedRealtime();
					chrono.stop();
					state = "inactive";
				} 
			}
		});
		

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
