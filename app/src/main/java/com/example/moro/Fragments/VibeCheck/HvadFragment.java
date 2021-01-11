package com.example.moro.Fragments.VibeCheck;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moro.R;

import java.util.Arrays;

public class HvadFragment extends Fragment{

    private RecyclerView recyclerView;
    String[] hvadButtonname = {"Koncert", "Udstilling og kunst",
            "Litteratur", "Film", "comedy",
            "talk", "teater og forestillinger", "fest",
            "gratis", "sport og spil", "mad og drikke", "mode"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hvad, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_hvad);

        ButtonListAdapter myAdapter = new ButtonListAdapter(v.getContext(), Arrays.asList(hvadButtonname));
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),3));
        recyclerView.setAdapter(myAdapter);


        final TextView typeText = v.findViewById(R.id.idstemning);
        ImageView arrowDown = v.findViewById(R.id.arrow_down);
        ImageView arrowUp = v.findViewById(R.id.arrow_up);

        typeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NaarFragment naar = new NaarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_fragment_container, naar);
                transaction.commit();
            }
        });

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvorFragment hvor = new HvorFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_fragment_container, hvor);
                transaction.commit();
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvornaarFragment hvornaar = new HvornaarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_fragment_container, hvornaar);
                transaction.commit();
            }
        });
        return v;
    }
}