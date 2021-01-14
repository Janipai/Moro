package com.example.moro.Data.DTO;

import java.util.ArrayList;


public class ProfileDTO {

    String profileUsername;
    String profilePassword;
    String profileDateBorn;
    ArrayList<EventDTO> profileFavourites;


    public ProfileDTO (String username, String password, String dateborn, ArrayList<EventDTO> favourites) {
        this.username = username;
        this.password = password;
        this.dateborn = dateborn;
        this.favourites = favourites;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateborn() {
        return dateborn;
    }

    public void setDateborn(String dateborn) {
        this.dateborn = dateborn;
    }

    public ArrayList<EventDTO> getFavourites() {
        return favourites;
    }

    public void setFavourites(ArrayList<EventDTO> favourites) {
        this.favourites = favourites;
    }
}
