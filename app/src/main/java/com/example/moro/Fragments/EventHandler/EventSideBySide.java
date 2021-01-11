package com.example.moro.Fragments.EventHandler;

public class EventSideBySide {

    private String title;
    private String distance;
    private String date;
    private String timeframe;
    private int image;

    public EventSideBySide(String title, String distance, String date, String timeframe, int image) {
        this.title = title;
        this.distance = distance;
        this.date = date;
        this.timeframe = timeframe;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



}
