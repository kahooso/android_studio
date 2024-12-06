package com.example.fifteen;

import com.example.fifteen.db.DatabaseHelper;

import java.util.List;

public class Application extends android.app.Application {

    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseHelper = new DatabaseHelper(this);
    }

    public void deleteNote(int id)            {    databaseHelper.deleteNote(id);          }
    public List<Note> getNotes()              {    return databaseHelper.getAllNotes();    }
    public void addNote(Note note)            {    databaseHelper.addNote(note);           }
    public void updateNote(int id, Note note) {    databaseHelper.updateNote(id, note);    }
}