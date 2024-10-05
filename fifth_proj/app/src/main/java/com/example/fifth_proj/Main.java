package com.example.fifth_proj;

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

    private ArrayAdapter<String> adapter;

    private Button addButton, clearButton, editButton, deleteButton;

    private EditText editText;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        adapter = new ArrayAdapter<String>(this, R.layout.le);

        editButton = findViewById(R.id.edit_button);

        clearButton = findViewById(R.id.clear_button);

        deleteButton = findViewById(R.id.delete_button);

        addButton = findViewById(R.id.add_button);

        editText = findViewById(R.id.edit_text);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        updateButtonStates();

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit(view);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear(view);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(view);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(view);
            }
        });
    }

    public void clear(View view) {

        adapter.clear();

        updateButtonStates();
    }

    public void add(View view) {

        String current_string = editText.getText().toString();

        System.out.println(current_string);

        adapter.add(current_string);

        updateButtonStates();
    }

    public void delete(View view) {

        String current_string = editText.getText().toString();

        if (!current_string.isEmpty())
            adapter.remove(current_string);

        updateButtonStates();
    }

    public void edit(View view) {

        updateButtonStates();

        if (current_index != -1) {

            String current_string = adapter.getItem(current_index);

            adapter.remove(current_string);

            adapter.insert(editText.getText().toString(), current_index);
        }

        updateButtonStates();
    }

    private String selected_string;
    private int current_index = -1;
    private View previousSelectedView = null;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (previousSelectedView != null) {

            previousSelectedView.setBackgroundColor(Color.TRANSPARENT);
        }

        editText.setText(adapter.getItem(i));

        view.setBackgroundColor(Color.LTGRAY);

        current_index = i;

        previousSelectedView = view;
    }

    private void updateButtonStates() {

        boolean isListEmpty = adapter.getCount() == 0;

        editButton.setEnabled(!isListEmpty);
        deleteButton.setEnabled(!isListEmpty);
    }
}
