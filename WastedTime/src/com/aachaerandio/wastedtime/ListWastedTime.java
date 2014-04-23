package com.aachaerandio.wastedtime;

import java.util.ArrayList;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.aachaerandio.wastedtime.adapter.TimeItemAdapter;
import com.aachaerandio.wastedtime.service.DatabaseOpenHelper;
import com.aachaerandio.wastedtime.service.TimeBean;
import com.aachaerandio.wastedtime.service.TimeService;

public class ListWastedTime extends ListFragment {

	private SimpleCursorAdapter mAdapter;
	private TimeService timeService;
	private Cursor c;
	private ArrayList<TimeBean> timeBeans;
	private TimeItemAdapter aa;

	public ListWastedTime() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_listwasted, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		timeService = new TimeService(this.getActivity());

		// Create a cursor
		readData();

		setListAdapter(aa);
	}

	private void readData() {
		timeBeans = timeService.read();
		
		if (aa == null){
			//custom adapter:
			//array adapter to bind the array to the listview
			aa = new TimeItemAdapter(getActivity(), R.layout.rowlayout, timeBeans);
		}
		else{
			aa.clear();
			aa.addAll(timeBeans);
		}
		
	}

	// Close database
	@Override
	public void onDestroy() {
		timeService.destroy();
		super.onDestroy();
	}

	@Override
	public void onListItemClick(ListView list, View v, int position, long id) {
		// onListItemClick
	}
	
	@Override
	public void onResume() {
		readData();
		mAdapter.notifyDataSetChanged();
		
		super.onResume();
	}
}
