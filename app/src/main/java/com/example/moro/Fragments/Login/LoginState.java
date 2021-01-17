package com.example.moro.Fragments.Login;

import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class LoginState extends Adapter {

    @Override
    public void editInfo(Context context, String name, String gender, String mail, String password, String bday) {
        //super.editInfo(context, name, gender, mail, password, bday);

        //gets the user from context
        context.profileDTO.setProfileUsername(name);
        context.profileDTO.setProfileGender(gender);
        context.profileDTO.setProfileEmail(mail);
        context.profileDTO.setProfilePassword(password);
        context.profileDTO.setProfileDateBorn(bday);

        //Update database
        //profileDAO.saveProfile(profileDTO);
    }

    @Override
    public void addFavourites(Context context, EventDTO favourites) {
        //super.addFavourites(contex, favourites);

        context.profileDTO.getProfileFavourites().add(favourites);

        //Update database
        //profileDAO.saveProfile(profileDTO);
    }

    @Override
    public void removeFavourites(Context context, EventDTO favourites) {
        //super.addFavourites(contex, favourites);

        context.profileDTO.getProfileFavourites().remove(favourites);

        //Update database
        //profileDAO.saveProfile(profileDTO);
    }

    @Override
    public ArrayList<EventDTO> getMyFavourites(Context context) {
        //super.showMyFavourites(contex, favourites);

        return context.profileDTO.getProfileFavourites();
    }
}
