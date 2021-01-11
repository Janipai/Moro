package com.example.moro.Fragments;

public class Event {
    private String title;
    private String distance;
    private String date;
    private String timeframe;

    public Event(String title, String distance, String date, String timeframe) {
        this.title = title;
        this.distance = distance;
        this.date = date;
        this.timeframe = timeframe;
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
}
