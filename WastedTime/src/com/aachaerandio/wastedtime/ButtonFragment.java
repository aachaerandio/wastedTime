package com.aachaerandio.wastedtime;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.aachaerandio.wastedtime.components.Chronometer;
import com.aachaerandio.wastedtime.service.TimeBean.WastedTimeIcon;

public class ButtonFragment extends Fragment {

	private static final String ON = "active";
	private static final String OFF = "inactive";	
	private Chronometer chrono;
	private String state = OFF;
	private Integer icon;
	private View rootView;
	private ImageButton redButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_button, container, false);
		// Use the view returned by the fragment to call findViewById
		redButton = (ImageButton) rootView.findViewById(R.id.redButton);
		chrono =  (com.aachaerandio.wastedtime.components.Chronometer) rootView.findViewById(R.id.chronometer);
		
		redButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (state == OFF) {
					chrono.start();
					state = ON;
				}
				else {
					chrono.stop();
					state = OFF;
					
					Intent intent = new Intent(getActivity(), SaveAndShare.class);
					
					intent.putExtra("elapsedTime", chrono.getElapsedTime());					
					intent.putExtra("icon", icon);
					
					startActivityForResult(intent, 1);
				} 
			}
		});
		
		//Select an icon
		//onIconClick();
		//redButton.setImageDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
		//redButton.setImageResource(WastedTimeIcon.valueOf("ICON"+icon).id);
		
		for (WastedTimeIcon icon : WastedTimeIcon.values()){
			ImageButton imageButton = (ImageButton) rootView.findViewById(icon.associatedBackgroundId);
			imageButton.setOnClickListener(mIconListener);
		}
		
		return rootView;
		
	}
	
	private OnClickListener mIconListener = new OnClickListener() {
	    @SuppressWarnings("deprecation")
		public void onClick(View v) {
	    	WastedTimeIcon icon = null;
	    	WastedTimeIcon[] iconList = WastedTimeIcon.values();
	    	for (int i = 0; i < iconList.length && icon == null; i++){
	    		if (iconList[i].associatedBackgroundId == v.getId()){
	    			icon = iconList[i];
	    		}
	    	}
	    	
	    	redButton.setBackgroundDrawable(getResources().getDrawable(icon.id));
	    }
	};
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {

			if (resultCode == MainActivity.RESULT_OK) {
				((MainActivity) getActivity()).goToListFragment();
			}
		}
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		
		chrono.reset();
	}

}
