package com.example.foodiehouse;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Myclass extends BaseAdapter {
    String[] dishNames;
    int[] dishImage;
    Frecipe frecipe;
    public Myclass(String[] dishNames, int[] dishImage, Frecipe frecipe) {
        this.dishNames = dishNames;
        this.frecipe = frecipe;
        this.dishImage = dishImage;
    }

    @Override
    public int getCount() {
        return dishNames.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView im;
        ImageView image;
        convertView = LayoutInflater.from(frecipe).inflate(R.layout.frecipedesign,parent,false);
        im = convertView.findViewById(R.id.image);
        im.setBackgroundResource(dishImage[position]);
        TextView txt;
        txt = convertView.findViewById(R.id.txt);
        txt.setText(dishNames[position]);
        return convertView;
    }
}
