package com.android.timetracker.db;

import java.util.List;

import com.android.timetracker.TimeRecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TimeTrackerDatabaseHelper {
    
    private static final String TIME = "TIME";

    private static final String NOTES = "NOTES";

    private static final String TABLE_NAME = "TIMERECORD";

    private TimeTrackerOpenHelper openHelper;
    
    private SQLiteDatabase db;

    public TimeTrackerDatabaseHelper(Context context) {
        openHelper = new TimeTrackerOpenHelper(context);
        db = openHelper.getWritableDatabase();
    }

    
    public void save(TimeRecord record){
        ContentValues values = new ContentValues();
        values.put(TIME, record.getTime());
        values.put(NOTES, record.getNotes());
        db.insert(TABLE_NAME, null, values);
    }
    
    public Cursor list(){
        return db.rawQuery("select * from " + TABLE_NAME, null);
    }
}
