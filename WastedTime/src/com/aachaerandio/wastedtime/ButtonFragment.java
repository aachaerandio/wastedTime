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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

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
		
		final ImageButton i1 = (ImageButton) rootView.findViewById(R.id.imageButton1);
		final ImageButton i2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
		final ImageButton i3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
		final ImageButton i4 = (ImageButton) rootView.findViewById(R.id.imageButton4);
		final ImageButton i5 = (ImageButton) rootView.findViewById(R.id.imageButton5);
		final ImageButton i6 = (ImageButton) rootView.findViewById(R.id.imageButton6);
		final ImageButton i7 = (ImageButton) rootView.findViewById(R.id.imageButton7);
		final ImageButton i8 = (ImageButton) rootView.findViewById(R.id.imageButton8);
		final ImageButton i9 = (ImageButton) rootView.findViewById(R.id.imageButton9);
		final ImageButton i10 = (ImageButton) rootView.findViewById(R.id.imageButton10);
		final ImageButton i11 = (ImageButton) rootView.findViewById(R.id.imageButton11);
		final ImageButton i12 = (ImageButton) rootView.findViewById(R.id.imageButton12);
		final ImageButton i13 = (ImageButton) rootView.findViewById(R.id.imageButton13);
		final ImageButton i14 = (ImageButton) rootView.findViewById(R.id.imageButton14);
		final ImageButton i15 = (ImageButton) rootView.findViewById(R.id.imageButton15);
		final ImageButton i16 = (ImageButton) rootView.findViewById(R.id.imageButton16);
		
		i1.setOnClickListener(mIconListener);
		i2.setOnClickListener(mIconListener);
		i3.setOnClickListener(mIconListener);
		i4.setOnClickListener(mIconListener);
		i5.setOnClickListener(mIconListener);
		i6.setOnClickListener(mIconListener);
		i7.setOnClickListener(mIconListener);
		i8.setOnClickListener(mIconListener);
		i9.setOnClickListener(mIconListener);
		i10.setOnClickListener(mIconListener);
		i11.setOnClickListener(mIconListener);
		i12.setOnClickListener(mIconListener);
		i13.setOnClickListener(mIconListener);
		i14.setOnClickListener(mIconListener);
		i15.setOnClickListener(mIconListener);
		i16.setOnClickListener(mIconListener);
		
		return rootView;
		
	}
	
	private OnClickListener mIconListener = new OnClickListener() {
	    public void onClick(View v) {
	    	switch(v.getId()) {
	        case R.id.imageButton1:
	        	icon = 1;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
		          break;
	        case R.id.imageButton2:
				icon = 2;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton3:
	        	icon = 3;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton4:
	        	icon = 4;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton5:
	        	icon = 5;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton6:
	        	icon = 6;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton7:
	        	icon = 7;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton8:
	        	icon = 8;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton9:
	        	icon = 9;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton10:
	        	icon = 10;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton11:
	        	icon = 11;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton12:
	        	icon = 12;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton13:
	        	icon = 13;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton14:
	        	icon = 14;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton15:
	        	icon = 15;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	        case R.id.imageButton16:
	        	icon = 16;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
	          break;
	      }
	    }
	};
	
	
/*	private void onIconClick() {
		
		final ImageButton i2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
		i2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 2;
				//redButton.setImageDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
			}
		});
		final ImageButton i3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
		i3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				icon = 3;
				redButton.setBackgroundDrawable(getResources().getDrawable(WastedTimeIcon.valueOf("ICON"+icon).id));
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
		
	}*/

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
