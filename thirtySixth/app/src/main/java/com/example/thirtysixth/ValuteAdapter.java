package com.example.thirtysixth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ValuteAdapter extends ArrayAdapter<TestValute> {

    private final List<TestValute> valutes;

    public ValuteAdapter(Context context, int resource, List<TestValute> valutes) {
        super(context, resource, valutes);
        this.valutes = valutes;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.xml_res, parent, false);
        }

        TestValute valute = valutes.get(position);

        TextView name = convertView.findViewById(R.id.valuteName);
        TextView charCode = convertView.findViewById(R.id.charCode);
        TextView curPokup = convertView.findViewById(R.id.curPokup);
        TextView curProd = convertView.findViewById(R.id.curProd);

        name.setText(valute.getValuteName());
        charCode.setText(valute.getValuteCharCode());  

        float value = valute.getValuteValue();
        float coef = 0.1f;

        float buyRate = value - (value * coef);
        float sellRate = value + (value * coef);

        curPokup.setText(String.format("%.2f", buyRate));
        curProd.setText(String.format("%.2f", sellRate));

        if(position % 2 ==0) {
            curProd.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ar_green, 0);
            curPokup.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ar_red, 0);
        } else {
            curProd.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ar_red, 0);
            curPokup.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ar_green, 0);
        }

        return convertView;
    }
}