package com.example.moro.Fragments.BurgerMenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;
/**
 * @author Mikkel Johansen s175194
 */
public class BurgerMenuFragment extends CustomFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_burger_menu, container,false);
        Button tip = (Button) view.findViewById(R.id.menu_tip);
        Button contact = (Button) view.findViewById(R.id.menu_contact);
        Button about = (Button) view.findViewById(R.id.menu_about);

        //adds an onClick listener to our button
        tip.setOnClickListener(this);
        contact.setOnClickListener(this);
        about.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    //initializing our onClick methhod
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
        replaceFragment(fragment);
//        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();
    }
}