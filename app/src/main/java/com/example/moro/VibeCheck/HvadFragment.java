package com.example.moro.VibeCheck;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moro.EventHandler.RecyclerViewOnClickListener;
import com.example.moro.MainActivity;
import com.example.moro.R;

import java.util.List;

public class HvadFragment extends Fragment implements View.OnClickListener, RecyclerViewOnClickListener {

    public HvadFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //all the buttons names from hvadFragment
    String[] hvadButtonname = {"Koncert", "Udstilling og kunst",
            "Litteratur", "Film", "comedy",
            "talk", "teater og forestillinger", "fest",
            "gratis", "sport og spil", "mad og drikke", "mode"};

    private RecyclerView recyclerView;
    List<Button> listButtons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for fragment_hvad
        View v = inflater.inflate(R.layout.fragment_hvad, container, false);
        //declare variable
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_hvad);

        //Adapter
        ButtonListAdapter myAdapter = new ButtonListAdapter(this,v.getContext(),listButtons);
        //set the layout to a 3 columns gridlayout
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),3));
        recyclerView.setAdapter(myAdapter);

        //create every buttons based on hvadButtonname
        //createButtons(v);

        final TextView typeText = v.findViewById(R.id.idstemning);
        ImageView arrowDown = v.findViewById(R.id.arrow_down);
        ImageView arrowUp = v.findViewById(R.id.arrow_up);

        typeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NaarFragment naar = new NaarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_fragment_container, naar);
                transaction.commit();
            }
        });

        arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvorFragment hvor = new HvorFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_fragment_container, hvor);
                transaction.commit();
            }
        });

        arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HvornaarFragment hvornaar = new HvornaarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.main_fragment_container, hvornaar);
                transaction.commit();
            }
        });


        return v;
    }


    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new HvorFragment()).addToBackStack(null).commit();
    }


    private void createButtons(final View v) {

        GridLayout.LayoutParams gp = new GridLayout.LayoutParams(v.getLayoutParams());


        //generer 12 knapper (horisonti)
        for (int i = 0; i < hvadButtonname.length; i++) {

            //GridLayout gridLayout = new GridLayout(this.getContext());
            //gridLayout.setLayoutParams(new GridLayout.LayoutParams());

            final Button btn = new Button(this.getContext());
            //sets the id to be the index number
            btn.setId(i);

            //id_ store the current id number
            final int id_ = btn.getId();
            //set the txt in the button to be the index from the array which store the buttontxt
            btn.setText(hvadButtonname[i]);
            //btn.setBackgroundResource(R.drawable.hvad_button_style);

            recyclerView.addView(btn);


            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Toast.makeText(view.getContext(),
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();

                }
            });
        }
    }


    @Override
    public void recyclerViewOnClick(int position) {

    }
}