package com.example.moro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    String[] testEvents = {"Softball", "Kunstner fremvisning", "Natklub åbning", "Vin smagning", "Kulturnat", "Øl smagning", "Pudekamp på rådhuspladsen", "Nøgenløb", "Ild festival"};
    ListView eventList;
    ArrayAdapter<String> eventAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        eventList = (ListView) view.findViewById(R.id.eventlistview);
        eventAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, testEvents);
        eventList.setAdapter(eventAdapter);

        return view;
    }
}
