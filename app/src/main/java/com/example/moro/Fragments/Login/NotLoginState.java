package com.example.moro.Fragments.Login;

public class NotLoginState extends Adapter {

    @Override
    public void signup(Contex contex, String name, String gender, String mail, String password, String bday) {
        super.signup(contex, name, gender, mail, password, bday);

        if (name.equals("") ||
                gender.equals("") ||
                mail.equals("") ||
                password.equals("") ||
                bday.equals("")){
            System.out.println("Du har ikke udfyldt alle felter");
        }

        else{
            //create user in db
            contex.setStates(new LoginState());
        }
    }

    public void alreadyUser(Contex contex, String mail, String password){
        //hvis mail og password matcher db's info
        if (mail&&password){
            contex.setStates(new LoginState());
        }else
            System.out.println("mail eller password er forkert");
    }
}
