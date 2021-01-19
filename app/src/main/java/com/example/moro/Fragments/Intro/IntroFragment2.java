package com.example.moro.Fragments.Intro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moro.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IntroFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IntroFragment2 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro2, container, false);
    }
}