package com.example.fifteen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fifteen.Note;
import com.example.fifteen.R;

import java.sql.Time;

public class SecondActivity extends MyBaseActivity {

    private EditText editTitle;
    private EditText editContent;
    private TextView textTime;
    private Button okButton;

    private int noteId = -1;
    private Note currentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        textTime = findViewById(R.id.textTime);
        okButton = findViewById(R.id.okButton);
        okButton.setEnabled(false);
        Button cancelButton = findViewById(R.id.cancelButton);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_NOTE)) {
            currentNote = (Note) intent.getSerializableExtra(EXTRA_NOTE);
            noteId = intent.getIntExtra(EXTRA_ID, -1);
            editTitle.setText(currentNote.getTitle());
            editContent.setText(currentNote.getContent());
            textTime.setText(new Time(System.currentTimeMillis()).toString());
        } else {
            currentNote = new Note(0, "", "", new Time(System.currentTimeMillis()));
            textTime.setText(currentNote.getTime().toString());
        }

        TextWatcher watcher = new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                okButton.setEnabled(!TextUtils.isEmpty(editTitle.getText()) && !TextUtils.isEmpty(editContent.getText()));
            }

            @Override
            public void afterTextChanged(android.text.Editable editable) {
            }
        };

        editTitle.addTextChangedListener(watcher);
        editContent.addTextChangedListener(watcher);

        okButton.setOnClickListener(view -> {
            String title = editTitle.getText().toString();
            String content = editContent.getText().toString();
            Time time = new Time(System.currentTimeMillis());

            currentNote.setTitle(title);
            currentNote.setContent(content);
            currentNote.setTime(time);

            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_NOTE, currentNote);
            resultIntent.putExtra(EXTRA_ID, noteId);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        cancelButton.setOnClickListener(view -> finish());
    }
}