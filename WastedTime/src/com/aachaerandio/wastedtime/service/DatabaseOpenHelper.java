package com.aachaerandio.wastedtime.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	final static String TABLE_NAME = "times";
	
	final static String _ID = "_id";
	final static String COLUMN_ICON = "icon";
	final static String COLUMN_TIME = "time";
	final static String COLUMN_COMMENT = "label";
	public static final String COLUMN_DATE = "date";
	
	public final static String[] columns = { _ID, COLUMN_ICON, COLUMN_DATE, COLUMN_TIME, COLUMN_COMMENT};

	final private static String SQL_CREATE_ENTRIES =
	"CREATE TABLE " + TABLE_NAME +  "(" + 
	_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
	COLUMN_ICON + " NUMBER, " +
	COLUMN_TIME + " NUMBER, " +
	COLUMN_DATE + " DATE, " +
	COLUMN_COMMENT + " TEXT)";

	final private static String DATABASE_NAME = "wastedtime_db";
	final private static Integer VERSION = 1;

	final private Context mContext;

	public DatabaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.beginTransaction();
        try {
            db.execSQL(SQL_CREATE_ENTRIES);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
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
