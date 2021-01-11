package com.example.moro.Fragments.VibeCheck;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;

public class HvornaarFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    DatePicker dp;
    Button calendersubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hvornaar, container, false);

        calendersubmit = view.findViewById(R.id.idcalendersubmission);
        calendersubmit.setOnClickListener(this);

        dp = view.findViewById(R.id.datePicker);


        /*'calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (dayOfMonth + "/" + month + "/" + year);
                test.setText(date);
            }
        });*/


        return view;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        //get choosen date
        showSetDate(year,month,dayOfMonth);
    }

    public void showSetDate(int year, int month, int dayOfMonth) {
        //get choosen date
        String date = "day/month/year: " + dayOfMonth + "/" + month + "/" + year;
        System.out.println(date);
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new HvadFragment()).addToBackStack(null).commit();
    }
}