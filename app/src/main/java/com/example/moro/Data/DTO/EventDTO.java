package com.example.moro.Data.DTO;

public class EventDTO {

    private String eventName;
    private String eventGenre;
    private String eventDate;
    private String eventPrice;
    private String eventInfo;
    private int eventImage;

    public EventDTO(String eventName, String eventGenre, String eventDate, String eventPrice, String eventInfo, int eventImage){
        this.eventName = eventName;
        this.eventGenre = eventGenre;
        this.eventDate = eventDate;
        this.eventPrice = eventPrice;
        this.eventInfo = eventInfo;
        this.eventImage = eventImage;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventGenre() {
        return eventGenre;
    }

    public void setEventGenre(String eventGenre) {
        this.eventGenre = eventGenre;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public int getEventImage() {
        return eventImage;
    }

    public void setEventImage(int eventImage) {
        this.eventImage = eventImage;
    }


}
