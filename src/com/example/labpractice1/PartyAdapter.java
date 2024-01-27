package com.example.labpractice1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PartyAdapter extends ArrayAdapter<Object> {

    String[] widgets;
    Activity cont;
    LayoutInflater vloader;

    public PartyAdapter(Activity context, String[] widgetsName) {
        super(context, R.layout.linear_layout_party_card, widgetsName);

        this.widgets = widgetsName;
        this.cont = context;
        this.vloader = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View viewer, ViewGroup parent) {
       
            viewer = vloader.inflate(R.layout.linear_layout_party_card, null,true);

        TextView taskText = (TextView) viewer.findViewById(R.id.taskname);

        taskText.setText(widgets[position]);

        return viewer;
    }
}
