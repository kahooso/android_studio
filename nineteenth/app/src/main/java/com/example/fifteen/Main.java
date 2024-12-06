package com.example.fifteen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.fifteen.activities.MyBaseActivity;
import com.example.fifteen.activities.SecondActivity;
import com.example.fifteen.adapters.CustomerAdapter;

import java.util.ArrayList;

public class Main extends MyBaseActivity {

    private Application application;
    private ArrayList<String> notes;
    private CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        application = (Application)getApplicationContext();
        notes = (ArrayList<String>) application.getNotes();
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);

        ListView listView = findViewById(R.id.listView);
        adapter = new CustomerAdapter(this);
        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, SecondActivity.class);
                startActivityForResult(intent, CREATE_ACTION);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(Main.this, SecondActivity.class);
                intent.putExtra(EXTRA_TEXT, notes.get(position));
                intent.putExtra(EXTRA_ID, position);
                startActivityForResult(intent, EDIT_ACTION);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            String text = data.getStringExtra(EXTRA_TEXT);
            switch (requestCode) {
                case CREATE_ACTION:
                    application.addNote(text);
                    break;

                case EDIT_ACTION:
                    int position = data.getIntExtra(EXTRA_ID, -1);
                    if (position != -1) {
                        application.setNote(position, text);
                    }
                    break;
            }
            adapter.notifyDataSetChanged();
        }
    }
}