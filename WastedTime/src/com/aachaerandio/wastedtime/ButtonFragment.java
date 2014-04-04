package com.aachaerandio.wastedtime;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ButtonFragment extends Fragment {

	private static final String ON = "active";
	private static final String OFF = "inactive";	
	private com.aachaerandio.wastedtime.components.Chronometer chrono;
	private String state = OFF;
	Long memoChrono;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_button, container, false);
		// Use the view returned by the fragment to call findViewById
		ImageButton redButton = (ImageButton) rootView.findViewById(R.id.redButton);
		chrono =  (com.aachaerandio.wastedtime.components.Chronometer) rootView.findViewById(R.id.chronometer);
		
		redButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (state == OFF) {
					//chrono.setBase(SystemClock.elapsedRealtime());
					chrono.start();
					state = ON;
				}
				else {
					memoChrono = SystemClock.elapsedRealtime();
					chrono.stop();
					state = OFF;
					//showPopupMenu(v);
				} 
			}
		});
		
		return rootView;
		
	}

	public void showPopupMenu(View v) {
	    PopupMenu popup = new PopupMenu(getActivity(), v);
	    popup.getMenuInflater().inflate(R.menu.popupmenu, popup.getMenu());

		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			   
			   @Override
			   public boolean onMenuItemClick(MenuItem item) {
			    Toast.makeText(getActivity(),
			      item.toString(),
			      Toast.LENGTH_LONG).show();
			    return true;
			   }
			  });
	    popup.show();
	}
	
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
	
}