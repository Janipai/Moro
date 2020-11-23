package com.example.moro;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HvadFragment extends Fragment implements View.OnClickListener {

    public HvadFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ArrayList<Button> hvadButtonsList = new ArrayList<>();
    ArrayList<Button> choosenHvadButtonList = new ArrayList<>();
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hvad, container, false);
        final TextView typeText = v.findViewById(R.id.idstemning);

        ImageView arrowDown = v.findViewById(R.id.arrow_down);
        ImageView arrowUp = v.findViewById(R.id.arrow_up);

        button1 = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);
        button4 = v.findViewById(R.id.button4);
        button5 = v.findViewById(R.id.button5);
        button6 = v.findViewById(R.id.button6);
        button7 = v.findViewById(R.id.button7);
        button8 = v.findViewById(R.id.button8);
        button9 = v.findViewById(R.id.button9);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        hvadButtonsList.add((Button) v.findViewById(R.id.button1));
        hvadButtonsList.add((Button) v.findViewById(R.id.button2));
        hvadButtonsList.add((Button) v.findViewById(R.id.button3));
        hvadButtonsList.add((Button) v.findViewById(R.id.button4));
        hvadButtonsList.add((Button) v.findViewById(R.id.button5));
        hvadButtonsList.add((Button) v.findViewById(R.id.button6));
        hvadButtonsList.add((Button) v.findViewById(R.id.button7));
        hvadButtonsList.add((Button) v.findViewById(R.id.button8));
        hvadButtonsList.add((Button) v.findViewById(R.id.button9));

        typeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NaarFragment naar = new NaarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, naar);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvorFragment hvor = new HvorFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, hvor);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvornaarFragment hvornaar = new HvornaarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout, hvornaar);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }


    @Override
    public void onClick(View v) {
        buttonClicked(v);
    }

    public void buttonClicked(View v) {

        if (!choosenHvadButtonList.contains(v)){
            for (int i = 0; i < hvadButtonsList.size(); i++) {
                if (v.getId() == hvadButtonsList.get(i).getId()) {
                    choosenHvadButtonList.add(hvadButtonsList.get(i));
                    hvadButtonsList.get(i).setBackgroundColor(Color.parseColor("#FFA500"));
                    hvadButtonsList.get(i).setTextColor(Color.parseColor("#FFFDBA"));
                }
            }
        } else {
            for (int i = 0; i < hvadButtonsList.size(); i++) {
                if (v.getId() == hvadButtonsList.get(i).getId()) {
                    hvadButtonsList.get(i).setBackgroundColor(Color.parseColor("#FFFDBA"));
                    hvadButtonsList.get(i).setTextColor(Color.parseColor("#FFA500"));
                    Drawable bg = getResources().getDrawable(R.drawable.hvad_button_style);
                    hvadButtonsList.get(i).setBackground(bg);
                    choosenHvadButtonList.remove(hvadButtonsList.get(i));
                }
            }
        }

    }

}