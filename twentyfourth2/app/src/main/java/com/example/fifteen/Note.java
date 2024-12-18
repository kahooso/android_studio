package com.example.fifteen;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Note implements Serializable {

    private int id;
    private String title;
    private String content;
    private Time time;
    private Date date;
    private Type type;

    public Note(int id, String title, String content, Time time, Date date, Type type) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.date = date;
        this.type = type;
    }

    public Type getType() {

        return type;
    }

    public void setType(Type type) {

        this.type = type;
    }

    public void setType(String type) {

        switch (type) {

            case "Important":
                this.type = Type.Important;
                break;
            case "Simple":
                this.type = Type.Simple;
                break;
            case "Work":
                this.type = Type.Work;
                break;
            case "Daily":
                this.type = Type.Daily;
                break;
            default:
                this.type = Type.Daily;
        }
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public Time getTime() {

        return time;
    }

    public void setTime(Time time) {

        this.time = time;
    }
}