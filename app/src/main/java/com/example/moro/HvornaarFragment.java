package com.example.moro;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class HvornaarFragment extends Fragment implements View.OnClickListener {

    public HvornaarFragment() {
        // Required empty public constructor
    }

    TextView test;
    CalendarView calendarView;
    Button calender;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hvornaar, container, false);

        calender = view.findViewById(R.id.idcalender);
        calender.setOnClickListener(this);

        calendarView = view.findViewById(R.id.calender);
        test = view.findViewById(R.id.testCalenderDate);

        calendarView.setWeekSeparatorLineColor(Color.parseColor("#FF542B"));


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (dayOfMonth + "/" + month + "/" + year);
                test.setText(date);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new HvadFragment()).commit();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();

    }
}