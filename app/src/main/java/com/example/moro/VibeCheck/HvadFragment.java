package com.example.moro.VibeCheck;

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

import com.example.moro.MainActivity;
import com.example.moro.R;

import java.util.ArrayList;
import java.util.List;

public class HvadFragment extends Fragment{

    private RecyclerView recyclerView;
    List<ButtonTextDTO> listButtons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        createButtonText();

        View v = inflater.inflate(R.layout.fragment_hvad, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_hvad);

        ButtonListAdapter myAdapter = new ButtonListAdapter(v.getContext(),listButtons);
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

    public void createButtonText() {
        ButtonTextDTO button1 = new ButtonTextDTO("Nørrebro");
        ButtonTextDTO button2 = new ButtonTextDTO("Islandsbrygge");
        ButtonTextDTO button3 = new ButtonTextDTO("Indre By");
        ButtonTextDTO button4 = new ButtonTextDTO("Østerbro");
        ButtonTextDTO button5 = new ButtonTextDTO("Nordvest");
        ButtonTextDTO button6 = new ButtonTextDTO("Valby");
        ButtonTextDTO button7 = new ButtonTextDTO("Brønshøj");
        ButtonTextDTO button8 = new ButtonTextDTO("Amager");
        ButtonTextDTO button9 = new ButtonTextDTO("Vesterbro");
        ButtonTextDTO button10 = new ButtonTextDTO("Vanløse");
        ButtonTextDTO button11 = new ButtonTextDTO("Christianshavn");
        ButtonTextDTO button12 = new ButtonTextDTO("Refshaløen");


        listButtons = new ArrayList<>();

        listButtons.add(button1);
        listButtons.add(button2);
        listButtons.add(button3);
        listButtons.add(button4);
        listButtons.add(button5);
        listButtons.add(button6);
        listButtons.add(button7);
        listButtons.add(button8);
        listButtons.add(button9);
        listButtons.add(button10);
        listButtons.add(button11);
        listButtons.add(button12);

    }

}