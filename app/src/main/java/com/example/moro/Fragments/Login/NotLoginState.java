package com.example.moro.Fragments.Login;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;

import java.util.ArrayList;
/**
 * @author s195477, Shania Hau
 */
public class NotLoginState extends Adapter {

    ProfileDTO profileDTO;

    @Override
    public void signUp(Context context, String name, String gender, String mail, String password, String bday, ArrayList<EventDTO> eventDTOS) {
        //super.signup(contex, name, gender, mail, password, bday);

        if (name.equals("") ||
                gender.equals("") ||
                mail.equals("") ||
                password.equals("") ||
                bday.equals("")) {

            System.out.println("Du har ikke udfyldt alle felter");
        } else {
            //create user in db
            new ProfileDTO(name, gender, mail, password, bday, eventDTOS);
            context.setStates(new LoginState());
            context.setLogin(true);
        }
    }

    @Override
    public void alreadyUser(Context context, String mail, String password) {
        //hvis mail og password matcher db's info

        if (profileDTO.getProfileEmail().equals(mail) && profileDTO.getProfilePassword().equals(password)) {
            context.setStates(new LoginState());
            context.setLogin(true);
        } else

            System.out.println("mail eller password er forkert");
    }
}
