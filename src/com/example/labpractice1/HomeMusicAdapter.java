package com.example.labpractice1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HomeMusicAdapter extends ArrayAdapter<Object> {

    String[] songs;
    Activity cont;
    LayoutInflater vloader;

    public HomeMusicAdapter(Activity context, String[] song) {
        super(context, R.layout.linear_layout_play_list, song);

        this.songs = song;
        this.cont = context;
        this.vloader = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View viewer, ViewGroup parent) {
       
        viewer = vloader.inflate(R.layout.linear_layout_play_list, null,true);
        TextView songName = (TextView) viewer.findViewById(R.id.song);
        songName.setText(songs[position]);

        return viewer;
    }
}
