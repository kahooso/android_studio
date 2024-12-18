package com.example.fifteen.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fifteen.Note;
import com.example.fifteen.Type;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 3;

    public static final String TABLE_NAME = "notes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TYPE = "type";

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_CONTENT + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TYPE + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addNote(Note note) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TITLE, note.getTitle());
        values.put(COLUMN_CONTENT, note.getContent());
        values.put(COLUMN_TIME, note.getTime().toString());
        values.put(COLUMN_DATE, note.getDate().toString());
        values.put(COLUMN_TYPE, note.getType().toString());

        db.insert(TABLE_NAME, null, values);
    }

    public void updateNote(int id, Note note) {

        System.out.println("Updating Note with ID: " + id);
        System.out.println("New Title: " + note.getTitle());
        System.out.println("New Content: " + note.getContent());
        System.out.println("New Time: " + note.getTime());
        System.out.println("New Date: " + note.getDate());
        System.out.println("New type: " + note.getType());

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TITLE, note.getTitle());
        values.put(COLUMN_CONTENT, note.getContent());
        values.put(COLUMN_TIME, note.getTime().toString());
        values.put(COLUMN_DATE, note.getDate().toString());
        values.put(COLUMN_TYPE, note.getType().toString());

        int rowsAffected = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        System.out.println("Rows Updated: " + rowsAffected);
    }

    public void deleteAllNotes() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    public void deleteNote(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public List<Note> getAllNotes() {

        List<Note> notes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, COLUMN_TIME + " DESC");

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));

                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                String content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT));

                Time time = null;
                Date date = null;

                String timeString = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME));
                if (timeString != null) {

                    try {
                        time = Time.valueOf(timeString);
                    } catch (IllegalArgumentException e) {
                        android.util.Log.e("DatabaseHelper", "Invalid time format: " + timeString, e);
                    }
                }

                String dateString = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE));

                if (dateString != null) {

                    try {

                        date = Date.valueOf(dateString);
                    } catch (IllegalArgumentException e) {

                        android.util.Log.e("DatabaseHelper", "Invalid date format: " + dateString, e);
                    }
                }

                String typeString = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE));
                Type type = Type.Daily;

                try {
                    type = Type.valueOf(typeString);
                } catch (IllegalArgumentException | NullPointerException e) {
                    android.util.Log.e("DatabaseHelper", "Invalid type value: " + typeString, e);
                }

                notes.add(new Note(id, title, content, time, date, type));

            } while (cursor.moveToNext());
        }

        cursor.close();
        return notes;
    }
}