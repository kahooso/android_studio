package com.example.anew;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Main extends Activity implements AdapterView

        .OnItemClickListener {

    private EditText first_number, second_number;

    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        Button multiply = findViewById(R.id.multiple_button);
        Button divide = findViewById(R.id.divide);
        Button plus = findViewById(R.id.plus_button);
        Button minus = findViewById(R.id.minus_button);
        Button clear = findViewById(R.id.clear_button);

        adapter = new ArrayAdapter<String>(this, R.layout.le);

        first_number = findViewById(R.id.first_edit_text);
        second_number = findViewById(R.id.second_edit_text);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiple(view);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus(view);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divide(view);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minus(view);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear(view);
            }
        });
    }

    public void minus(View view) {

        int first_num = Integer.parseInt(first_number.getText().toString());
        int second_num = Integer.parseInt(second_number.getText().toString());

        adapter.add(String.valueOf(first_num - second_num) + " = " + String.valueOf(first_num) + " - " + String.valueOf(second_num));
    }

    public void plus(View view) {

        int first_num = Integer.parseInt(first_number.getText().toString());
        int second_num = Integer.parseInt(second_number.getText().toString());

        adapter.add(String.valueOf(first_num + second_num) + " = " + String.valueOf(first_num) + " + " + String.valueOf(second_num));
    }

    public void multiple(View view) {

        int first_num = Integer.parseInt(first_number.getText().toString());
        int second_num = Integer.parseInt(second_number.getText().toString());

        adapter.add(String.valueOf(first_num * second_num) + " = " + String.valueOf(first_num) + " * " + String.valueOf(second_num));
    }

    public void divide(View view) {

        int first_num = Integer.parseInt(first_number.getText().toString());
        int second_num = Integer.parseInt(second_number.getText().toString());

        if (second_num == 0) {

            return;
        }

        adapter.add(String.valueOf(first_num / second_num) + " = " + String.valueOf(first_num) + " / " + String.valueOf(second_num));
    }

    public void clear(View view) {

        adapter.clear();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
