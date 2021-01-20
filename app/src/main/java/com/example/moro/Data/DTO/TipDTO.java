package com.example.moro.Data.DTO;
/**
 * @author Mikkel Johansen s175194
 */
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

    public void setName(String name) throws Exception {
        if (name.isEmpty())
            throw new Exception("Event navn feltet må ikke være tomt!");
        this.name = name;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) throws Exception {
        if (where.isEmpty())
            throw new Exception("Event Addresse feltet må ikke være tomt!");
        this.where = where;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) throws Exception {
        if (about.isEmpty())
            throw new Exception("Om Event feltet må ikke være tomt!");
        this.about = about;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) throws Exception {
        if (link.isEmpty())
            throw new Exception("Event link feltet må ikke være tomt!");
        this.link = link;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) throws Exception {
        if (when.isEmpty())
            throw new Exception("Event dato feltet må ikke være tomt!");
        this.when = when;
    }
}
