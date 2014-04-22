package com.aachaerandio.wastedtime;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.aachaerandio.wastedtime.service.DatabaseOpenHelper;
import com.aachaerandio.wastedtime.service.TimeService;

public class ListWastedTime extends ListFragment {

	private SimpleCursorAdapter mAdapter;
	private TimeService timeService;
	private Cursor c;

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
		c = timeService.read();
		
		if (mAdapter == null){
			mAdapter = new SimpleCursorAdapter(getActivity(), R.layout.rowlayout,
					c, DatabaseOpenHelper.columns,
					new int[] { R.id._id, R.id.iconid, R.id.date, R.id.time, R.id.label}, 0);
		}
		else{
			mAdapter.changeCursor(c);
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
