package com.example.sixth_lab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends Activity {

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.third_act);

        backButton = findViewById(R.id.third_activity_back_button);

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
