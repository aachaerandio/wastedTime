package com.aachaerandio.wastedtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
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
		
		// Enabling batch contextual actions
		ListView listView = getListView();
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
			
			private int nSelected = 0;

		    @Override
		    public void onItemCheckedStateChanged(ActionMode mode, int position,
		                                          long id, boolean checked) {
		        // Here you can do something when items are selected/de-selected,
		        // such as update the title in the CAB
		    	if (checked) {
		    		nSelected++;
                    mAdapter.setNewSelection(position, checked);                   
                } else {
                	nSelected--;
                    mAdapter.removeSelection(position);                
                }
                mode.setTitle(nSelected + " selected");
		    }

		    @Override
		    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		        // Respond to clicks on the actions in the CAB
		        switch (item.getItemId()) {
		            case R.id.menu_delete:
		            	nSelected = 0;
		                //deleteSelectedItems();
		            	Set<Integer> positions = mAdapter.getCurrentCheckedPosition();
		            	List<TimeBean> selectedItems = new ArrayList<TimeBean>();
		            	for (Integer pos : positions) {
		            		selectedItems.add(mAdapter.getItem(pos));
		            	}
		            	for (TimeBean timeBean: selectedItems) {
		            		timeService.delete(timeBean.getId());
		            		mAdapter.remove(timeBean);
		            	}
	            		mAdapter.notifyDataSetChanged();
		                mAdapter.clearSelection();
		                mode.finish(); // Action picked, so close the CAB
		                return true;
		            default:
		                return false;
		        }
		    }

		    @Override
		    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
		        // Inflate the menu for the CAB
		        MenuInflater inflater = mode.getMenuInflater();
		        inflater.inflate(R.menu.contextual_menu, menu);
		        return true;
		    }

		    @Override
		    public void onDestroyActionMode(ActionMode mode) {
		        // When the CAB is removed. By default, selected items are deselected/unchecked.
		    }

		    @Override
		    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		        // Perform updates to the CAB due to an invalidate() request
		        return false;
		    }
		});
		
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
