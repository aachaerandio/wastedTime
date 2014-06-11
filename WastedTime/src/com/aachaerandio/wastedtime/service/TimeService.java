package com.aachaerandio.wastedtime.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.aachaerandio.wastedtime.service.TimeBean.WastedTimeIcon;

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

	public ArrayList<TimeBean> read() {
		ArrayList<TimeBean> result = new ArrayList<TimeBean>();
		
		Cursor c = mDB.query(DatabaseOpenHelper.TABLE_NAME,
				DatabaseOpenHelper.columns, null, new String[] {}, null, null,
				DatabaseOpenHelper._ID +" DESC");
		
		if (c.getCount() > 0){
			c.moveToFirst();
			do{
				TimeBean item = new TimeBean();
				item.setId(c.getLong(c.getColumnIndex(DatabaseOpenHelper._ID)));
				item.setComment(c.getString(c.getColumnIndex(DatabaseOpenHelper.COLUMN_COMMENT)));
				item.setElapsedTime(c.getLong(c.getColumnIndex(DatabaseOpenHelper.COLUMN_TIME)));
				item.setCreated(parseDate(c.getString(c.getColumnIndex(DatabaseOpenHelper.COLUMN_DATE))));
				WastedTimeIcon[] icons = WastedTimeIcon.values();
				item.setIcon(icons[c.getInt(c.getColumnIndex(DatabaseOpenHelper.COLUMN_ICON))]);
				
				result.add(item);
			}while(c.moveToNext());
		}
		
		return result;
	}
	
	private Date parseDate(String string){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		try {
			d = df.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public void delete(long data) {

		mDB.delete(DatabaseOpenHelper.TABLE_NAME, DatabaseOpenHelper._ID + "=" + data, null);

	}
	
	public void clearAll() {

		mDB.delete(DatabaseOpenHelper.TABLE_NAME, null, null);

	}

	public void destroy(){
		mDB.close();
	}
}
