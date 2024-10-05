package com.example.eleventh;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ColorActivity extends Activity {

    private ColorAdapter color_adapter;

    @Override
    public void onCreate(Bundle savedBundleInstance) {

        super.onCreate(savedBundleInstance);

        setContentView(R.layout.color_act);

        int[] color_codes = getResources().getIntArray(R.array.color_values);
        String[] color_names = getResources().getStringArray(R.array.color_names);

        color_adapter = new ColorAdapter(color_codes, color_names);

        ListView listView = findViewById(R.id.color_list_view);

        listView.setAdapter(color_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int current_color = (int)color_adapter.getItem(i);

                view.setBackgroundColor(current_color);

                SharedPreferences preferences =getSharedPreferences("AppPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("backgroundColor", current_color);
                editor.apply();

                getWindow().getDecorView().setBackgroundColor(current_color);

            }
        });
    }

    @Override
    public void onResume() {

        super.onResume();


        SharedPreferences preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);

        int background_color =preferences.getInt("backgroundColor", getResources().getColor(R.color.white));

        getWindow().getDecorView().setBackgroundColor(background_color);
    }
}
