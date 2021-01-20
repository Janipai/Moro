package com.example.moro.Fragments.Intro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.HomeFragment;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;

/** @author s195467 Stefan Luxhøj */
public class IntroFragment3 extends CustomFragment {

    TextView doneTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_intro3, container, false);

      doneTV = view.findViewById(R.id.Intro3Done);

      doneTV.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new HomeFragment()).commit();
          }
      });

      return view;
    }
}