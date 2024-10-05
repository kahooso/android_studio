package com.example.tenth_lab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        Button chooseButton = findViewById(R.id.choose_button);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseColor(view);
            }
        });
    }

    public void chooseColor(View view) {

        Intent intent = new Intent(this, ColorActivity.class);

        startActivity(intent);
    }

    @Override
    protected void onResume() {

        super.onResume();

        SharedPreferences shared_preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);

        int backgroundColor = shared_preferences.getInt("backgroundColor", getResources().getColor(android.R.color.white));

        getWindow().getDecorView().setBackgroundColor(backgroundColor);
    }
}
