package com.example.second_lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    TextView textView1, textView2;
    Button addButton, copyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        textView1 = findViewById(R.id.first_text_view);
        textView2 = findViewById(R.id.second_text_view);

        addButton = findViewById(R.id.add_button);
        copyButton = findViewById(R.id.copy_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click_add(view);
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click_copy(view);
            }
        });

    }

    public void on_click_add(View view) {

        String string = textView1.getText().toString();
        string += "*";

        textView1.setText(string);
    }

    public void on_click_copy(View view) {
        textView2.setText(textView1.getText().toString());
    }
}
