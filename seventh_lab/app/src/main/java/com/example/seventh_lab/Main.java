package com.example.seventh_lab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

public class Main extends Activity {

    private LinearLayout currentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        currentLinearLayout=findViewById(R.id.main);
        currentLinearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));

        Button openActivityButton = findViewById(R.id.listsViewActivity);

        openActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                open_lists_view_activity();
            }
        });
    }

    private void open_lists_view_activity() {

        Intent intent = new Intent(this, ListsActivity.class);

        startActivity(intent);
    }
}
