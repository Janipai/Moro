package com.example.moro.Fragments.Login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;
import com.example.moro.R;

import java.util.ArrayList;


public class MyProfile extends Fragment implements AdapterView.OnItemSelectedListener {

    Context ctx = Context.getInstance();
    ProfileDTO profileDTO;
    EditText name, bday, gender, email, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_min_profil, container, false);

        Spinner spinner = myView.findViewById(R.id.minProfilSpinner);

        name = myView.findViewById(R.id.minProfilNavn);
        bday = myView.findViewById(R.id.minProfilFoeds);
        email = myView.findViewById(R.id.minProfilEmail);
        password = myView.findViewById(R.id.minProfilPassword);

        /*name.setHint(profileDTO.getProfileUsername());
        bday.setHint(profileDTO.getProfileDateBorn());
        gender.setHint(profileDTO.getProfileGender());
        email.setHint(profileDTO.getProfileEmail());
        password.setHint(profileDTO.getProfilePassword());*/

        TextView changeProfileInfo = myView.findViewById(R.id.changeProfileInfo);
        changeProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //doesn't take images

                /*ctx.editInfo(name.getText().toString(),
                        spinner.getSelectedItem().toString(),
                        email.getText().toString(),
                        password.getText().toString(),
                        bday.getText().toString(),
                        profileDTO.getProfileFavourites()
                        );*/
            }
        });


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
}