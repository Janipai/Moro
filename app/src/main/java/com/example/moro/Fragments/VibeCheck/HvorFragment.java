package com.example.moro.Fragments.VibeCheck;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.EventHandler.EventBeskrivelseFragment;
import com.example.moro.R;

import java.util.Arrays;

public class HvorFragment extends CustomFragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    String[] hvadButtonname = {"Nørrebro", "Islands brugge",
            "Indre by", "Østerbro", "Nordvest",
            "Valby", "Brønshøj og Husum", "Amager",
            "Vesterbro", "Vanløse", "Christianshavn", "Refshaleøen"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_hvor, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_hvor);

        ButtonListHvorAdapter myAdapter = new ButtonListHvorAdapter(v.getContext(), Arrays.asList(hvadButtonname));
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),3));
        recyclerView.setAdapter(myAdapter);

        ImageView arrowDown = v.findViewById(R.id.arrow_down);
        ImageView arrowUp = v.findViewById(R.id.arrow_up);



        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dine resultater skal ind her
                replaceFragment(new EventBeskrivelseFragment());
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
//                replaceFragment(new HvadFragment());
            }
        });
        return v;
    }

    @Override
    public void onClick(View v) {

    }

}