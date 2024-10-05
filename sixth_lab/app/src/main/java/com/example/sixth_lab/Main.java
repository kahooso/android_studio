package com.example.sixth_lab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

    private Button secondActivity, thirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        secondActivity = findViewById(R.id.first_activity);

        thirdActivity = findViewById(R.id.second_activity);

        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_second_activity();
            }
        });

        thirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_third_activity();
            }
        });
    }

    public void open_second_activity() {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void open_third_activity() {

        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
