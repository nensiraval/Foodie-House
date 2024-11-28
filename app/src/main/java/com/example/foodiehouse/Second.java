package com.example.foodiehouse;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends BaseAdapter {
    Context context;
    String[] blank;
    public Second(Context context, String[] blank) {
        this.context = context;
        this.blank = blank;
    }

    @Override
    public int getCount() {
        return blank.length;
    }

    @Override
    public Object getItem(int position) {
        return blank [position];
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.recipedesign,parent,false);
        TextView txt;
        txt = convertView.findViewById(R.id.txt);
        txt.setText(blank[position]);

//        share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String recipeToShare = txt.getText().toString() + "\n\n"; // Dish name
//                for (String recipeStep : blank) {
//                    recipeToShare += recipeStep + "\n";
//                }
//
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                String shareBody = "Your body here";
//                String shareSub = "Your subject here";
//                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, recipeToShare);
//                context.startActivity(Intent.createChooser(sharingIntent, "Share using"));
//
//            }
//        });
//        copy.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v) {
//                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
//                ClipData clip = ClipData.newPlainText("label", blank[position]);
//                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
//                clipboard.setPrimaryClip(clip);
//            }
//        });

        return convertView;
    }
}
