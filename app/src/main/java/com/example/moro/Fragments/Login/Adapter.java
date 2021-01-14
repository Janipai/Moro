package com.example.moro.Fragments.Login;

import com.example.moro.Fragments.EventArrayAdapter;

import java.util.ArrayList;

public class Adapter implements States{
    @Override
    public void signup(Contex contex, String name, String gender, String mail, String password, String bday) {

    }

    @Override
    public void alreadyUser(Contex contex, String mail, String password) {

    }

    @Override
    public void editInfo(Contex contex, String name, String gender, String mail, String password, String bday) {

    }

    @Override
    public void addFavourites(Contex contex, EventArrayAdapter favourites) {

    }

    @Override
    public void showMyFavourites(Contex contex, ArrayList<EventArrayAdapter> favourites) {

    }
}
