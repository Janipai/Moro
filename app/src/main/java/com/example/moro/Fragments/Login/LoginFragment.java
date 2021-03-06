package com.example.moro.Fragments.Login;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.app.Activity;
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

import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.HomeFragment;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

/**
 * @author Nikolai Kristensen s195485
 */
public class LoginFragment extends CustomFragment implements View.OnClickListener {

     //Initializing variables
    private static final String TAG = "LoginFragment";
    public FirebaseAuth mAuth;

    Fragment fragment = null;
    CallbackManager mCallbackManager;
    EditText emailLogin, passwordLogin;
    Button bOP, bL;
    LoginButton loginButton;
    Context ctx = Context.getInstance();
    LoginFragment e = this;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_login, container, false);

        //using xml elements
        bOP = myView.findViewById(R.id.buttonOpretLogin);
        bL = myView.findViewById(R.id.buttonLogin);
        emailLogin = myView.findViewById(R.id.emailLogin);
        passwordLogin = myView.findViewById(R.id.passwordLogin);
        loginButton = myView.findViewById(R.id.login_button);

        bL.setOnClickListener(this);
        bOP.setOnClickListener(this);

        // The following facebook code is made with the help of https://www.youtube.com/channel/UCYLAirIEMMXtWOECuZAtjqQ
        FacebookSdk.sdkInitialize(this.getContext());

        //Initializing firebase
        mAuth = FirebaseAuth.getInstance();

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {

            //If the login success, gets canceled or an error happens
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                Toast.makeText(getActivity(), "Facebook lukket ned", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                Toast.makeText(getActivity(), "Noget gik galt prøv igen", Toast.LENGTH_SHORT).show();
            }
        });
        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is already signed in and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            updateUI(currentUser);
        }

    }

    //Passing results to LoginManger via CallBackManger
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);
        //Using facebooks credential to get users account data
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithCredential:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.getException());
                        Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });
    }

    //Chances login state and chances the fragment
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            ctx.setState(new LoginState());
            replaceFragment(new MyProfile());
        } else {
            Toast.makeText(this.getContext(), "Login for at fortsætte", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * @author Mikkel Johansen s175194
     */
    public void SignIn(){
        mAuth.signInWithEmailAndPassword(emailLogin.getText().toString(), passwordLogin.getText().toString())
                .addOnCompleteListener(e.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Context.getInstance().setState(new LoginState());
                            Toast.makeText(e.getContext(), "User : " + user.getUid() + " logged in",
                                    Toast.LENGTH_SHORT).show();
                            loginSucces(user.getUid());
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(e.getContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.buttonLogin:
                 if (emailLogin.getText().toString().isEmpty()){
                     Toast.makeText(e.getContext(), "Indsæt venligst din email addresse", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if (passwordLogin.getText().toString().isEmpty()){
                     Toast.makeText(getContext(), "Indsæt venligst dit password", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 fragment = new MyProfile();
                 SignIn();
                break;
            case R.id.buttonOpretLogin:
                fragment = new OpretFragment();
                done();
                break;
            case R.id.login_button:

                break;
            default:
                break;
        }
    }

    /**
     * @author Mikkel Johansen s175194
     */
    public void loginSucces(String uid){
        new ProfileDAO().findUserSign(uid,this);
        ctx.setLogin(true);
    }
    public void done(){
        replaceFragment(fragment);
    }
}