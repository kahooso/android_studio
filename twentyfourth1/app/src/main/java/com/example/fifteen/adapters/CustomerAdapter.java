package com.example.fifteen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fifteen.Note;
import com.example.fifteen.R;

import java.util.List;

public class CustomerAdapter extends BaseAdapter {

    private final Context context;
    private List<Note> notes;

    public CustomerAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @Override
    public Note getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView contentTextView = view.findViewById(R.id.contentTextView);
        TextView timeTextView = view.findViewById(R.id.timeTextView);

        Note note = getItem(i);

        titleTextView.setText(note.getTitle());
        contentTextView.setText(note.getContent());
        timeTextView.setText(note.getTime().toString());

        return view;
    }
}