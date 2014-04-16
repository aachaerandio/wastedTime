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
		Cursor c = timeService.read();
		mAdapter = new SimpleCursorAdapter(getActivity(), R.layout.rowlayout,
				c, DatabaseOpenHelper.columns,
				new int[] { R.id._id, R.id.label }, 0);

		setListAdapter(mAdapter);
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
}
