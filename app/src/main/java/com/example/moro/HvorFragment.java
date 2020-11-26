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

import java.util.ArrayList;

public class HvorFragment extends Fragment implements View.OnClickListener {


    public HvorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ArrayList<Button> hvorButtonsList = new ArrayList<>();
    ArrayList<Button> choosenHvorButtonList = new ArrayList<>();
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_hvor, container, false);

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
        button10 = v.findViewById(R.id.button10);
        button11 = v.findViewById(R.id.button11);
        button12 = v.findViewById(R.id.button12);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);

        hvorButtonsList.add((Button) v.findViewById(R.id.button1));
        hvorButtonsList.add((Button) v.findViewById(R.id.button2));
        hvorButtonsList.add((Button) v.findViewById(R.id.button3));
        hvorButtonsList.add((Button) v.findViewById(R.id.button4));
        hvorButtonsList.add((Button) v.findViewById(R.id.button5));
        hvorButtonsList.add((Button) v.findViewById(R.id.button6));
        hvorButtonsList.add((Button) v.findViewById(R.id.button7));
        hvorButtonsList.add((Button) v.findViewById(R.id.button8));
        hvorButtonsList.add((Button) v.findViewById(R.id.button9));
        hvorButtonsList.add((Button) v.findViewById(R.id.button10));
        hvorButtonsList.add((Button) v.findViewById(R.id.button11));
        hvorButtonsList.add((Button) v.findViewById(R.id.button12));

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dine resultater skal ind her
                EventBeskrivelseFragment event = new EventBeskrivelseFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout,event);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvadFragment hvad = new HvadFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainLayout,hvad);
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

        if (!choosenHvorButtonList.contains(v)){
            for (int i = 0; i < hvorButtonsList.size(); i++) {
                if (v.getId() == hvorButtonsList.get(i).getId()) {
                    choosenHvorButtonList.add(hvorButtonsList.get(i));
                    hvorButtonsList.get(i).setBackgroundColor(Color.parseColor("#990000"));
                    hvorButtonsList.get(i).setTextColor(Color.parseColor("#FFB7FC"));
                }
            }
        } else {
            for (int i = 0; i < hvorButtonsList.size(); i++) {
                if (v.getId() == hvorButtonsList.get(i).getId()) {
                    hvorButtonsList.get(i).setBackgroundColor(Color.parseColor("#FFB7FC"));
                    hvorButtonsList.get(i).setTextColor(Color.parseColor("#990000"));
                    Drawable bg = getResources().getDrawable(R.drawable.hvor_button_style);
                    hvorButtonsList.get(i).setBackground(bg);
                    choosenHvorButtonList.remove(hvorButtonsList.get(i));
                }
            }
        }

    }
}