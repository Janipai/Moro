package com.example.moro.VibeCheck;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moro.R;

import java.util.ArrayList;
import java.util.Arrays;

public class NaarFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    String[] naarButtonname = {"Du vil ikke hjem, men videre", "Du vil ud i det blå",
            "Du har tømmermænd", "Du vil udvide din horisont", "du har tomme lommer",
            "mad gør dig glad", "du vil forkæle dig selv", "du vil imponere din date",
            "de gamle kommer på besøg", "du vil have gang i kroppen", "", ""};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_naar, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_naar);
        ButtonListAdapter myAdapter = new ButtonListAdapter(v.getContext(), Arrays.asList(naarButtonname));
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),3));
        recyclerView.setAdapter(myAdapter);

        TextView typeText = v.findViewById(R.id.idtype);

        ImageView arrowDown = v.findViewById(R.id.arrow_down);
        ImageView arrowUp = v.findViewById(R.id.arrow_up);


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

    }
}