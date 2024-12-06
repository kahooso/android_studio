package com.example.fifteen;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Note implements Serializable {
    private int id; // Поле id
    private String title;
    private String content;
    private Time time;
    private Date date;

    public Note(int id, String title, String content, Time time, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.date = date;
    }

    public Note(String title, String content, Time time, Date date) {
        this(-1, title, content, time, date);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}