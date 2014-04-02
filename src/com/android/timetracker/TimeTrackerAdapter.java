package com.android.timetracker;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TimeTrackerAdapter extends BaseAdapter {

    private List<TimeRecord> timeRecords = new ArrayList<>();
    
    
    public TimeTrackerAdapter(){
        timeRecords.add(new TimeRecord("38:23", "Feeling good!"));
        timeRecords.add(new TimeRecord("49:01", "Tired. Needed more caffeine."));
        timeRecords.add(new TimeRecord("26:21", "I'm rocking it!"));
        timeRecords.add(new TimeRecord("29:42", "Lost some time on the hills, but pretty good."));
    }

    @Override
    public int getCount() {
        return timeRecords.size();
    }

    @Override
    public Object getItem(int index) {
        return timeRecords.get(index);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public View getView(int index, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.time_tracker_item, parent, false);
        }
        
        TimeRecord tr = timeRecords.get(index);
        TextView tvTime = (TextView) view.findViewById(R.id.tvTime);
        tvTime.setText(tr.getTime());
        TextView tvNotes = (TextView) view.findViewById(R.id.tvNotes);
        tvNotes.setText(tr.getNotes());
        
        return view;
    }

}
