package com.example.eleventh;

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

        Button openColorActivity = findViewById(R.id.color_button);

        openColorActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                openColorActivity(view);
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    public void openColorActivity(View view) {

        startActivity(new Intent(this, ColorActivity.class));
    }
}
