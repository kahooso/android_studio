package com.example.fifteen.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fifteen.Note;
import com.example.fifteen.R;
import com.example.fifteen.Type;

import android.app.AlertDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class SecondActivity extends BaseActivity {

    private EditText editTitle;
    private EditText editContent;
    private TextView textTime;
    private Button okButton;
    private Button cancelButton;
    private Button timeButton;

    private int noteId = -1;
    private Note currentNote;

    private Spinner typeSpinner;

    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        textTime = findViewById(R.id.textTime);

        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);
        timeButton = findViewById(R.id.timeButton);

        typeSpinner = findViewById(R.id.typeSpinner);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_NOTE)) {

            currentNote = (Note) intent.getSerializableExtra(EXTRA_NOTE);
            noteId = intent.getIntExtra(EXTRA_ID, -1);
            editTitle.setText(currentNote.getTitle());
            editContent.setText(currentNote.getContent());

            calendar = Calendar.getInstance();

            Time time = currentNote.getTime();

            ArrayAdapter<Type> typeAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_item, Type.values());
            typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeSpinner.setAdapter(typeAdapter);

            if (time != null) {
                calendar.set(Calendar.HOUR_OF_DAY, time.getHours());
                calendar.set(Calendar.MINUTE, time.getMinutes());
                calendar.set(Calendar.SECOND, time.getSeconds());
            }

            Date date = currentNote.getDate();
            if (date != null) {
                calendar.set(Calendar.YEAR, date.getYear() + 1900);
                calendar.set(Calendar.MONTH, date.getMonth());
                calendar.set(Calendar.DAY_OF_MONTH, date.getDate());
            }

            if (currentNote.getType() != null) {

                int position = ((ArrayAdapter<Type>) typeSpinner.getAdapter()).getPosition(currentNote.getType());
                typeSpinner.setSelection(position);
            }

            updateTimeText();

        } else {
            currentNote = new Note(
                    0, "",  "",
                    new Time(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis()),
                    Type.Simple
            );
            calendar = Calendar.getInstance();
            updateTimeText();
        }


        TextWatcher watcher = new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                okButton.setEnabled(!TextUtils.isEmpty(editTitle.getText()) && !TextUtils.isEmpty(editContent.getText()));
            }

            @Override
            public void afterTextChanged(android.text.Editable editable) { }
        };

        editTitle.addTextChangedListener(watcher);
        editContent.addTextChangedListener(watcher);
        okButton.setOnClickListener(view -> {

            String title = editTitle.getText().toString();
            String content = editContent.getText().toString();
            java.sql.Time time = new java.sql.Time(calendar.getTimeInMillis());
            java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());
            Type selectedType = (Type) typeSpinner.getSelectedItem();

            System.out.println("TIME: " + time);
            System.out.println("DATE: " + date);

            currentNote.setTitle(title);
            currentNote.setContent(content);
            currentNote.setTime(time);
            currentNote.setDate(date);
            currentNote.setType(selectedType);

            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_NOTE, currentNote);
            resultIntent.putExtra(EXTRA_ID, noteId);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
        cancelButton.setOnClickListener(view -> finish());
        timeButton.setOnClickListener(view -> showDateTimeDialog());
    }

    private void updateTimeText() {

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        @SuppressLint("DefaultLocale") String timeText = String.format("%02d/%02d/%d %02d:%02d", day, month, year, hour, minute);

        textTime.setText(timeText);
    }

    private void showDateTimeDialog() {

        final Calendar tempCalendar = (Calendar) calendar.clone();

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final DatePicker datePicker = new DatePicker(this);
        datePicker.updateDate(
                tempCalendar.get(Calendar.YEAR),
                tempCalendar.get(Calendar.MONTH),
                tempCalendar.get(Calendar.DAY_OF_MONTH));
        LinearLayout.LayoutParams datePickerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                1000
        );

        datePicker.setLayoutParams(datePickerParams);
        linearLayout.addView(datePicker);

        final TimePicker timePicker = new TimePicker(this);
        timePicker.setIs24HourView(true);
        timePicker.setHour(tempCalendar.get(Calendar.HOUR_OF_DAY));
        timePicker.setMinute(tempCalendar.get(Calendar.MINUTE));
        LinearLayout.LayoutParams timePickerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                1100
        );
        timePicker.setLayoutParams(timePickerParams);
        linearLayout.addView(timePicker);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(linearLayout);

        builder.setPositiveButton("OK", (dialog, which) -> {
            tempCalendar.set(Calendar.YEAR, datePicker.getYear());
            tempCalendar.set(Calendar.MONTH, datePicker.getMonth());
            tempCalendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
            tempCalendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
            tempCalendar.set(Calendar.MINUTE, timePicker.getMinute());

            calendar.setTimeInMillis(tempCalendar.getTimeInMillis());
            updateTimeText();
        });
        builder.setNegativeButton("Cancel", null);

        builder.create().show();
    }
}