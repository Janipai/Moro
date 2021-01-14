package com.example.moro.Fragments.Login;

import com.example.moro.Fragments.EventArrayAdapter;

import java.util.ArrayList;

public class LoginState extends Adapter {

    @Override
    public void editInfo(Contex contex, String name, String gender, String mail, String password, String bday) {
        //do we need super?
        super.editInfo(contex, name, gender, mail, password, bday);

        contex.setName(name);
        contex.setGender(gender);
        contex.setMail(mail);
        contex.setPassword(password);
        contex.setBday(bday);
    }

    @Override
    public void addFavourites(Contex contex, EventArrayAdapter favourites) {
        super.addFavourites(contex, favourites);
    }

    @Override
    public void showMyFavourites(Contex contex, ArrayList<EventArrayAdapter> favourites) {
        super.showMyFavourites(contex, favourites);
    }
}
