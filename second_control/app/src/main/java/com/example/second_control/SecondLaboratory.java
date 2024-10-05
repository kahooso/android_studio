package com.example.second_control;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondLaboratory extends Activity {

    //на уровне класса определяем ссылки на TextView и Button, пока эти ссылки пустые
    //здесь мы не можем вызвать метод findViewById, который ищет и возвращает ссылку на объект

    TextView firstTextView, secondTextView;
    Button addButton, copyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_lab_main_act);

        firstTextView = findViewById(R.id.first_text_view);

        secondTextView = findViewById(R.id.second_text_view);

        addButton = findViewById(R.id.first_button);
        copyButton = findViewById(R.id.second_button);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onAdd(view);
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onCopy(view);
            }
        });
    }

    public void onAdd(View view) {
        firstTextView.setText(firstTextView.getText() + "*");
    }

    public void onCopy(View view) {

        secondTextView.setText(firstTextView.getText().toString());
    }
}

