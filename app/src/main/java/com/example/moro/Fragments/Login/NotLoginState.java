package com.example.moro.Fragments.Login;

import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;

import java.util.ArrayList;
/**
 * @author s195477, Shania Hau
 */
public class NotLoginState extends Adapter {

    ProfileDTO profileDTO;
    ProfileDAO profileDAO;

    //intet tjek for om mailen findes
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
            ProfileDTO newProfile = new ProfileDTO(name, gender, mail, password, bday, eventDTOS);
            //gemmer den nye profil i vores context
            context.profileDTO = newProfile;
            //create user in db, does not take care of mail that doesnt exist
            //profileDAO.createUser(newProfile);
            context.setState(new LoginState());
            context.setLogin(true);
        }
    }

    @Override
    public void login(Context context, String mail, String password) {
        //skal tjekke for om mail og password matcher db's info
        //ingen validering pt.

        if (profileDTO.getProfileEmail().equals(mail) && profileDTO.getProfilePassword().equals(password)) {
            ProfileDTO newProfile = new ProfileDTO(profileDTO.getProfileUsername(),
                    profileDTO.getProfileGender(),
                    mail, password,
                    profileDTO.getProfileDateBorn(),
                    profileDTO.getProfileFavourites());
            context.profileDTO = newProfile;
            context.setState(new LoginState());
            context.setLogin(true);
        } else
            System.out.println("mail eller password er forkert");
    }
}
