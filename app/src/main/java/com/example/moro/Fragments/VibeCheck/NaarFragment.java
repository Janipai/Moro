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
import android.graphics.Matrix;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;

import java.util.Arrays;
/**
 * @author s195477, Shania Hau
 */
public class NaarFragment extends CustomFragment implements View.OnClickListener {

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

        Matrix matrix = new Matrix();

        ImageView arrowDown = v.findViewById(R.id.arrow_down);
        ImageView arrowUp = v.findViewById(R.id.arrow_up);

        arrowDown.setRotation(-90);
        arrowUp.setRotation(-90);

        typeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
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

    @Override
    public void onClick(View v) {

    }
}