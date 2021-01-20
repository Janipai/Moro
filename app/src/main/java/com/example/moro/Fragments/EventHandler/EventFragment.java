package com.example.moro.Fragments.EventHandler;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;

import java.util.ArrayList;
import java.util.List;


/** @author Jacob Christensen S174130
 * Everything else besides the things Mads has implemented i've implemented instead
 **/


public class EventFragment extends CustomFragment implements View.OnClickListener{

    ArrayList<EventDTO> testEvents;
    List<EventDTO> favouritesEventsList;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private EventAdapter eventAdapter;
    long adapterType;
    View view;
    private ImageButton listView;
    private ImageButton gridView;
    MenuItem searchItem;
    SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event,container,false);

        setHasOptionsMenu(true);
        testEvents = ((MainActivity)this.getActivity()).getAllEvents();
//        setTestEvents(); /* PURELY FOR TESTING PURPOSES*/


        listView = view.findViewById(R.id.rigthNowListButton);
        listView.setOnClickListener(this);
        listView.setImageResource(R.drawable.ic_listview_filled);
        gridView = view.findViewById(R.id.rigthNowGridButton);
        gridView.setOnClickListener(this);

        // Recycler view manager (den layouts bliver smidt ind i)
        recyclerView = (RecyclerView) view.findViewById(R.id.rigthNowrecyclerview);
        recyclerView.setHasFixedSize(true);
        // Liste layout manager
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        // Grid layout manager
        gridLayoutManager = new GridLayoutManager(view.getContext(),2);

        // Sætter default view til recycleren
        recyclerView.setLayoutManager(linearLayoutManager);

        // Sætter adapter til recyclerviewet
        eventAdapter = new EventAdapter(view.getContext(), testEvents, EventAdapter.ViewType.VIEW_TYPE_LIST, adapterInterface);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }

    /** @author Mads H. S195456
     * Layout adapter switching
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rigthNowListButton) {
            updateButtonImg(v);
            recyclerView.setLayoutManager(linearLayoutManager);
            EventAdapter adapter = new EventAdapter(view.getContext(),testEvents, EventAdapter.ViewType.VIEW_TYPE_LIST, adapterInterface);
            recyclerView.setAdapter(adapter);
        }
        else if (v.getId() == R.id.rigthNowGridButton) {
            updateButtonImg(v);
            recyclerView.setLayoutManager(gridLayoutManager);
            EventAdapter adapter = new EventAdapter(view.getContext(), testEvents, EventAdapter.ViewType.VIEW_TYPE_GRID, adapterInterface);
            recyclerView.setAdapter(adapter);
        }
    }

    /** @author Mads H. S195456 */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);

        /* Sætter search ikonet til visible */
        menu.findItem(R.id.menu_top_nav_search).setVisible(true);

        /* Finder menu item id, og sætter derefter searchviewet til items actionView. */
        searchItem = menu.findItem(R.id.menu_top_nav_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setQuery("",false);

        /* Expander automatisk searviewet (Trykket ind) */
        searchView.onActionViewExpanded();

        /* Ændre tastatur tegnet til close */
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        /* Sætter onQueryTextChange hvilket opdaterer hver gang bruger lavet en action i searchviewet (sletter, indsætter bogstav) */
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                searchView.clearFocus();
                getActivity().getCurrentFocus().clearFocus();
                closeKeyboard();
                searchItem.collapseActionView();
//                searchView.onActionViewCollapsed();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                /* Kalder filtrerings metoden fra adapteren */
                eventAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    /** @author Mads H. S195456
     * Simple update of image resources based on what the layout the user is on
     */
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

    /** @author Mads H. S195456
     * Method to close the keyboard.
     */
    private void closeKeyboard() {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    /* Instead of making a query to get one event, i chose to filter the arraylist
    *  based of the data and name which are the most unique for each event
    * */
    public void setOneEvent(String title, String date){
        System.out.println(title + " " + date);
        ArrayList<EventDTO> allEvents = ((MainActivity)this.getActivity()).getAllEvents();
        System.out.println(allEvents.size());
        for (int i = 0; i < allEvents.size(); i++) {
            if(title.equals(allEvents.get(i).getName()) && date.equals(allEvents.get(i).getDate()))
                ((MainActivity)this.getActivity()).setOneEvent(allEvents.get(i));
        }
    }

    /* To pass data between the adapter our fragment i've implemented an interface
    *  which our adapters constructor takes as input

     */
    EventAdapter.InfoAdapterInterface adapterInterface = new EventAdapter.InfoAdapterInterface() {
        @Override
        public void onItemClicked(String title, String date) {
            setOneEvent(title, date);
        }

    };



    /** @author MADS H. - FOR TESTING PURPOSES */
    public long testingLayoutInRecycler() {
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            adapterType = 1;
        }
        else if (layoutManager instanceof LinearLayoutManager) {
            adapterType = 2;
        }
        return adapterType;
    }

    public void setTestEvents() {
        testEvents.add(new EventDTO("bonk","bonkstrong","teest","12","12","bonk","hmnm","image?"));
        testEvents.add(new EventDTO("bonk","bonkstrong","teest","12","12","bonk","hmnm","image?"));
        testEvents.add(new EventDTO("bonk","bonkstrong","teest","12","12","bonk","hmnm","image?"));
    }



}