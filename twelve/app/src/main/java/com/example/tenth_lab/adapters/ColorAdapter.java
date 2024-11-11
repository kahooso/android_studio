package com.example.tenth_lab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tenth_lab.R;

public class ColorAdapter extends BaseAdapter {

    private final int[] colorCodes;
    private final String[] colorNames;

    public ColorAdapter(int[] colorCodes, String[] colorNames) {
        this.colorCodes = colorCodes;
        this.colorNames = colorNames;
    }

    @Override
    public int getCount() {
        return colorCodes.length;
    }

    @Override
    public Object getItem(int i) {
        return colorCodes[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_list, viewGroup, false);
        }

        TextView textView = view.findViewById(R.id.text_view);
        textView.setText(colorNames[i]);
        view.setBackgroundColor(colorCodes[i]);

        return view;
    }
}