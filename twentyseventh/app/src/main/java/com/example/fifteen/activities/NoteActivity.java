package com.example.fifteen.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fifteen.Note;
import com.example.fifteen.R;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class NoteActivity extends Base {

    private EditText editTitle;
    private EditText editContent;
    private TextView textTime;
    private Button selectDateButton;
    private Button okButton;
    private Button cancelButton;

    private Calendar calendar;
    private Date selectedDate;
    private Time selectedTime;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        textTime = findViewById(R.id.textTime);
        selectDateButton = findViewById(R.id.selectDateButton);
        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);

        calendar = Calendar.getInstance();

        if (getIntent().hasExtra(EXTRA_NOTE)) {
            note = (Note) getIntent().getSerializableExtra(EXTRA_NOTE);
            editTitle.setText(note.getTitle());
            editContent.setText(note.getContent());
            selectedDate = note.getDate();
            selectedTime = note.getTime();
            updateTimeText();
        }

        selectDateButton.setOnClickListener(v -> showDatePickerDialog());
        textTime.setOnClickListener(v -> showTimePickerDialog());

        okButton.setOnClickListener(v -> {
            note.setTitle(editTitle.getText().toString());
            note.setContent(editContent.getText().toString());
            note.setDate(selectedDate);
            note.setTime(selectedTime);

            // Возвращаем данные обратно в MainActivity
            setResult(RESULT_OK, getIntent().putExtra(EXTRA_NOTE, note));
            finish();
        });

        cancelButton.setOnClickListener(v -> finish());
    }

    private void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    calendar.set(Calendar.YEAR, year1);
                    calendar.set(Calendar.MONTH, monthOfYear);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    selectedDate = new Date(calendar.getTimeInMillis());
                    updateTimeText();
                }, year, month, day
        );
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minute1) -> {
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute1);
                    selectedTime = new Time(calendar.getTimeInMillis());
                    updateTimeText();
                }, hour, minute, true
        );
        timePickerDialog.show();
    }

    private void updateTimeText() {
        String dateStr = selectedDate.toString();  // Форматируем дату
        String timeStr = String.format("%02d:%02d", selectedTime.getHours(), selectedTime.getMinutes()); // Форматируем время
        textTime.setText(dateStr + " " + timeStr);
    }
}