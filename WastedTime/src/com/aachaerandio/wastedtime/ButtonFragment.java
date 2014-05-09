package com.aachaerandio.wastedtime;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.aachaerandio.wastedtime.components.Chronometer;

public class ButtonFragment extends Fragment {

	private static final String ON = "active";
	private static final String OFF = "inactive";	
	private Chronometer chrono;
	private String state = OFF;
	//private Long memoChrono;
	private Integer icon;
	View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_button, container, false);
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
					//memoChrono = SystemClock.elapsedRealtime();
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
		onButtonClick();
		
		return rootView;
		
	}
	
	private void onButtonClick() {
		
		final ImageButton i2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
		i2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 2;
			}
		});
		final ImageButton i3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
		i3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 3;
			}
		});		
		final ImageButton i4 = (ImageButton) rootView.findViewById(R.id.imageButton4);
		i4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 4;
			}
		});
		final ImageButton i5 = (ImageButton) rootView.findViewById(R.id.imageButton5);
		i5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 5;
			}
		});
		final ImageButton i6 = (ImageButton) rootView.findViewById(R.id.imageButton6);
		i6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 6;
			}
		});
		final ImageButton i7 = (ImageButton) rootView.findViewById(R.id.imageButton7);
		i7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 7;
			}
		});
		final ImageButton i8 = (ImageButton) rootView.findViewById(R.id.imageButton8);
		i8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 8;
			}
		});
		final ImageButton i9 = (ImageButton) rootView.findViewById(R.id.imageButton9);
		i9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 9;
			}
		});
		final ImageButton i10 = (ImageButton) rootView.findViewById(R.id.imageButton10);
		i10.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 10;
			}
		});
		final ImageButton i11 = (ImageButton) rootView.findViewById(R.id.imageButton11);
		i11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 11;
			}
		});
		final ImageButton i12 = (ImageButton) rootView.findViewById(R.id.imageButton12);
		i12.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 12;
			}
		});
		final ImageButton i13 = (ImageButton) rootView.findViewById(R.id.imageButton13);
		i13.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 13;
			}
		});
		final ImageButton i14 = (ImageButton) rootView.findViewById(R.id.imageButton14);
		i14.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 14;
			}
		});
		final ImageButton i15 = (ImageButton) rootView.findViewById(R.id.imageButton15);
		i15.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 15;
			}
		});
		final ImageButton i16 = (ImageButton) rootView.findViewById(R.id.imageButton16);
		i16.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 16;
			}
		});
		
	}

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
