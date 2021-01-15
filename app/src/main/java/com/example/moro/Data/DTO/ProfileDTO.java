package com.example.moro.Data.DTO;

import java.util.ArrayList;


public class ProfileDTO {

    String profileUsername;
    String profilePassword;
    String profileDateBorn;
    ArrayList<EventDTO> profileFavourites;


    public ProfileDTO (String username, String password, String dateborn, ArrayList<EventDTO> favourites) {
        this.profileUsername = username;
        this.profilePassword = password;
        this.profileDateBorn = dateborn;
        this.profileFavourites = favourites;
    }


    public String getProfileUsername() {
        return profileUsername;
    }

    public void setProfileUsername(String profileUsername) {
        this.profileUsername = profileUsername;
    }

    public String getProfilePassword() {
        return profilePassword;
    }

    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
    }

    public String getProfileDateBorn() {
        return profileDateBorn;
    }

    public void setProfileDateBorn(String profileDateBorn) {
        this.profileDateBorn = profileDateBorn;
    }

    public ArrayList<EventDTO> getProfileFavourites() {
        return profileFavourites;
    }

    public void setProfileFavourites(ArrayList<EventDTO> profileFavourites) {
        this.profileFavourites = profileFavourites;
    }
}
