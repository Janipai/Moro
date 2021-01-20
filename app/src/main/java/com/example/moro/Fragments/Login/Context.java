package com.example.moro.Fragments.Login;

import androidx.fragment.app.FragmentManager;

import com.example.moro.Data.DTO.EventDTO;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class Context {
    private States state;
    private static final Context ctx = new Context();
    boolean login = false;

    public static Context getInstance() {
        return ctx;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
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
