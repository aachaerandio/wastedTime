package com.aachaerandio.wastedtime;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListWastedTime extends ListFragment {
	
	//prueba estatica
	private String mytimes_static[];
	private SQLiteDatabase mDB = null;
	private DatabaseOpenHelper mDbHelper;
	private SimpleCursorAdapter mAdapter;
	  
	public ListWastedTime() {	   
		mytimes_static = new String[] {
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
		 /*
	     ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.rowlayout, R.id.label, mytimes_static);
	     setListAdapter(listAdapter);
	     */
		 
	     //DATABASE prueba
			// Create a new DatabaseHelper
			mDbHelper = new DatabaseOpenHelper(getActivity());

			// Get the underlying database for writing
			mDB = mDbHelper.getWritableDatabase();

			// start with an empty database
			clearAll();

			// Insert records
			insert();

			// Create a cursor
			Cursor c = read();
			mAdapter = new SimpleCursorAdapter(getActivity(), R.layout.rowlayout, c,
					DatabaseOpenHelper.columns, new int[] { R.id._id, R.id.label },
					0);

			setListAdapter(mAdapter);

	}

//////////////////////////////////////////////
	// Insert several records
		private void insert() {

			ContentValues values = new ContentValues();

			values.put(DatabaseOpenHelper.COLUMN_NAME, "Times sql 1");
			//values.put(DatabaseOpenHelper.COLUMN_NAME_ICON, "Times sql 1");
			mDB.insert(DatabaseOpenHelper.TABLE_NAME, null, values);

			values.clear();

			values.put(DatabaseOpenHelper.COLUMN_NAME, "Times sql 2");
			mDB.insert(DatabaseOpenHelper.TABLE_NAME, null, values);
		}

		// Returns all artist records in the database
		private Cursor read() {
			return mDB.query(DatabaseOpenHelper.TABLE_NAME,
					DatabaseOpenHelper.columns, null, new String[] {}, null, null,
					null);
		}
		
		// Delete all records
		private void clearAll() {

			mDB.delete(DatabaseOpenHelper.TABLE_NAME, null, null);

		}

		// Close database
		//He modificado la visibilidad de protected a public, por la libreria soporte!?
		@Override
		public void onDestroy() {

			mDB.close();
			mDbHelper.deleteDatabase();

			super.onDestroy();

		}
//////////////////////////////////////////////
	     
    @Override
    public void onListItemClick(ListView list, View v, int position, long id) {
      
     //onListItemClick
    }
}
