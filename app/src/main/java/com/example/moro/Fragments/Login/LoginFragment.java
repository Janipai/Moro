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
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import java.util.Objects;

public class LoginFragment extends CustomFragment implements View.OnClickListener {

    private CallbackManager callbackManager;
    private LoginButton loginButton;

    Contex ctx = Contex.getInstance();
    EditText emailLogin, passwordLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_login, container, false);
        Button bOP = myView.findViewById(R.id.buttonOpretLogin);
        Button bL = myView.findViewById(R.id.buttonLogin);
        loginButton = myView.findViewById(R.id.fbiIV);
        ImageView gi = myView.findViewById(R.id.giIV);

        callbackManager = CallbackManager.Factory.create();
        emailLogin = myView.findViewById(R.id.emailLogin);
        passwordLogin = myView.findViewById(R.id.passwordLogin);

        bL.setOnClickListener(this);
        bOP.setOnClickListener(this);
        gi.setOnClickListener(this);

        loginButton.setPermissions(Arrays.asList("user_gender, user_birthday"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("Demo","Login succes");
            }

            @Override
            public void onCancel() {
                Log.d("Demo", "Login canceled");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("Demo", "Login error");
            }
        });



        return myView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
    //        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();

    }
}