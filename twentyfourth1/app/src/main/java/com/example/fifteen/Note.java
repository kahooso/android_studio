package com.example.fifteen;

import java.io.Serializable;
import java.sql.Time;

public class Note implements Serializable {
    private int id;
    private String title;
    private String content;
    private Time time;

    public Note(int id, String title, String content, Time time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
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