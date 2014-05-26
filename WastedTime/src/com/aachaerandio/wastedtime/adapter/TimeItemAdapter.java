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

	public TimeItemAdapter(Context context, int resource, List<TimeBean> objects) {
		super(context, resource, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		ViewHolder holder;
		TimeBean item = getItem(position);
		
        if (convertView == null) {
        	LayoutInflater li;
        	li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.rowlayout, parent, false);
            
            holder = new ViewHolder(); 
            holder.id = (TextView)view.findViewById(R.id._id);
            holder.icon = (ImageView)view.findViewById(R.id.icon);
    		holder.time = (TextView)view.findViewById(R.id.time);
    		holder.date = (TextView)view.findViewById(R.id.date);            
            view.setTag(holder);
            
        } else {
            view = convertView;
            // Using ViewHolder is avoided calling findViewById() repeatedly
            holder = (ViewHolder) view.getTag();  
        }
        
        holder.id.setText(String.valueOf(item.getId()));
        holder.icon.setImageResource(item.getIcon().id);
		holder.time.setText(Chronometer.formatShare(item.getElapsedTime()));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		holder.date.setText(df.format(item.getCreated()));
        
        return view;
	}
	
	static class ViewHolder {  
        TextView id;  
        ImageView icon;  
        TextView time;
        TextView date;
    }

}
