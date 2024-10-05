package com.example.nineth_lab;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class Main extends Activity {

    private SharedPreferences shared_preferences;

    private EditText first_edit_text_string, second_edit_text_string, edit_text_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        first_edit_text_string = findViewById(R.id.first_string_edit_text);
        second_edit_text_string = findViewById(R.id.second_string_edit_text);

        edit_text_int = findViewById(R.id.int_edit_text);

        shared_preferences = getSharedPreferences(
                getString(R.string.preferences),
                MODE_PRIVATE
        );
    }

    @Override
    protected void onResume() {

        super.onResume();

        int intElement = shared_preferences.getInt(getString(R.string.int_element), 0);
        String first_string = shared_preferences.getString(getString(R.string.first_string_element), "");
        String second_string = shared_preferences.getString(getString(R.string.second_string_element), "");

        first_edit_text_string.setText(first_string);
        second_edit_text_string.setText(second_string);

        if (intElement != 0) {
            edit_text_int.setText(String.valueOf(intElement));
        }
        else {
            edit_text_int.setText("");
        }
    }

    @Override
    protected void onPause() {

        super.onPause();

        int intValue = 0;
        String intText = edit_text_int.getText().toString();

        if (!intText.isEmpty()) {
            try {
                intValue = Integer.parseInt(intText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        String first_string = first_edit_text_string.getText().toString();

        String second_string = second_edit_text_string.getText().toString();

        SharedPreferences.Editor shared_preferences_editor = shared_preferences.edit();

        shared_preferences_editor.putString(getString(R.string.first_string_element), first_string);

        shared_preferences_editor.putString(getString(R.string.second_string_element), second_string);

        shared_preferences_editor.putInt(getString(R.string.int_element), intValue);

        shared_preferences_editor.apply();
    }
}
