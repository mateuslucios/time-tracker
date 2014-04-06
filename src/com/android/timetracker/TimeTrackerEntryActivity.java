package com.android.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TimeTrackerEntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_entry);
    }
    
    public void onClickSaveButton(View view) {
        Intent intent = getIntent();
        
        EditText edtTime = (EditText) findViewById(R.id.edtTime);
        intent.putExtra("time", edtTime.getText().toString());

        EditText edtNotes = (EditText) findViewById(R.id.edtNotes);
        intent.putExtra("notes", edtNotes.getText().toString());
        
        setResult(RESULT_OK, intent);
        
        finish();
    }

    public void onClickCancelButton(View view) {
        finish();
    }
}
