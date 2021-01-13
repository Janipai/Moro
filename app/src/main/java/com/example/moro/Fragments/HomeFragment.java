package com.example.moro.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.R;
import com.example.moro.Fragments.VibeCheck.HvornaarFragment;

import java.util.ArrayList;


public class HomeFragment extends CustomFragment implements View.OnClickListener{

    ArrayList<EventDTO> testEvents;
    ArrayList<EventDTO> rightNowTestEvents;

    ViewPager viewPager;
    ListView eventList;
    View view;
    RightNowEventArrayAdapter rightNowAdapter;
    EventArrayAdapter eventAdapter;

    Button vibeCheck;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        createEvents();

        viewPager  = view.findViewById(R.id.viewPager);
        createRightNowEvents();

        eventList = (ListView) view.findViewById(R.id.eventlistview);
        eventAdapter = new EventArrayAdapter(getActivity(), R.layout.home_event_adapterv_view_layout, testEvents);
        eventList.setAdapter(eventAdapter);

        vibeCheck = view.findViewById(R.id.eventTxt);
        vibeCheck.setOnClickListener(this);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("tag", "Ligma blaas");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

    private void createRightNowEvents() {
        rightNowTestEvents = new ArrayList<>();

        rightNowTestEvents.add(new EventDTO("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new EventDTO("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new EventDTO("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new EventDTO("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));

        rightNowAdapter = new RightNowEventArrayAdapter(getActivity(), rightNowTestEvents);
        viewPager.setAdapter(rightNowAdapter);

    }

    public void createEvents() {
        EventDTO event1 = new EventDTO("Softball", "3 KM", "10/11/2020", "10:00 - 12:00", R.drawable.bruh) ;
        EventDTO event2 = new EventDTO("Kunst", "1.6 KM", "11/11/2020", "15:00 - 16:00", R.drawable.bruh);
        EventDTO event3 = new EventDTO("Crowd bowling", "2 KM", "11/11/2020", "12:00 - 16:00", R.drawable.bruh);
        EventDTO event4 = new EventDTO("Vin smagning", "3.3 KM", "13/11/2020", "18:00 - 20:00", R.drawable.bruh);
        EventDTO event5 = new EventDTO("Kulturnat", "4 KM", "16/11/2020", "14:00 - 16:00", R.drawable.bruh);
        EventDTO event6 = new EventDTO("Pudekamp", "1.2 KM", "09/11/2020", "12:00 - 13:00", R.drawable.bruh);
        EventDTO event7 = new EventDTO("Nøgenløb", "2.4 KM", "1/11/2020", "14:00 - 16:00", R.drawable.bruh);
        EventDTO event8 = new EventDTO("Mini festival", "3.6 KM", "5/11/2020", "10:00 - 06:00", R.drawable.bruh);

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
        replaceFragment(new HvornaarFragment());
//        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new HvornaarFragment()).addToBackStack(null).commit();
    }
}
