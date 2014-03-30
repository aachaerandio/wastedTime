package com.aachaerandio.wastedtime;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private static final Boolean ON = true;
	private static final Boolean OFF = false;
	
	private Boolean flag = OFF;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageButton button = (ImageButton) findViewById(R.id.redButton);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView label =   (TextView) findViewById(R.id.wastedTimeLabel);
				if (flag == OFF){
					flag = ON;
					label.setVisibility(View.VISIBLE);
				}
				else{
					flag = OFF;
					label.setVisibility(View.INVISIBLE);
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
