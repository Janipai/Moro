package com.example.moro.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.moro.R;

public class ContactFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container,false);
        ImageView face = (ImageView) view.findViewById(R.id.facebook_link);
        ImageView insta = (ImageView) view.findViewById(R.id.instagram_link);
        ImageView linkin = (ImageView) view.findViewById(R.id.linked_in_link);
        Button tipButton = (Button) view.findViewById(R.id.tipButton);
        tipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new TipFragment()).addToBackStack(null).commit();
            }
        });

        //the imageview button listeners initialized
        face.setOnClickListener(this);
        insta.setOnClickListener(this);
        linkin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent browser = null;
        switch (v.getId()){
            case R.id.facebook_link: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://Facebook.com")); break;
            case R.id.instagram_link: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://Instagram.com")); break;
            case R.id.linked_in_link: browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://linkedin.com")); break;
        }
        startActivity(browser);
    }
}