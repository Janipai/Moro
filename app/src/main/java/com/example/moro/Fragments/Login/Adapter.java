package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;

import java.util.ArrayList;
import java.util.List;
/**
 * @author s195477, Shania Hau
 */

public class Adapter implements States{

    @Override
    public void signUp(Context context, String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> eventDTOS) {

    }

    @Override
    public void alreadyUser(Context context, String mail, String password) {

    }

    @Override
    public void editInfo(Context context, String name, String gender, String mail, String password, String bday) {

    }

    @Override
    public void addFavourites(Context context, String mail, String password, EventDTO favourites) {

    }

    @Override
    public void removeFavourites(Context context, String mail, String password, EventDTO favourites) {

    }

    @Override
    public void showMyFavourites(Context context, String mail, String password) {

    }
}
