package com.android.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class TimeTracker extends Activity {

    private static final int TIME_TRACKER_ENTRY_CODE = 1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TimeTrackerListFragment fragment = (TimeTrackerListFragment) getFragmentManager().findFragmentById(R.id.listViewFragment);
        fragment.init(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.time_list_menu, menu);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        if (R.id.add_time_menu_item == item.getItemId()) {
            Intent intent = new Intent(this, TimeTrackerEntryActivity.class);
            startActivityForResult(intent, TIME_TRACKER_ENTRY_CODE);
            return true;
        }

        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TIME_TRACKER_ENTRY_CODE) {
            if (resultCode == RESULT_OK) {
                TimeTrackerListFragment fragment = (TimeTrackerListFragment) getFragmentManager().findFragmentById(R.id.listViewFragment);
                
                String time = data.getStringExtra("time");
                String notes = data.getStringExtra("notes");
                
                fragment.addTime(new TimeRecord(time, notes));
            }
        }
    }
}
