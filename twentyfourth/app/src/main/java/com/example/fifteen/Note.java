package com.example.fifteen;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    private String title;
    private String content;
    private Time time;

    public Note(String title, String content, Time time) {
        this.title = title;
        this.content = content;
        this.time = new Time(System.currentTimeMillis());
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