package com.example.labpractice1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LinearLayoutAdapter extends ArrayAdapter<Object> {

    String[] widgets;
    Activity cont;
    LayoutInflater vloader;

    public LinearLayoutAdapter(Activity context, String[] widgetsName) {
        super(context, R.layout.linear_layout_text_card, widgetsName);

        this.widgets = widgetsName;
        this.cont = context;
        this.vloader = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View viewer, ViewGroup parent) {
       
            viewer = vloader.inflate(R.layout.linear_layout_text_card, null,true);

        TextView taskText = (TextView) viewer.findViewById(R.id.taskname);

        taskText.setText(widgets[position]);

        return viewer;
    }
}
