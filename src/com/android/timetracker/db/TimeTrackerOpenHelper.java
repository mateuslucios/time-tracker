package com.android.timetracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TimeTrackerOpenHelper extends SQLiteOpenHelper{

    public TimeTrackerOpenHelper(Context context) {
        super(context, "timetracker.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table timerecord (id integer primary key, time text, notes text)");
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists timerecord");
        onCreate(db);
    }

}
