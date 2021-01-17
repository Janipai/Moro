package com.example.moro.Fragments.Login;

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
    protected ProfileDTO profileDTO = new ProfileDTO("Brormand", "brormand@brormand.com", "genderfluid", "sejereje123", "04/20/1969", favorites);
    boolean login;

    public static Context getInstance() {
        return ctx;
    }

    private Context() {
        //Logik - find ud af om vi er logget ind
        login = false;
        if(!login)
            state = new NotLoginState();
        else
            state = new LoginState();

        //mere fake data for nu
        EventDTO fakeEvent = new EventDTO("Title", "Distance", "Date", "Timeframe", R.drawable.bruh);
        favorites.add(fakeEvent);
        favorites.add(fakeEvent);
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public void signUp(String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> eventDTOS) {
        state.signUp(this, name, gender, mail, password, bday, eventDTOS);
    }

    public void login(String mail, String password) {
        state.login(this, mail, password);
    }

    public void editInfo(String name, String gender, String mail, String password, String bday) {
        state.editInfo(this, name, gender, mail, password, bday);
    }

    public void addFavourites(EventDTO favourites) {
        state.addFavourites(this, favourites);
    }

    public void removeFavourites(EventDTO favourites) {
        state.removeFavourites(this, favourites);
    }

    public ArrayList<EventDTO> getMyFavourites() {
        return state.getMyFavourites(this);
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
