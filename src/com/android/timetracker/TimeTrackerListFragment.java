package com.android.timetracker;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.timetracker.db.TimeTrackerDatabaseHelper;

public class TimeTrackerListFragment extends Fragment {

    private TimeTrackerAdapter timeTrackerAdapter;

    private TimeTrackerDatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.time_tracker, container, false);

        ListView listView = (ListView) fragmentView.findViewById(R.id.time_tracker_list);

        timeTrackerAdapter = new TimeTrackerAdapter();

        listView.setAdapter(timeTrackerAdapter);

        return fragmentView;
    }

    public void addTime(TimeRecord record) {
        databaseHelper.save(record);
        timeTrackerAdapter.add(record);
        timeTrackerAdapter.notifyDataSetChanged();
    }

    public void init(Context context) {
        databaseHelper = new TimeTrackerDatabaseHelper(context);
        
        Cursor cursor = databaseHelper.list();

        while (cursor.moveToNext()) {
            timeTrackerAdapter.add(new TimeRecord(cursor.getString(1), cursor.getString(2)));
        }
        
    }

}
