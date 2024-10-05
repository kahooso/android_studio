package com.example.second_control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedBundleInstance) {

        super.onCreate(savedBundleInstance);

        setContentView(R.layout.main_act);

        Button onTask = findViewById(R.id.onTaskButton);

        Button onLabEight = findViewById(R.id.onLabEight);

        Button onSecondLab = findViewById(R.id.onSecondLab);

        onTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onTaskButton(view);
            }
        });

        onSecondLab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onSecondLab(view);
            }
        });

        onLabEight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onLabEight(view);
            }
        });
    }

    public void onTaskButton(View view) {

        startActivity(new Intent(this, TaskActivity.class));
    }

    public void onLabEight(View view) {

        startActivity(new Intent(this, ListActivity.class));
    }

    public void onSecondLab(View view) {

        startActivity(new Intent(this, SecondLaboratory.class));
    }

}
