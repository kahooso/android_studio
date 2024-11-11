package com.example.tenth_lab.activities;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class MyBaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        int backgroundColor = preferences.getInt("backgroundColor", getResources().getColor(android.R.color.white));
        getWindow().getDecorView().setBackgroundColor(backgroundColor);
    }
}
