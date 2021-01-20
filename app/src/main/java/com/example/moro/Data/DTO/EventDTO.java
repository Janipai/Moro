package com.example.moro.Data.DTO;

/**
 * @author Jacob Christensen S174130
 **/

public class EventDTO {
    public String name;
    public String genre;
    public String date;
    public String time;
    public String price;
    public String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String address;
    public String image;
    public EventDTO(){}
    public EventDTO(String eventName, String eventGenre, String eventDate, String eventTime, String eventPrice, String eventInfo, String eventAddress, String eventImage){
        this.name = eventName;
        this.genre = eventGenre;
        this.date = eventDate;
        this.time = eventTime;
        this.price = eventPrice;
        this.info = eventInfo;
        this.address = eventAddress;
        this.image = eventImage;
    }
}