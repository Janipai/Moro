package com.example.moro.Data.DTO;

import java.util.ArrayList;


public class ProfileDTO {

    String profileUsername;
    String profileEmail;
    String profileGender;
    String profileDateBorn;
    ArrayList<EventDTO> profileFavourites;


    public ProfileDTO (String username, String email, String gender, String dateborn, ArrayList<EventDTO> favourites) {
        this.profileUsername = username;
        this.profileEmail = email;
        this.profileGender = gender;
        this.profileDateBorn = dateborn;
        this.profileFavourites = favourites;
    }

    public ProfileDTO(){}


    public String getProfileUsername() {
        return profileUsername;
    }

    public void setProfileUsername(String profileUsername) throws Exception {
        if (profileUsername.isEmpty())
            throw new Exception("brugernavn feltet må ikke være tomt");

        this.profileUsername = profileUsername;
    }
    public String getProfileEmail() {
        return profileEmail;
    }

    public void setProfileEmail(String profileEmail) throws Exception {
        if (profileEmail.isEmpty())
            throw new Exception("email feltet må ikke være tomt");
        this.profileEmail = profileEmail;
    }

    public String getProfileGender() {
        return profileGender;
    }

    public void setProfileGender(String profileGender) {
        this.profileGender = profileGender;
    }

    public String getProfileDateBorn() {
        return profileDateBorn;
    }

    public void setProfileDateBorn(String profileDateBorn) throws Exception {
        if (profileDateBorn.isEmpty())
            throw new Exception("fødselsdags feltet må ikke være tomt");
        this.profileDateBorn = profileDateBorn;
    }

    public ArrayList<EventDTO> getProfileFavourites() {
        return profileFavourites;
    }

    public void setProfileFavourites(ArrayList<EventDTO> profileFavourites) {
        this.profileFavourites = profileFavourites;
    }
}
