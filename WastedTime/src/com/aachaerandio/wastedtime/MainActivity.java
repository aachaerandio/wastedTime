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
	private Chronometer chrono;
	private String state = "inactive";
	Long memoChrono;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageButton btnRed = (ImageButton) findViewById(R.id.redButton);
		Button resetButton = (Button) findViewById(R.id.btn_stop);
		chrono = (Chronometer) findViewById(R.id.chronometer);
		
		btnRed.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView label =   (TextView) findViewById(R.id.wastedTimeLabel);
//				if (flag == OFF){
//					flag = ON;
//					label.setVisibility(View.VISIBLE);					
//				}
//				else{
//					flag = OFF;
//					label.setVisibility(View.INVISIBLE);
//				}
				
				if (state == "inactive") {
					chrono.setBase(SystemClock.elapsedRealtime());
					chrono.start();
					state = "active";
					return;
				}
				if (state == "active") {
					memoChrono = SystemClock.elapsedRealtime();
					chrono.stop();
					state = "paused";
					timeElapsed();
					return;
				} else {
					chrono.setBase(chrono.getBase() + SystemClock.elapsedRealtime() - memoChrono);
					chrono.start();
					state = "active";
				}
				
				
			}
		});
		
		resetButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chrono.stop();
				chrono.setBase(SystemClock.elapsedRealtime());
				state = "inactive";				
			}
		});
	}

	private void timeElapsed () {
		long timeElapsed = SystemClock.elapsedRealtime() - chrono.getBase();
		int hours = (int) (timeElapsed / 3600000);
		int minutes = (int) (timeElapsed - hours * 3600000) / 60000;
		int seconds = (int) (timeElapsed - hours * 3600000 - minutes * 60000) / 1000;
		
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
