package com.android.timetracker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TimeTrackerListFragment extends Fragment {
    
    private TimeTrackerAdapter timeTrackerAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.time_tracker, container, false);  
        
        ListView listView = (ListView) fragmentView.findViewById(R.id.time_tracker_list);
        
        timeTrackerAdapter = new TimeTrackerAdapter();
        
        listView.setAdapter(timeTrackerAdapter);
        
        return fragmentView;
    }

}
