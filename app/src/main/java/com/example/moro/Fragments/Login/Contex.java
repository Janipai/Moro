package com.example.moro.Fragments.Login;

import com.example.moro.Fragments.EventArrayAdapter;

import java.util.ArrayList;

public class Contex {
    private States states;
    private static Contex ctx;
    //Some data?

    ArrayList<EventArrayAdapter> favourites;
    protected boolean editInfo;
    protected String name;
    protected String gender;
    protected String mail;
    protected String password;
    protected String bday;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getBday() {return bday;}
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

    public boolean isEditInfo() {
        return editInfo;
    }

    public void signUp(String name, String gender, String mail, String password, String bday) {
        states.signup(this, name, gender,mail,password,bday);
    }

    public void alreadyUser(String mail, String password){
        states.alreadyUser(this, mail, password);
    }

    public void editInfo(String name, String gender, String mail, String password, String bday) {
        states.editInfo(this, name, gender,mail,password,bday);
    }

    public void addFavourites(EventArrayAdapter favourites) {
        states.addFavourites(this, favourites);
    }

    public void showMyFavourites(ArrayList<EventArrayAdapter> favourites){
        states.showMyFavourites(this, favourites);
    }

}
