package com.example.moro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OpretFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_opret, container, false);

        TextView tV = (TextView) myView.findViewById(R.id.alleredeProfil);
        Button oP = (Button) myView.findViewById(R.id.buttonOpretLogin);

        tV.setOnClickListener(this);
        oP.setOnClickListener(this);


        return myView;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
            case R.id.buttonOpretLogin:
                fragment = new HomeFragment();
                break;
            case R.id.alleredeProfil:
                fragment = new LoginFragment();
                break;
        }
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();

    }

}