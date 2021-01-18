package com.example.moro.Fragments.Login;

import androidx.fragment.app.FragmentManager;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;
import com.example.moro.R;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class Context {
    private States state;
    private static final Context ctx = new Context();
    protected ArrayList<EventDTO> favorites = new ArrayList<>();
    //fake data for nu
    boolean login = true;

    public static Context getInstance() {
        return ctx;
    }

    /*private Context() {
        //Logik - find ud af om vi er logget ind
        if (!login)
            state = new NotLoginState();
        else
            state = new LoginState();

    }
    */

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public void createUserPressed() {
        state.createUserPressed(this);
    }

    public void profilePressed(FragmentManager fragmentManager) {
        state.profilePressed(this, fragmentManager);
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public void favouritFragment(FragmentManager fragmentManager) {
        state.favouriteFragment(this, fragmentManager);
    }
}
