package com.example.eleventh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ColorAdapter extends BaseAdapter {

    private final int[] color_codes;
    private final String[] color_names;

    public ColorAdapter(int[] color_codes, String[] color_names) {

        this.color_codes = color_codes;
        this.color_names = color_names;
    }

    @Override
    public int getCount() {

        return color_codes.length;
    }

    @Override
    public Object getItem(int i) {

        return color_codes[i];
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Context context = viewGroup.getContext();

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.items_list, viewGroup, false);
        }

        TextView textView = (TextView)view;

        textView.setText(color_names[i]);

        return view;
    }
}
