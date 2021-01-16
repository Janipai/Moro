package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;

import java.util.ArrayList;
import java.util.List;
/**
 * @author s195477, Shania Hau
 */

public class Context {
    private States states;
    private static Context ctx;
    ProfileDTO profileDTO;

    public static Context getInstance() {
        if (ctx != null)
            return ctx;
        return ctx = new Context();
    }
    private Context(){
        states = new NotLoginState();
    }
    public States getStates() {
        return states;
    }
    public void setStates(States states) {
        this.states = states;
    }

    public List<EventDTO> allMyFavourites(){return profileDTO.getProfileFavourites();}

    public void signUp(String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> favourites) {
        states.signUp(this, name, gender,mail,password,bday,allMyFavourites());
    }

    public void alreadyUser(String mail, String password){
        states.alreadyUser(this, mail, password);
    }

    public void editInfo(String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> favourites) {
        states.editInfo(this, name, gender,mail,password,bday);
    }

    public void addFavourites(EventDTO favourites) {
        states.addFavourites(this, favourites);
    }

    public void removeFavourites(EventDTO favourites) {
        states.removeFavourites(this, favourites);
    }

    public void showMyFavourites(){
        states.showMyFavourites(this);
    }

}
