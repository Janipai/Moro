package com.example.moro.Data.DTO;

public class ProfilDTO {

    private String profileName;
    private String profileBirthday;
    private String profileGender;
    private String profileEmail;
    private String profilePassword;

    public ProfilDTO(String profileName, String profileBirthday, String profileGender, String profileEmail, String profilePassword) {
        this.profileName = profileName;
        this.profileBirthday = profileBirthday;
        this.profileGender = profileGender;
        this.profileEmail = profileEmail;
        this.profilePassword = profilePassword;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileBirthday() {
        return profileBirthday;
    }

    public void setProfileBirthday(String profileBirthday) {
        this.profileBirthday = profileBirthday;
    }

    public String getProfileGender() {
        return profileGender;
    }

    public void setProfileGender(String profileGender) {
        this.profileGender = profileGender;
    }

    public String getProfileEmail() {
        return profileEmail;
    }

    public void setProfileEmail(String profileEmail) {
        this.profileEmail = profileEmail;
    }

    public String getProfilePassword() {
        return profilePassword;
    }

    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
    }

}
