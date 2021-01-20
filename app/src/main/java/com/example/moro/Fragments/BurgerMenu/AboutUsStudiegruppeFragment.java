package com.example.moro.Fragments.BurgerMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;

/**@author Mads H */
public class AboutUsStudiegruppeFragment extends CustomFragment {

    public AboutUsStudiegruppeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about_us_a1, container, false);
        TextView aboutUsTxt = v.findViewById(R.id.studiegruppeText);
        aboutUsTxt.setText("Vi er gruppe A1\n" +
                "Jacob K. Christensen s174130\n" +
                "Nikolai Fabricius s195485\n" +
                "Mads Østerlund Hansen s195456\n" +
                "Mikkel Johansen s175194\n" +
                "Shania Hau s195477\n" +
                "Stefan A. Luxhøj s195467");

        return v;
    }
}
