package com.example.fifteen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fifteen.R;

public class SecondActivity extends MyBaseActivity {

    private EditText editText;
    private Button okButton;

    private int noteId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        editText = findViewById(R.id.editText);
        okButton = findViewById(R.id.okButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_TEXT)) {
            editText.setText(intent.getStringExtra(EXTRA_TEXT));
            noteId = intent.getIntExtra(EXTRA_ID, -1);
        }

        editText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                okButton.setEnabled(!TextUtils.isEmpty(s.toString().trim()));
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_TEXT, editText.getText().toString());
                resultIntent.putExtra(EXTRA_ID, noteId);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}