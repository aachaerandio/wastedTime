package com.aachaerandio.wastedtime;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListWastedTime extends ListFragment {
	
	//prueba estática
	 private String mytimes[];
	  
	 public ListWastedTime() {
	   
		 mytimes = new String[] {
	    "Tiempo 1",
	    "Tiempo 2",
	    "Tiempo 3",
	    "Tiempo 4"
	  };
	 }	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) { 
        View v = inflater.inflate(R.layout.fragment_listwasted, container, false);
         
        return v;
    }
    
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		 super.onActivityCreated(savedInstanceState);	
		 
	     //android.R.layout.simple_list_item_1 
	     ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.rowlayout, R.id.label, mytimes);
	     setListAdapter(listAdapter);
	}
	     
    @Override
    public void onListItemClick(ListView list, View v, int position, long id) {
      
     //onListItemClick
    }
}
