package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class Context {
    private States states;
    private static final Context ctx = new Context();
    ProfileDTO profileDTO;

    boolean login = false;

    public static Context getInstance() {
        return ctx;
    }
    private Context(){
        states = new NotLoginState();
    }
    public States getStates() {return states;}
    public void setStates(States states) {
        this.states = states;
    }

    public void signUp(String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> eventDTOS) {states.signUp(this, name, gender,mail,password,bday,eventDTOS);}
    public void alreadyUser(String mail, String password){states.alreadyUser(this, mail, password);}
    public void editInfo(String name, String gender, String mail, String password, String bday) {states.editInfo(this, name, gender,mail,password,bday);}
    public void addFavourites(String mail, String password, EventDTO favourites) {states.addFavourites(this, mail, password, favourites);}
    public void removeFavourites(String mail, String password, EventDTO favourites) {states.removeFavourites(this, mail, password, favourites);}
    public void showMyFavourites(String mail, String password){states.showMyFavourites(this, mail, password);}

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
