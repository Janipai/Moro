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
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class FavouritesFragment extends CustomFragment implements View.OnClickListener, FavouritesEventAdapter.EventLister {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private ImageButton listView;
    private ImageButton gridView;
    ArrayList<EventDTO> favouritesEvents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favoritter,container,false);

        listView = v.findViewById(R.id.favoriteListButton);
        listView.setOnClickListener(this);
        listView.setImageResource(R.drawable.ic_listview_filled);
        gridView = v.findViewById(R.id.favoriteGridButton);
        gridView.setOnClickListener(this);



        // Recycler view manager (den layouts bliver smidt ind i)
        recyclerView = (RecyclerView) v.findViewById(R.id.favoriteRecyclerview);
        recyclerView.setHasFixedSize(true);
        // Liste layout manager
        linearLayoutManager = new LinearLayoutManager(v.getContext());
        // Grid layout manager
        gridLayoutManager = new GridLayoutManager(v.getContext(),2);

        // Sætter default view til recycleren
        recyclerView.setLayoutManager(linearLayoutManager);

        // Sætter adapter til recyclerviewet
        favouritesEvents = MainActivity.favouritesEvents;

        FavouritesEventAdapter myAdapter = new FavouritesEventAdapter(getContext(), favouritesEvents, FavouritesEventAdapter.ViewType.VIEW_TYPE_LIST, this);
        recyclerView.setAdapter(myAdapter);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.favoriteListButton) {
            updateButtonImg(v);
            recyclerView.setLayoutManager(linearLayoutManager);
            FavouritesEventAdapter myAdapter = new FavouritesEventAdapter(getContext(), favouritesEvents, FavouritesEventAdapter.ViewType.VIEW_TYPE_LIST, this);
            recyclerView.setAdapter(myAdapter);
        }
        else if (v.getId() == R.id.favoriteGridButton) {
            updateButtonImg(v);
            recyclerView.setLayoutManager(gridLayoutManager);
            FavouritesEventAdapter myAdapter = new FavouritesEventAdapter(getContext(), favouritesEvents, FavouritesEventAdapter.ViewType.VIEW_TYPE_LIST, this);
            recyclerView.setAdapter(myAdapter);
        }
    }

    public void updateButtonImg(View v) {
        if (v.getId() == R.id.favoriteListButton) {
            listView.setImageResource(R.drawable.ic_listview_filled);
            gridView.setImageResource(R.drawable.ic_gridview_unfilled);
        }
        else if (v.getId() == R.id.favoriteGridButton) {
            listView.setImageResource(R.drawable.ic_listview_unfilled);
            gridView.setImageResource(R.drawable.ic_gridview_filled);
        }
    }

    //skal opdatere fragmentet, hver gang nogen events fjernes. (kaldes i favouritesEventAdapter)
    @Override
    public void updateRecyclerView() {
        //testEvents erstattet med ctx.getMyFavourites(), for at hente favorites fra context, som holder styr på brugeren
        // samt recall refrecher fragmenttet

        FavouritesEventAdapter myAdapter = new FavouritesEventAdapter(getContext(), favouritesEvents, FavouritesEventAdapter.ViewType.VIEW_TYPE_LIST, this);
        recyclerView.setAdapter(myAdapter);
    }
}