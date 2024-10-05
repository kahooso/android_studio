package com.example.second_control;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaskActivity extends Activity {

    @Override
    public void onCreate(Bundle savedBundleInstance) {

        super.onCreate(savedBundleInstance);

        setContentView(R.layout.task_act);

        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackButton(view);
            }
        });
    }

    public void onBackButton(View view) {

        this.onRestart();
    }
}
