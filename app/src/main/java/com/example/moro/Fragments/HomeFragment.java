package com.example.moro.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.bekawestberg.loopinglayout.library.LoopingLayoutManager;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.Intro.IntroFragmentContainer;
import com.example.moro.R;
import com.example.moro.Fragments.VibeCheck.HvornaarFragment;

import java.util.ArrayList;


public class HomeFragment extends CustomFragment implements View.OnClickListener{

    ArrayList<EventDTO> testEvents;
    ArrayList<EventDTO> rightNowTestEvents;

    ViewPager viewPager;
    RecyclerView eventListRecyclerView;
    RecyclerView rightNowrecyclerView;
    View view;

    Button vibeCheck;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,container,false);

        createEvents();
        createRightNowEvents();

        eventListRecyclerView = (RecyclerView) view.findViewById(R.id.eventlistview);
        rightNowrecyclerView = (RecyclerView) view.findViewById(R.id.homeRecyclerview);
        SnapHelper snapper = new LinearSnapHelper();
        snapper.attachToRecyclerView(rightNowrecyclerView);
        initRecyclerViews();


        vibeCheck = view.findViewById(R.id.eventTxt);
        vibeCheck.setOnClickListener(this);


        return view;
    }

    private void createRightNowEvents() {
        rightNowTestEvents = new ArrayList<>();

        rightNowTestEvents.add(new EventDTO("Sovsedyp på Resturant Saltvand", "0", "01/01/2021", "12:00 - 13:00", R.drawable.resutnat));
        rightNowTestEvents.add(new EventDTO("Gourmet buffet", "0", "01/01/2021", "17:00 - 19:00", R.drawable.buffet));
        rightNowTestEvents.add(new EventDTO("Modeshow på Reffen", "0", "01/01/2021", "12:00 - 14:00", R.drawable.fashionshow));
        rightNowTestEvents.add(new EventDTO("John Dillermand Show", "0", "01/01/2021", "16:00 - 18:00", R.drawable.john));

    }

    private void initRecyclerViews() {
        LoopingLayoutManager layoutManager = new LoopingLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RightNowRecyclerAdapter adapter = new RightNowRecyclerAdapter(getActivity(), rightNowTestEvents);
        EventRecyclerAdapter adapter1 = new EventRecyclerAdapter(getActivity(), testEvents);

        eventListRecyclerView.setLayoutManager(layoutManager1);
        eventListRecyclerView.setAdapter(adapter1);
        eventListRecyclerView.setNestedScrollingEnabled(false);

        rightNowrecyclerView.setLayoutManager(layoutManager);
        rightNowrecyclerView.setAdapter(adapter);



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
