package com.aachaerandio.wastedtime;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aachaerandio.wastedtime.adapter.TimeItemAdapter;
import com.aachaerandio.wastedtime.service.TimeBean;
import com.aachaerandio.wastedtime.service.TimeService;

public class ListWastedTime extends ListFragment {

	private TimeService timeService;
	private ArrayList<TimeBean> timeBeans;
	private TimeItemAdapter mAdapter;

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

		setListAdapter(mAdapter);
	}

	private void readData() {
		timeBeans = timeService.read();
		
		if (mAdapter == null){
			//custom adapter:
			//array adapter to bind the array to the listview
			mAdapter = new TimeItemAdapter(getActivity(), R.layout.rowlayout, timeBeans);
		}
		else{
			mAdapter.clear();
			mAdapter.addAll(timeBeans);
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
