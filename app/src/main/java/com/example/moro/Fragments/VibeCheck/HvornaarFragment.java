package com.example.moro.Fragments.VibeCheck;

import android.app.DatePickerDialog;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;
/**
 * @author s195477, Shania Hau
 */
public class HvornaarFragment extends CustomFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    DatePicker dp;
    Button calendersubmit;
    TextView test;
    View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_hvornaar,container,false);

        test = v.findViewById(R.id.hvornaarTest);

        calendersubmit = v.findViewById(R.id.idcalendersubmission);
        calendersubmit.setOnClickListener(this);

        dp = v.findViewById(R.id.datePicker);

        return v;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        showSetDate(year,month,dayOfMonth);
        //get choosen date
    }

    public void showSetDate(int year, int month, int dayOfMonth) {
        //get choosen date
        String choosenDate = "day/month/year: " + dayOfMonth + "/" + month + "/" + year;
        test.setText(choosenDate);
    }

    @Override
    public void onClick(View v) {
        replaceFragment(new HvadFragment());
    }
}