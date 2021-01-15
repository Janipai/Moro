package com.example.moro.Fragments.Login;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.EventHandler.EventAdapter;
import com.example.moro.R;

import java.util.List;
/**
 * @author s195477, Shania Hau
 */

public class FavouritesFragment extends CustomFragment implements View.OnClickListener {

    List<EventDTO> testEvents;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private ImageButton listView;
    private ImageButton gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_event,container,false);

        listView = v.findViewById(R.id.favoriteListButton);
        listView.setOnClickListener(this);
        listView.setImageResource(R.drawable.ic_listview_filled);
        gridView = v.findViewById(R.id.favoriteGridButton);
        gridView.setOnClickListener(this);

        // Recycler view manager (den layouts bliver smidt ind i)
        recyclerView = (RecyclerView) v.findViewById(R.id.favoriteRecyclerview);
        //recyclerView.setHasFixedSize(true);
        // Liste layout manager
        linearLayoutManager = new LinearLayoutManager(v.getContext());
        // Grid layout manager
        gridLayoutManager = new GridLayoutManager(v.getContext(),2);

        // Sætter default view til recycleren
        recyclerView.setLayoutManager(linearLayoutManager);

        // Sætter adapter til recyclerviewet
        FavouritesEventAdapter myAdapter = new FavouritesEventAdapter( v.getContext(), testEvents, FavouritesEventAdapter.ViewType.VIEW_TYPE_LIST);
        recyclerView.setAdapter(myAdapter);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rigthNowListButton) {
            updateButtonImg(v);
            recyclerView.setLayoutManager(linearLayoutManager);
            EventAdapter adapter = new EventAdapter(v.getContext(),testEvents, EventAdapter.ViewType.VIEW_TYPE_LIST);
            recyclerView.setAdapter(adapter);
        }
        else if (v.getId() == R.id.rigthNowGridButton) {
            updateButtonImg(v);
            recyclerView.setLayoutManager(gridLayoutManager);
            EventAdapter adapter = new EventAdapter(v.getContext(), testEvents, EventAdapter.ViewType.VIEW_TYPE_GRID);
            recyclerView.setAdapter(adapter);
        }
    }

    public void updateButtonImg(View v) {
        if (v.getId() == R.id.rigthNowListButton) {
            listView.setImageResource(R.drawable.ic_listview_filled);
            gridView.setImageResource(R.drawable.ic_gridview_unfilled);
        }
        else if (v.getId() == R.id.rigthNowGridButton) {
            listView.setImageResource(R.drawable.ic_listview_unfilled);
            gridView.setImageResource(R.drawable.ic_gridview_filled);
        }
    }
}