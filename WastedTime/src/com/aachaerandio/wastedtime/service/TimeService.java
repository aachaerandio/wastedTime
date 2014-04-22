package com.aachaerandio.wastedtime.service;


import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public void insert(TimeBean data) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		ContentValues values = new ContentValues();

		values.put(DatabaseOpenHelper.COLUMN_COMMENT, data.getComment());
		values.put(DatabaseOpenHelper.COLUMN_ICON, data.getIcon().ordinal());
		values.put(DatabaseOpenHelper.COLUMN_TIME, data.getElapsedTime());
		values.put(DatabaseOpenHelper.COLUMN_DATE, df.format(new Date()));
		mDB.insert(DatabaseOpenHelper.TABLE_NAME, null, values);
	}

	public Cursor read() {
		return mDB.query(DatabaseOpenHelper.TABLE_NAME,
				DatabaseOpenHelper.columns, null, new String[] {}, null, null,
				null);
	}
	
	public void clearAll() {

		mDB.delete(DatabaseOpenHelper.TABLE_NAME, null, null);

	}

	public void destroy(){
		mDB.close();
	}
}
