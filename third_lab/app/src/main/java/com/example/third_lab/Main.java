package com.example.third_lab;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private LinearLayout linearLayout;
    TextView textView1, textView2;
    Button redButton, blackButton, blueButton;
    Button redGreenButton, blackWhiteButton, yellowBlueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        textView1 = findViewById(R.id.first_text_view);
        textView2 = findViewById(R.id.second_text_view);

        redButton = findViewById(R.id.red);
        blueButton = findViewById(R.id.blue);
        blackButton = findViewById(R.id.black);

        redGreenButton = findViewById(R.id.red_green);
        blackWhiteButton = findViewById(R.id.black_white);
        yellowBlueButton = findViewById(R.id.yellow_blue);

        linearLayout = (LinearLayout)findViewById(R.id.main);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShort(view);
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShort(view);
            }
        });

        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShort(view);
            }
        });

        redGreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLong(view);
            }
        });

        yellowBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLong(view);
            }
        });

        blackWhiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLong(view);
            }
        });
    }

    public void onClickShort(View view) {
        Button current_button = (Button) view;

        linearLayout.setBackground(view.getBackground());
    }

    public void onClickLong(View view) {
        Button current_button = (Button)view;

        textView1.setBackground(current_button.getBackground());
        textView1.setTextColor(current_button.getCurrentTextColor());

        textView2.setBackground(current_button.getBackground());
        textView2.setTextColor(current_button.getCurrentTextColor());
    }
}
