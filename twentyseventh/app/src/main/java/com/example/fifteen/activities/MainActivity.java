package com.example.fifteen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;

import com.example.fifteen.Application;
import com.example.fifteen.Note;
import com.example.fifteen.R;
import com.example.fifteen.adapters.CustomerAdapter;

import java.util.List;

public class MainActivity extends Base {

    private Application application;
    private List<Note> notes;
    private CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        System.out.println("HEY HOW ARE YOU");

        application = (Application) getApplicationContext();
        notes = application.getNotes();

        ListView listView = findViewById(R.id.listView);
        adapter = new CustomerAdapter(this);
        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            startActivityForResult(intent, CREATE_ACTION);
        });

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            intent.putExtra(EXTRA_NOTE, notes.get(position));
            intent.putExtra(EXTRA_ID, position);
            startActivityForResult(intent, EDIT_ACTION);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            Note note = (Note) data.getSerializableExtra(EXTRA_NOTE);

            if (note != null) {
                switch (requestCode) {
                    case CREATE_ACTION:
                        application.addNote(note);
                        break;

                    case EDIT_ACTION:
                        int id = note.getId();
                        if (id != -1) {
                            application.updateNote(id, note);
                        }
                        break;
                }
            }

            notes.clear();
            notes.addAll(application.getNotes());

            adapter.notifyDataSetChanged();
        }
    }
}