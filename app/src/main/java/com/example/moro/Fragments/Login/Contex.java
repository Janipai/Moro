package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;

import java.util.List;
/**
 * @author s195477, Shania Hau
 */

public class Contex {
    private States states;
    private static Contex ctx;
    ProfileDTO profileDTO;
    //Some data?

    List<EventDTO> favourites;
    protected String name;
    protected String gender;
    protected String mail;
    protected String password;
    protected String bday;


    public void setName(String name) {this.name = name;}
    public void setGender(String gender) {this.gender = gender;}
    public void setMail(String mail) {this.mail = mail;}
    public void setPassword(String password) {this.password = password;}
    public void setBday(String bday) {this.bday = bday;}


    public static Contex getInstance() {
        return ctx;
    }
    public States getStates() {
        return states;
    }
    public void setStates(States states) {
        this.states = states;
    }

    public List<EventDTO> allMyFavourites(){return favourites;}

    public void signUp(String name, String gender, String mail, String password, String bday) {
        states.signup(this, name, gender,mail,password,bday);
    }

    public void alreadyUser(String mail, String password){
        states.alreadyUser(this, mail, password);
    }

    public void editInfo(String name, String gender, String mail, String password, String bday) {
        states.editInfo(this, name, gender,mail,password,bday);
    }

    public void addFavourites(EventDTO favourite) {
        states.addFavourites(this, favourite);
    }

    public void removeFavourites(EventDTO favourite) {
        states.addFavourites(this, favourite);
    }

    public void showMyFavourites(){
        states.showMyFavourites(this);
    }

}
