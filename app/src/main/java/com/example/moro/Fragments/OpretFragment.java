package com.example.moro.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moro.R;

public class OpretFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_opret, container, false);

        //Creating adapters
        TextView aP = myView.findViewById(R.id.alleredeProfil);
        Button oP = myView.findViewById(R.id.buttonOpretLogin);
        Spinner spinner = myView.findViewById(R.id.genderSpinner);

        aP.setOnClickListener(this);
        oP.setOnClickListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.genderList, android.R.layout.simple_spinner_item);


        //Apply adapter to the spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        return myView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String genderTxt = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), genderTxt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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