package com.example.fifteen.activities;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected static final int CREATE_ACTION = 0x000312;
    protected static final int EDIT_ACTION = 0x000313;

    protected static final String EXTRA_NOTE = "note";
    protected static final String EXTRA_ID = "id";
}