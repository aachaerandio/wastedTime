package com.aachaerandio.wastedtime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	final static String TABLE_NAME = "times";
	final static String _ID = "_id";
	final static String COLUMN_NAME = "label";
	final static String COLUMN_NAME_ICON = "icon";
	final static String[] columns = { _ID, COLUMN_NAME, COLUMN_NAME_ICON };

	final private static String SQL_CREATE_ENTRIES =
	"CREATE TABLE " + TABLE_NAME +  "(" + 
	_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
	COLUMN_NAME_ICON + " BLOB" +
	COLUMN_NAME + " TEXT NOT NULL)";

	final private static String DATABASE_NAME = "wastedtime_db";
	final private static Integer VERSION = 1;
	final private Context mContext;

	public DatabaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	void deleteDatabase() {
		mContext.deleteDatabase(DATABASE_NAME);
	}
}
