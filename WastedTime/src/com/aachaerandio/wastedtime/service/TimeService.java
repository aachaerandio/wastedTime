package com.aachaerandio.wastedtime.service;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class TimeService {

	private SQLiteDatabase mDB = null;
	private DatabaseOpenHelper mDbHelper;
	
	public TimeService(Activity activity) {
		// Create a new DatabaseHelper
		mDbHelper = new DatabaseOpenHelper(activity);

		// Get the underlying database for writing
		mDB = mDbHelper.getWritableDatabase();
	}
	
	/* (non-Javadoc)
	 * @see com.aachaerandio.wastedtime.service.ITimeService#insert()
	 */
	public void insert(String data) {

		ContentValues values = new ContentValues();

		values.put(DatabaseOpenHelper.COLUMN_NAME, data);
		//values.put(DatabaseOpenHelper.COLUMN_NAME_ICON, "Times sql 1");
		mDB.insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.COLUMN_NAME, "Times sql 2");
		mDB.insert(DatabaseOpenHelper.TABLE_NAME, null, values);
	}

	// Returns all artist records in the database
	/* (non-Javadoc)
	 * @see com.aachaerandio.wastedtime.service.ITimeService#read()
	 */
	public Cursor read() {
		return mDB.query(DatabaseOpenHelper.TABLE_NAME,
				DatabaseOpenHelper.columns, null, new String[] {}, null, null,
				null);
	}
	
	// Delete all records
	/* (non-Javadoc)
	 * @see com.aachaerandio.wastedtime.service.ITimeService#clearAll()
	 */
	public void clearAll() {

		mDB.delete(DatabaseOpenHelper.TABLE_NAME, null, null);

	}
	
	/* (non-Javadoc)
	 * @see com.aachaerandio.wastedtime.service.ITimeService#destroy()
	 */
	public void destroy(){
		mDB.close();
		mDbHelper.deleteDatabase();
	}
}
