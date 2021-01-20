package com.example.moro.Fragments.EventHandler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

/** @author Jacob Christensen S174130
 **/

public class EventDescFragment extends Fragment {

    EventDTO specificEvent;
    ImageView imageIV;
    TextView titleTV, descTV, dateTV, timeTV, priceTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventbeskrivelse, container,false);
        specificEvent = ((MainActivity)this.getActivity()).getOneEvent();

        titleTV = view.findViewById(R.id.EB_Overskrift);
        descTV = view.findViewById(R.id.EB_beskrivelse);
        dateTV = view.findViewById(R.id.EB_dato);
        timeTV = view.findViewById(R.id.EB_tidspunkt);
        priceTV = view.findViewById(R.id.EB_billetpris);
        imageIV = view.findViewById(R.id.EB_Eventbilled);

        System.out.println("EventDescFrag " + specificEvent.getName());

        titleTV.setText(specificEvent.getName());
        descTV.setText(specificEvent.getInfo());
        dateTV.setText(specificEvent.getDate() + "." + Calendar.getInstance().get(Calendar.YEAR));
        timeTV.setText(specificEvent.getTime());
        priceTV.setText(specificEvent.getPrice() + "\n" + "PRIS PÅ BILLET");

        Picasso.get()
                .load(specificEvent.getImage())
                .placeholder(R.drawable.untitled)
                .error(R.drawable.john)
                .fit()
                .noFade()
                .into(imageIV);

        return view;
    }
}