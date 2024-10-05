package com.example.seventh_lab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ListsActivity extends Activity implements AdapterView
        .OnItemClickListener {

    private ArrayAdapter<String> first_adapter, second_adapter;

    private ListView first_list, second_list;

    private Button backButton, addFirstButton, addSecondButton;

    private EditText editText;

    private String[] all_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.lists_activity_act);

        backButton = findViewById(R.id.backButton);

        addFirstButton = findViewById(R.id.add_first_list);

        addSecondButton = findViewById(R.id.add_second_list);

        editText = findViewById(R.id.edit_text);

        first_list = findViewById(R.id.first_list_view);
        second_list = findViewById(R.id.second_list_view);

        first_adapter = new ArrayAdapter<String>(this, R.layout.le);
        second_adapter = new ArrayAdapter<String>(this, R.layout.le);

        first_list.setAdapter(first_adapter);
        second_list.setAdapter(second_adapter);

        all_items = getResources().getStringArray(R.array.first_list_xml);
        first_adapter.addAll(all_items);

        all_items = getResources().getStringArray(R.array.second_list_xml);
        second_adapter.addAll(all_items);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackButton(view);
            }
        });

        addFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onFirstListAddButton(view);
            }
        });

        addSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onSecondListAddButton(view);
            }
        });
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void onFirstListAddButton(View view) {

        String current_string = editText.getText().toString();
        if (!current_string.isEmpty())
            first_adapter.add(editText.getText().toString());
    }

    public void onSecondListAddButton(View view) {

        String current_string = editText.getText().toString();
        if (!current_string.isEmpty())
            second_adapter.add(editText.getText().toString());
    }


    public void onBackButton(View view) {

        onBackPressed();
    }
}
