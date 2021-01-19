package com.example.moro.Fragments.Intro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;

public class IntroFragmentContainer extends Fragment {

    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_container, container, false);
        viewPager = view.findViewById(R.id.introViewPager);
        IntroAdapter IA = new IntroAdapter(getChildFragmentManager());
        viewPager.setAdapter(IA);
        return view;
    }
}