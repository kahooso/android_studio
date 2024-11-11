package com.example.tenth_lab.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tenth_lab.R;

public class Main extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        Button thirdActButton = findViewById(R.id.third_button);

        Button chooseButton = findViewById(R.id.choose_button);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseColor();
            }
        });

        thirdActButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                onThirdActButton(view);
            }
        });
    }

    public void onThirdActButton(View view) {

        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void chooseColor() {

        Intent intent = new Intent(this, ColorActivity.class);
        startActivity(intent);
    }
}
