package com.example.moro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.moro.VibeCheck.HvornaarFragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements View.OnClickListener{

    ArrayList<Event> testEvents;
    ArrayList<Event> rightNowTestEvents;

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

        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));
        rightNowTestEvents.add(new Event("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "10:00 - 12:00", R.drawable.resutnat));

        rightNowAdapter = new RightNowEventArrayAdapter(getActivity(), rightNowTestEvents);
        viewPager.setAdapter(rightNowAdapter);

    }

    public void createEvents() {
        Event event1 = new Event("Softball", "3 KM", "10/11/2020", "10:00 - 12:00", R.drawable.bruh) ;
        Event event2 = new Event("Kunst", "1.6 KM", "11/11/2020", "15:00 - 16:00", R.drawable.bruh);
        Event event3 = new Event("Crowd bowling", "2 KM", "11/11/2020", "12:00 - 16:00", R.drawable.bruh);
        Event event4 = new Event("Vin smagning", "3.3 KM", "13/11/2020", "18:00 - 20:00", R.drawable.bruh);
        Event event5 = new Event("Kulturnat", "4 KM", "16/11/2020", "14:00 - 16:00", R.drawable.bruh);
        Event event6 = new Event("Pudekamp", "1.2 KM", "09/11/2020", "12:00 - 13:00", R.drawable.bruh);
        Event event7 = new Event("Nøgenløb", "2.4 KM", "1/11/2020", "14:00 - 16:00", R.drawable.bruh);
        Event event8 = new Event("Mini festival", "3.6 KM", "5/11/2020", "10:00 - 06:00", R.drawable.bruh);

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
