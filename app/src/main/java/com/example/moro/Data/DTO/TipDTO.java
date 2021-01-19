package com.example.moro.Data.DTO;

public class TipDTO {
    String name;
    String where;
    String about;
    String link;
    String when;

    public TipDTO(String name, String where, String about, String link, String when){
        this.name = name;
        this.where = where;
        this.about = about;
        this.link = link;
        this.when = when;
    }

    public TipDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }
}
