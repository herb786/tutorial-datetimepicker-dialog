package com.hacaller.trainticketbooking;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;


public class TimeDialogFragment extends DialogFragment {

    TimePickerDialog.OnTimeSetListener onTimeSetListener;

    public TimeDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),onTimeSetListener,hour, minute, true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TimePickerDialog.OnTimeSetListener) {
            onTimeSetListener = (TimePickerDialog.OnTimeSetListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTimeSetListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onTimeSetListener = null;
    }

}