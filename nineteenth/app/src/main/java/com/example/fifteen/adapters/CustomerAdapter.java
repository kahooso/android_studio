package com.example.fifteen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fifteen.Application;
import com.example.fifteen.R;

import java.util.List;

public class CustomerAdapter extends BaseAdapter {

    private final Context context;

    private final List<String> notes;

    public CustomerAdapter(Context context) {

        this.context = context;
        this.notes = ((Application) context.getApplicationContext()).getNotes();
    }

    @Override
    public int getCount() {

        return notes.size();
    }

    @Override
    public CharSequence getItem(int i) {

        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);

        View colorSquare = view.findViewById(R.id.colorSquare);
        TextView textView = view.findViewById(R.id.textView);

        textView.setText(getItem(i));

        colorSquare.setBackgroundColor(i % 2 == 0 ? 0xFFE57373 : 0xFF81C784);

        return view;
    }
}
