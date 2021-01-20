package com.example.moro.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.bekawestberg.loopinglayout.library.LoopingLayoutManager;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.EventHandler.EventAdapter;
import com.example.moro.R;
import com.example.moro.Fragments.VibeCheck.HvornaarFragment;

import java.util.ArrayList;
import java.util.Random;

/** @author Stefan Luxhøj */
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

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        initEvents();
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

    // Method for setting the events to the ArrayList in a random manner.
    private void createRightNowEvents() {
        rightNowTestEvents = new ArrayList<>();
        Random rand = new Random();
        int i = 0;

        while(i < 4) {
            int randomIndex = rand.nextInt(testEvents.size());
            if(!rightNowTestEvents.contains(randomIndex)) {
                rightNowTestEvents.add(testEvents.get(randomIndex));
                i++;
            }
        }
    }


    private void initEvents() {
        testEvents = ((MainActivity)this.getActivity()).getAllEvents();
    }

    // Method so set the layoutmanager and adapters for the recyclerview on the home screen.
    private void initRecyclerViews() {
        LoopingLayoutManager layoutManager = new LoopingLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RightNowRecyclerAdapter adapter = new RightNowRecyclerAdapter(getActivity(), rightNowTestEvents, adapterRightNow);
        EventRecyclerAdapter adapter1 = new EventRecyclerAdapter(getActivity(), testEvents, adapterInterface);

        eventListRecyclerView.setLayoutManager(layoutManager1);
        eventListRecyclerView.setAdapter(adapter1);
        eventListRecyclerView.setNestedScrollingEnabled(false);

        rightNowrecyclerView.setLayoutManager(layoutManager);
        rightNowrecyclerView.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        replaceFragment(new HvornaarFragment());
    }


    /**
     * @author Jacob Christensen
     */
    public void setOneEvent(String title, String date){
        System.out.println(title + " " + date);
        ArrayList<EventDTO> allEvents = ((MainActivity)this.getActivity()).getAllEvents();
        System.out.println(allEvents.size());
        for (int i = 0; i < allEvents.size(); i++) {
            if(title.equals(allEvents.get(i).getName()) && date.equals(allEvents.get(i).getDate()))
                ((MainActivity)this.getActivity()).setOneEvent(allEvents.get(i));
        }
    }
        EventRecyclerAdapter.InfoAdapterInterface adapterInterface = new EventRecyclerAdapter.InfoAdapterInterface() {
            @Override
            public void onItemClicked(String title, String date) {
                setOneEvent(title, date);
            }
        };

        RightNowRecyclerAdapter.InfoAdapterInterface adapterRightNow = new RightNowRecyclerAdapter.InfoAdapterInterface() {
            @Override
            public void onItemClicked(String title, String date) {
                setOneEvent(title, date);
            }
        };
}
