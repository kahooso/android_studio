package com.example.thirteed_lab;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity implements TextWatcher {

    public EditText editText;
    private TextView textView;
    private Button button;

    @Override
    public void onCreate(Bundle savedBundleInstance) {

        super.onCreate(savedBundleInstance);

        setContentView(R.layout.main_act);

        editText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);

        editText.addTextChangedListener(this);

        button.setEnabled(!editText.getText().toString().trim().isEmpty());

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                onButtonClick(view);
            }
        });
    }

    public void onButtonClick(View view) {

        textView.setText(editText.getText().toString());
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        button.setEnabled(!editText.getText().toString().trim().isEmpty());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
