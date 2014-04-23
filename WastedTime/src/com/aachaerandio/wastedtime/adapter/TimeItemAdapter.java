package com.aachaerandio.wastedtime.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import com.aachaerandio.wastedtime.R;
import com.aachaerandio.wastedtime.components.Chronometer;
import com.aachaerandio.wastedtime.service.TimeBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeItemAdapter extends ArrayAdapter<TimeBean>{
	
	//private final LayoutInflater li;

	public TimeItemAdapter(Context context, int resource, List<TimeBean> objects) {
		super(context, resource, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		
		TimeBean item = getItem(position);
		
        if (convertView == null) {
        	LayoutInflater li;
        	li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.rowlayout, parent, false);
        } else {
            view = convertView;
        }
        
        ((TextView)view.findViewById(R.id._id)).setText(String.valueOf(item.getId()));
        
        ImageView imageView = (ImageView)view.findViewById(R.id.icon);
        imageView.setImageResource(item.getIcon().id);
        

		 ((TextView)view.findViewById(R.id.time)).setText(Chronometer.formatTime(item.getElapsedTime()));
		 
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		 ((TextView)view.findViewById(R.id.date)).setText(df.format(item.getCreated()));
        
        return view;
	}

}
