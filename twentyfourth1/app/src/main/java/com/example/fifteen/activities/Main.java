package com.example.fifteen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.fifteen.Application;
import com.example.fifteen.Note;
import com.example.fifteen.R;
import com.example.fifteen.adapters.CustomerAdapter;

import java.util.List;

public class Main extends MyBaseActivity {

    private Application application;
    private List<Note> notes;
    private CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        application = (Application) getApplicationContext();
        notes = application.getNotes();

        ListView listView = findViewById(R.id.listView);
        adapter = new CustomerAdapter(this, notes);
        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this, SecondActivity.class);
            startActivityForResult(intent, CREATE_ACTION);
        });

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(Main.this, SecondActivity.class);
            intent.putExtra(EXTRA_NOTE, notes.get(position));
            intent.putExtra(EXTRA_ID, notes.get(position).getId());
            startActivityForResult(intent, EDIT_ACTION);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Note note = (Note) data.getSerializableExtra(EXTRA_NOTE);
            switch (requestCode) {
                case CREATE_ACTION:
                    application.addNote(note);
                    break;
                case EDIT_ACTION:
                    int noteId = data.getIntExtra(EXTRA_ID, -1);
                    if (noteId != -1) {
                        application.setNote(noteId, note);
                    }
                    break;
            }

            notes = application.getNotes();

            adapter.setNotes(notes);
        }
    }
}