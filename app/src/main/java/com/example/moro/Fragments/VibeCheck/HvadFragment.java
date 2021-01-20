package com.example.moro.Fragments.VibeCheck;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;

import java.util.Arrays;

/**
 * @author s195477, Shania Hau
 */
public class HvadFragment extends CustomFragment {

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
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(), 3));
        recyclerView.setAdapter(myAdapter);


        final TextView typeText = v.findViewById(R.id.idstemning);
        ImageView arrowDown = v.findViewById(R.id.arrow_down);
        ImageView arrowUp = v.findViewById(R.id.arrow_up);

        arrowDown.setRotation(-90);
        arrowUp.setRotation(-90);


        typeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new NaarFragment());
            }
        });

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HvorFragment());
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return v;
    }
}