package com.hacaller.trainticketbooking;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    EditText dayEditText;
    EditText timeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dayEditText = findViewById(R.id.DAY_EDITTEXT);
        timeEditText = findViewById(R.id.TIME_EDITTEXT);

        dayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DateDialogFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        timeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new TimeDialogFragment();
                newFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date = String.format("%02d/%02d/%d", i2,i1+1,i);
        dayEditText.setText(date);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        String time = String.format("%02dh:%02dm", i, i1);
        timeEditText.setText(time);
    }
}
