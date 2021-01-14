package com.example.moro.Fragments.Login;

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
    public void addFavourites() {
        super.addFavourites();
    }

    @Override
    public void showMyFavourites() {
        super.showMyFavourites();
    }
}
