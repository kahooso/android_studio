package com.example.tenth_lab.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tenth_lab.R;

public class ThirdActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_act);

        Intent intent = getIntent();

        Button backButton = findViewById(R.id.back_button);

        int selectedColor = intent.getIntExtra("selectedColor", getResources().getColor(android.R.color.white));

        getWindow().getDecorView().setBackgroundColor(selectedColor);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackButton(view);
            }
        });
    }

    public void onBackButton(View view) {

        onBackPressed();
    }
}

