package com.example.moro.VibeCheck;

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

import com.example.moro.R;
import com.example.moro.VibeCheck.HvadFragment;
import com.example.moro.VibeCheck.HvorFragment;
import com.example.moro.VibeCheck.HvornaarFragment;

import java.util.ArrayList;

public class NaarFragment extends Fragment implements View.OnClickListener {

    public NaarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
    ArrayList<Button> naarButtonsList = new ArrayList<>();
    ArrayList<Button> choosenNaarButtonList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_naar, container, false);
        TextView typeText = v.findViewById(R.id.idtype);

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

        naarButtonsList.add((Button) v.findViewById(R.id.button1));
        naarButtonsList.add((Button) v.findViewById(R.id.button2));
        naarButtonsList.add((Button) v.findViewById(R.id.button3));
        naarButtonsList.add((Button) v.findViewById(R.id.button4));
        naarButtonsList.add((Button) v.findViewById(R.id.button5));
        naarButtonsList.add((Button) v.findViewById(R.id.button6));
        naarButtonsList.add((Button) v.findViewById(R.id.button7));
        naarButtonsList.add((Button) v.findViewById(R.id.button8));
        naarButtonsList.add((Button) v.findViewById(R.id.button9));
        naarButtonsList.add((Button) v.findViewById(R.id.button10));
        naarButtonsList.add((Button) v.findViewById(R.id.button11));
        naarButtonsList.add((Button) v.findViewById(R.id.button12));

        typeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvadFragment hvad = new HvadFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_container, hvad);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvorFragment hvor = new HvorFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_container,hvor);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvornaarFragment hvornaar = new HvornaarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment_container,hvornaar);
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

        if (!choosenNaarButtonList.contains(v)){
            for (int i = 0; i < naarButtonsList.size(); i++) {
                if (v.getId() == naarButtonsList.get(i).getId()) {
                    choosenNaarButtonList.add(naarButtonsList.get(i));
                    naarButtonsList.get(i).setBackgroundColor(Color.parseColor("#FFA500"));
                    naarButtonsList.get(i).setTextColor(Color.parseColor("#FFFDBA"));
                }
            }
        } else {
            for (int i = 0; i < naarButtonsList.size(); i++) {
                if (v.getId() == naarButtonsList.get(i).getId()) {
                    naarButtonsList.get(i).setBackgroundColor(Color.parseColor("#FFFDBA"));
                    naarButtonsList.get(i).setTextColor(Color.parseColor("#FFA500"));
                    Drawable bg = getResources().getDrawable(R.drawable.hvad_button_style);
                    naarButtonsList.get(i).setBackground(bg);
                    choosenNaarButtonList.remove(naarButtonsList.get(i));
                }
            }
        }

    }
}