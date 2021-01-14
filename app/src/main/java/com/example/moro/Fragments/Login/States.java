package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;

/**
 * @author s195477, Shania Hau
 */
public interface States {
    //not login
    void signup(Contex contex, String name, String gender, String mail, String password, String bday);
    void alreadyUser(Contex contex, String mail, String password);
    //login
    void editInfo(Contex contex, String name, String gender, String mail, String password, String bday);
    void addFavourites(Contex contex, EventDTO favourites);
    void removeFavourites(Contex contex, EventDTO favourites);
    void showMyFavourites(Contex contex);
}
