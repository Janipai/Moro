package com.example.moro.Fragments.VibeCheck;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.EventHandler.SharedViewModel;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;
/**
 * @author s195477, Shania Hau
 */
public class HvornaarFragment extends CustomFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private SharedViewModel model;

    DatePicker dp;
    Button calendersubmit;
    TextView test;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);


        calendersubmit.setOnClickListener(item -> {
            model.select(showSetDate());

            replaceFragment(new HvadFragment());
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        test = getView().findViewById(R.id.hvornaarTest);

        calendersubmit = getActivity().findViewById(R.id.idcalendersubmission);
        //calendersubmit.setOnClickListener(this);

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
        showSetDate(year,month,dayOfMonth);
        //get choosen date
    }

    public void showSetDate(int year, int month, int dayOfMonth) {
        //get choosen date
        String choosenDate = "day/month/year: " + dayOfMonth + "/" + month + "/" + year;
    }

    @Override
    public void onClick(View v) {

//        backStateName = hvornaarFragment.getClass().getName();
//        boolean fragmentPopped = getActivity().getSupportFragmentManager().popBackStackImmediate(backStateName,0);
//        if(!fragmentPopped) {
//            ((MainActivity) getActivity()).getSupportFragmentManager().
//                    beginTransaction().
//                    replace(R.id.main_fragment_container, new HvadFragment()).
//                    addToBackStack(backStateName).
//                    commit();

    }
}