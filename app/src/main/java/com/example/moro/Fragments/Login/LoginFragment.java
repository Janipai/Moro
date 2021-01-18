package com.example.moro.Fragments.Login;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.example.moro.Fragments.CustomFragment;
import com.example.moro.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class LoginFragment extends CustomFragment implements View.OnClickListener {

    private static final String TAG = "LoginFragment";
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    Context ctx = Context.getInstance();
    EditText emailLogin, passwordLogin;
    LoginFragment e = this;
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

    private void SignIn(){
        mAuth.signInWithEmailAndPassword(emailLogin.getText().toString(), passwordLogin.getText().toString())
                .addOnCompleteListener(e.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Context.getInstance().setStates(new LoginState());
                            Toast.makeText(e.getContext(), "User : " + user.getUid() + " logged in",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(e.getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
             case R.id.buttonLogin:
                 SignIn();
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