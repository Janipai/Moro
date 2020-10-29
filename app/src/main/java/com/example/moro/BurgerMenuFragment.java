package com.example.moro;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BurgerMenuFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_burger_menu, container,false);
        Button tip = (Button) view.findViewById(R.id.menu_tip);
        Button contact = (Button) view.findViewById(R.id.menu_contact);
        Button about = (Button) view.findViewById(R.id.menu_about);

        tip.setOnClickListener(this);
        contact.setOnClickListener(this);
        about.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.menu_about:
                fragment = new AboutUsFragment();
                break;
            case R.id.menu_tip:
                fragment = new TipFragment();
                break;
            case R.id.menu_contact:
                fragment = new ContactFragment();
                break;
        }
        //FragmentManager fragmentManager = myContext.getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.main_fragment_container, fragment).commit();
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).commit();
    }
}