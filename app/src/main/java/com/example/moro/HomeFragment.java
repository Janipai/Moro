package com.example.moro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements View.OnClickListener{

    ArrayList<Event> testEvents;
    ListView eventList;
    EventArrayAdapter eventAdapter;
    Button vibeCheck;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        createEvents();

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        eventList = (ListView) view.findViewById(R.id.eventlistview);
        eventAdapter = new EventArrayAdapter(getActivity(), R.layout.home_event_adapterv_view_layout, testEvents);
        eventList.setAdapter(eventAdapter);

        vibeCheck = view.findViewById(R.id.eventTxt);
        vibeCheck.setOnClickListener(this);

        return view;
    }

    public void createEvents() {
        Event event1 = new Event("Softball", "3 KM", "10/11/2020", "10:00 - 12:00");
        Event event2 = new Event("Kunst", "1.6 KM", "11/11/2020", "15:00 - 16:00");
        Event event3 = new Event("Crowd bowling", "2 KM", "11/11/2020", "12:00 - 16:00");
        Event event4 = new Event("Vin smagning", "3.3 KM", "13/11/2020", "18:00 - 20:00");
        Event event5 = new Event("Kulturnat", "4 KM", "16/11/2020", "14:00 - 16:00");
        Event event6 = new Event("Pudekamp", "1.2 KM", "09/11/2020", "12:00 - 13:00");
        Event event7 = new Event("Nøgenløb", "2.4 KM", "1/11/2020", "14:00 - 16:00");
        Event event8 = new Event("Mini festival", "3.6 KM", "5/11/2020", "10:00 - 06:00");

        testEvents = new ArrayList<>();
        testEvents.add(event1);
        testEvents.add(event2);
        testEvents.add(event3);
        testEvents.add(event4);
        testEvents.add(event5);
        testEvents.add(event6);
        testEvents.add(event7);
        testEvents.add(event8);

    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new HvornaarFragment()).addToBackStack(null).commit();
    }
}
