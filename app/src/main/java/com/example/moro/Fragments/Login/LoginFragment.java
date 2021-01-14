package com.example.moro.Fragments.Login;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;

import java.util.Arrays;
import java.util.Objects;

public class LoginFragment extends CustomFragment implements View.OnClickListener {


    Contex ctx = Contex.getInstance();
    EditText emailLogin, passwordLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_login, container, false);
        Button bOP = myView.findViewById(R.id.buttonOpretLogin);
        Button bL = myView.findViewById(R.id.buttonLogin);


        emailLogin = myView.findViewById(R.id.emailLogin);
        passwordLogin = myView.findViewById(R.id.passwordLogin);

        bL.setOnClickListener(this);
        bOP.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
             case R.id.buttonLogin:
                 ctx.alreadyUser(emailLogin.getText().toString(),passwordLogin.getText().toString());
                fragment = new MyProfile();
                break;
            case R.id.buttonOpretLogin:
                fragment = new OpretFragment();
                break;
            case R.id.giIV:
                //Log in med google
                break;
            case R.id.fbiIV:
                //Log in med facebook
                break;
            default:
                break;
        }
        replaceFragment(fragment);

    }
}