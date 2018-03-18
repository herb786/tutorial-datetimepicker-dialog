package com.hacaller.trainticketbooking;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;


public class DateDialogFragment extends DialogFragment {

    DatePickerDialog.OnDateSetListener onDateSetListener;

    public DateDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),onDateSetListener,year, month, day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DatePickerDialog.OnDateSetListener) {
            onDateSetListener = (DatePickerDialog.OnDateSetListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDateSetListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDateSetListener = null;
    }

}
