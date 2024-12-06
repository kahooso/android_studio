package com.example.fifteen;

import java.util.ArrayList;
import java.util.List;

public class Application extends android.app.Application {

    private List<String> notes = new ArrayList<>();

    public Application() {

        super();
    }

    public void addNote(String note) {

        notes.add(note);
    }

    public void setNote(int id, String note) {

        notes.set(id, note);
    }

    public int getNotesCount() {

        return notes.size();
    }

    public String getNote(int id) {

        return notes.get(id);
    }

    public List<String> getNotes() {

        return notes;
    }

    public void setNotes(List<String> notes) {

        this.notes = notes;
    }
}