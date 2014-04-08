package com.aachaerandio.wastedtime;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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
					
					Intent intent = new Intent(getActivity(), SaveAndShare.class);
					
					intent.putExtra("elapsedTime", String.valueOf(chrono.formatTime(chrono.getElapsedTime())));				
					//intent.putExtra("elapsedTime", chrono.formatShare(chrono.getElapsedTime()));
					
					startActivity(intent);
					
				} 
			}
		});
		
		return rootView;
		
	}

	//No se usa
	public void showPopupMenu(View v) {
	    PopupMenu popup = new PopupMenu(getActivity(), v);
	    popup.getMenuInflater().inflate(R.menu.popupmenu, popup.getMenu());

		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			   
			   @Override
			   public boolean onMenuItemClick(MenuItem item) {
			    Toast.makeText(getActivity(), item.toString(), Toast.LENGTH_LONG).show();
			    return true;
			   }
			  });
	    popup.show();
	}
	
	

}
