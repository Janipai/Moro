package com.example.moro.Fragments.EventHandler;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.HomeFragment;
import com.example.moro.R;

import java.util.ArrayList;
import java.util.List;


public class EventFragment extends Fragment{

    List<EventDTO> testEvents;
    private RecyclerView myrv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeFragment home = new HomeFragment();
        createEvents();


        View view = inflater.inflate(R.layout.fragment_event2,container,false);
        myrv = (RecyclerView) view.findViewById(R.id.recyclerview);
        EventSideBySideAdapter myAdapter = new EventSideBySideAdapter( view.getContext(), testEvents);
        myrv.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        myrv.setAdapter(myAdapter);

        return view;
    }

    public void createEvents() {
        EventDTO event1 = new EventDTO("Softball", "3 KM", "10/11/2020", "10:00 - 12:00",R.drawable.bruh);
        EventDTO event2 = new EventDTO("Kunst", "1.6 KM", "11/11/2020", "15:00 - 16:00",R.drawable.bruh);
        EventDTO event3 = new EventDTO("Crowd bowling", "2 KM", "11/11/2020", "12:00 - 16:00", R.drawable.bruh);
        EventDTO event4 = new EventDTO("Vin smagning", "3.3 KM", "13/11/2020", "18:00 - 20:00",R.drawable.bruh);
        EventDTO event5 = new EventDTO("Kulturnat", "4 KM", "16/11/2020", "14:00 - 16:00",R.drawable.bruh);
        EventDTO event6 = new EventDTO("Pudekamp", "1.2 KM", "09/11/2020", "12:00 - 13:00",R.drawable.bruh);
        EventDTO event7 = new EventDTO("Nøgenløb", "2.4 KM", "1/11/2020", "14:00 - 16:00",R.drawable.bruh);
        EventDTO event8 = new EventDTO("Mini festival", "3.6 KM", "5/11/2020", "10:00 - 06:00",R.drawable.bruh);

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


}