package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;
import java.util.List;
/**
 * @author s195477, Shania Hau
 */

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
    public void addFavourites(Contex contex, EventDTO favourites) {
        //super.addFavourites(contex, favourites);

        contex.favourites.add(favourites);
    }

    @Override
    public void removeFavourites(Contex contex, EventDTO favourites) {
        //super.addFavourites(contex, favourites);

        contex.favourites.remove(favourites);
    }

    @Override
    public void showMyFavourites(Contex contex) {
        //super.showMyFavourites(contex, favourites);

        contex.allMyFavourites();
    }
}
