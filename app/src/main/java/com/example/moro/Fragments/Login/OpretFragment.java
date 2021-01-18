package com.example.moro.Fragments.Login;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.HomeFragment;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class OpretFragment extends CustomFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Context ctx = Context.getInstance();
    EditText nameProfile, bdayProfile, emailProfile, passwordProfile;
    Spinner spinner;

    OpretFragment e = this;
    private static final String TAG = "OpretFragment";
    EditText nameProfile, bdayProfile, genderProfile, emailProfile, passwordProfile;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_opret, container, false);

        nameProfile = myView.findViewById(R.id.nameProfil);
        bdayProfile = myView.findViewById(R.id.bdayProfile);
        emailProfile = myView.findViewById(R.id.emailProfil);
        passwordProfile = myView.findViewById(R.id.passwordProfil);


        //Creating adapters
        TextView aP = myView.findViewById(R.id.alleredeProfil);
        Button oP = myView.findViewById(R.id.buttonOpretLogin);
        spinner = myView.findViewById(R.id.genderSpinner);

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
                //mangler noget validering
                ctx.createUserPressed();
                fragment = new HomeFragment();
                //fragment = new HomeFragment();
                signUp();
                break;
            case R.id.alleredeProfil:
                fragment = new LoginFragment();
                break;
        }
        replaceFragment(fragment);

    }

    private void signUp() {
        mAuth.createUserWithEmailAndPassword(emailProfile.getText().toString(), passwordProfile.getText().toString())
                .addOnCompleteListener(e.getActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Context.getInstance().setStates(new LoginState());
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(e.getContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                    // ...
                });
    }
}