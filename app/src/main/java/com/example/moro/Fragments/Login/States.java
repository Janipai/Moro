package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */
public interface States {
    //not login
    void signUp(Context context, String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> eventDTOS);
    void alreadyUser(Context context, String mail, String password);
    //login
    void editInfo(Context context, String name, String gender, String mail, String password, String bday);
    void addFavourites(Context context, String mail, String password, EventDTO favourites);
    void removeFavourites(Context context, String mail, String password, EventDTO favourites);
    void showMyFavourites(Context context, String mail, String password);
}
