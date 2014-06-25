package com.aachaerandio.wastedtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;
import android.widget.Toast;

import com.aachaerandio.wastedtime.adapter.TimeItemAdapter;
import com.aachaerandio.wastedtime.service.TimeBean;
import com.aachaerandio.wastedtime.service.TimeService;

public class ListWastedTime extends ListFragment {

	private TimeService timeService;
	private ArrayList<TimeBean> timeBeans;
	private TimeItemAdapter mAdapter;
	private ActionMode mActionMode;

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
		
		
		
		final ListView listView = getListView();
		
		// Enabling batch contextual actions
		//ListView listView = getListView();
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
			
			private int nSelected = 0;
			private ShareActionProvider mShareActionProvider;

		    @Override
		    public void onItemCheckedStateChanged(ActionMode mode, int position,
		                                          long id, boolean checked) {
		        // When items are selected/de-selected, such as update the title in the CAB
		    	if (checked) {
		    		nSelected++;
                    mAdapter.setNewSelection(position, checked);                   
                } else {
                	nSelected--;
                    mAdapter.removeSelection(position);                
                }
                mode.setTitle(nSelected + " selected");
                
                // invalidate the CAB to be able to hide and show menu items
		    	mode.invalidate();
		    }

		    @Override
		    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		        // Respond to clicks on the actions in the CAB
		        switch (item.getItemId()) {
		            case R.id.menu_delete:
		                deleteSelectedItems();
		                mode.finish(); // Action picked, so close the CAB
		                return true;
		            case R.id.menu_share:
		            	Toast.makeText(getActivity(), "Shared!", Toast.LENGTH_SHORT).show();
		            	nSelected = 0;
		            	shareSelectedItem();
		            	mAdapter.clearSelection();
		                mode.finish(); // Action picked, so close the CAB
		                return true;
		            default:
		                return false;
		        }
		    }

			private void shareSelectedItem() {
				Intent tweetIntent = new Intent(Intent.ACTION_SEND);
				//mAdapter.getItem(listView.getSelectedItemPosition());
				String shareText="prueba"; //= time.getText().toString() +" wasted "+ text.getText().toString();
				shareText += " #wastedTimeApp"; 
				tweetIntent.putExtra(Intent.EXTRA_TEXT, shareText);
				tweetIntent.setType("text/plain");
				startActivity(Intent.createChooser(tweetIntent, "Choose"));
				
			}

			@Override
		    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
		        // Inflate the menu for the CAB
				nSelected = 0;
		        MenuInflater inflater = mode.getMenuInflater();
		        inflater.inflate(R.menu.contextual_menu, menu);
		        
//		        final MenuItem shareItem = menu.findItem(R.id.menu_share);
//		        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
//		        mShareActionProvider.setShareIntent(getDefaultIntent());
		        
		        return true;
		    }
			
//			private Intent getDefaultIntent() {
//			    Intent intent = new Intent(Intent.ACTION_SEND);
//			    intent.putExtra(Intent.EXTRA_TEXT, "This is a message for you");
//			    intent.setType("text/plain");
//			    return intent;
//			}
//			
//			private void doShare() {
//			    Intent intent = new Intent(Intent.ACTION_SEND);
//			    intent.setType("text/plain");
//			    intent.putExtra(Intent.EXTRA_TEXT, "This is a message for you");
//			    mShareActionProvider.setShareIntent(intent);
//			}

		    @Override
		    public void onDestroyActionMode(ActionMode mode) {
		        // When the CAB is removed. By default, selected items are deselected/unchecked.
		    	mAdapter.clearSelection();
		    }

		    @Override
		    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		        // Perform updates to the CAB due to an invalidate() request
				// Enabling share
		    	boolean isSingleSelection = mAdapter.getCurrentCheckedPosition().size() == 1;
		    	menu.findItem(R.id.menu_share).setVisible(isSingleSelection);
		    	
		        return true;
		    }
		    
		    
		    private void deleteSelectedItems() {
		    	nSelected = 0;
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
			}
		    
		});
		
		
//		getListView().setOnLongClickListener(new OnLongClickListener() {
//			
//			@Override
//			public boolean onLongClick(View v) {
//				getListView().setItemChecked(getSelectedItemPosition(),!mAdapter.isPositionChecked(getSelectedItemPosition()));
//				return false;
//			}
//		});
	
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
