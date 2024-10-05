package com.example.tenth_lab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ColorActivity extends Activity {

    private int[] colorValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_act);

        colorValues = getResources().getIntArray(R.array.color_values);
        String[] colorNames = getResources().getStringArray(R.array.color_names);

        ListView listView = findViewById(R.id.list_view);
        ColorAdapter adapter = new ColorAdapter(colorValues, colorNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int selectedColor = colorValues[position];

                SharedPreferences preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("backgroundColor", selectedColor);
                editor.apply();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("selectedColor", selectedColor);
                setResult(RESULT_OK, resultIntent);

                finish();  // Здесь завершение активности теперь логично
            }
        });

    }

    @Override
    protected void onResume() {

        super.onResume();

        SharedPreferences preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);

        int backgroundColor = preferences.getInt("backgroundColor", getResources().getColor(android.R.color.white));

        getWindow().getDecorView().setBackgroundColor(backgroundColor);
    }


}