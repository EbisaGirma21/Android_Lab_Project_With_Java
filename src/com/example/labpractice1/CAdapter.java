package com.example.labpractice1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CAdapter extends ArrayAdapter<Object> {

    String[] task;
    Integer[] imgID;
    Activity cont;
    LayoutInflater vloader;

    public CAdapter(Activity context, String[] taskname, Integer[] image) {
        super(context, R.layout.main_gridview, taskname);

        this.task = taskname;
        this.imgID = image;
        this.cont = context;
        this.vloader = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View viewer, ViewGroup parent) {
       
            viewer = vloader.inflate(R.layout.main_gridview, null,true);

//        ImageView taskimg = (ImageView) viewer.findViewById(R.id.taskimg);
        TextView taskText = (TextView) viewer.findViewById(R.id.taskname);

//        taskimg.setImageResource(imgID[position]);
        taskText.setText(task[position]);

        return viewer;
    }
}
