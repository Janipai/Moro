package com.example.moro.Data.DTO;

import java.util.ArrayList;


public class ProfileDTO {

    String profileUsername;
    String profileEmail;
    String profileGender;
    String profilePassword;
    String profileDateBorn;
    ArrayList<EventDTO> profileFavourites;


    public ProfileDTO (String username, String email, String gender, String password, String dateborn, ArrayList<EventDTO> favourites) {
        this.profileUsername = username;
        this.profileEmail = email;
        this.profileGender = gender;
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
    public String getProfileEmail() {
        return profileEmail;
    }

    public void setProfileEmail(String profileEmail) {
        this.profileEmail = profileEmail;
    }

    public String getProfileGender() {
        return profileGender;
    }

    public void setProfileGender(String profileGender) {
        this.profileGender = profileGender;
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
