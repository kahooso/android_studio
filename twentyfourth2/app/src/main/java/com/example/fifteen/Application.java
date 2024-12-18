package com.example.fifteen;

import com.example.fifteen.db.DatabaseHelper;
import java.util.List;

public class Application extends android.app.Application {

    private DatabaseHelper dbHelper;

    @Override
    public void onCreate() {

        super.onCreate();
        dbHelper = new DatabaseHelper(this);
    }

    public void updateNoteById(int id, Note note) {

        dbHelper.updateNote(id, note);
    }

    public List<Note> getNotes() {

        return dbHelper.getAllNotes();
    }

    public void addNote(Note note) {

        dbHelper.addNote(note);
    }

    public void setNote(int position, Note note) {

        List<Note> notes = dbHelper.getAllNotes();
        int noteId = notes.get(position).getId();
        dbHelper.updateNote(noteId, note);
    }

    public void deleteNote(int id) {

        dbHelper.deleteNote(id);
    }

    public void deleteAllNotes() {

        dbHelper.deleteAllNotes();
    }
}