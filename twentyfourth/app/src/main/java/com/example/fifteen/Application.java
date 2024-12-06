package com.example.fifteen;

import java.util.ArrayList;
import java.util.List;

public class Application extends android.app.Application {

    private final List<Note> notes = new ArrayList<>();

    @Override
    public void onCreate() {

        super.onCreate();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void setNote(int position, Note note) {
        notes.set(position, note);
    }
}
