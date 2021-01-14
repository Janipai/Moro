package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class LoginState extends Adapter {

    ProfileDTO profileDTO;

    public void editInfo(Context context, String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> favourites) {
        //do we need super?
        //super.editInfo(context, name, gender, mail, password, bday);

        profileDTO.setProfileUsername(name);
        profileDTO.setProfileGender(gender);
        profileDTO.setProfileEmail(mail);
        profileDTO.setProfilePassword(password);
        profileDTO.setProfileDateBorn(bday);
        profileDTO.setProfileFavourites(favourites);
    }

    public void addFavourites(Context context, EventDTO favourites) {
        //super.addFavourites(contex, favourites);
        //context.favourites.add(favourites);

        profileDTO.getProfileFavourites().add(favourites);
    }

    public void removeFavourites(Context context, EventDTO favourites) {
        //super.addFavourites(contex, favourites);
        //context.favourites.remove(favourites);

        profileDTO.getProfileFavourites().remove(favourites);
    }

    @Override
    public void showMyFavourites(Context context) {
        //super.showMyFavourites(contex, favourites);
        //context.allMyFavourites();

        profileDTO.getProfileFavourites();
    }
}
