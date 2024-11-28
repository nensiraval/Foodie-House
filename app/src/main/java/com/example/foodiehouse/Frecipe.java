package com.example.foodiehouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Frecipe extends AppCompatActivity {
    ImageView more;
    GridView blist;

    String[] DishNames = {"Poha", "Dhokla", "Fafda", "Khandvi", "Khakra", "Aloo Methi Paratha", "Moong Dal Cheela", "Oats Khichdi", "Rava Upma", "Matar Ka Paratha",
            "Medu Vada", "Sandwich", "Besan Chilla", "Matar Kachori", "Sabudana Khichdi", "Masala Dosa","Dal tadka", "Chana masala", "Aloo gobi", "Mattar paneer",
            "Rajma chawal", "Bombay Sandwich", "Baingan bharta", "Undhiyu", "Gujarati kadhi", "Shahi paneer","french fry", "Samosa", "Bhel", "Shakarpara", "Masala Peanuts",
            "Kachori", "Pakora", "Banana chips", "Batata vada", "Bakarwadi","Pizza", "Pasta", "Maggie", "Manchurian", "Pav Bhaji", "Momos", "Pani Puri", "Burger", "Tawa Pulao",
            "Noodles","Gulab jamun", "Kheer", "Cheesecake", "Gajar ka halwa", "Chocolate brownie", "Chocolate cake", "Strawberry cake", "Vanilla Cake", "Coconut Cardamom Cake",
            "Masala Chai", "Cold Coffee", "Nimbu Pani", "Watermelon Juice", "Amla Juice ", "lassi", "Pineapple Cucumber Juice", "Almond Saffron Milk", "Manchow Soup"};
    int[] DishImage = {R.drawable.p1, R.drawable.khaman, R.drawable.fafda, R.drawable.khandvi, R.drawable.khk, R.drawable.alp1, R.drawable.mdal, R.drawable.otsk, R.drawable.upma, R.drawable.matpa, R.drawable.vada, R.drawable.sandwich
            , R.drawable.besanchila, R.drawable.kachori, R.drawable.khichdi, R.drawable.dosa,R.drawable.dal, R.drawable.chana, R.drawable.gobi, R.drawable.matter, R.drawable.rajma, R.drawable.bambeysan, R.drawable.bharta,
            R.drawable.udhiyu, R.drawable.kadhi, R.drawable.sahi,R.drawable.frenchfries, R.drawable.samosa, R.drawable.bhel, R.drawable.shakarpara, R.drawable.pinuts, R.drawable.kachori
            , R.drawable.pakoda, R.drawable.banana, R.drawable.batakavada, R.drawable.bhakharvadi,R.drawable.pizza, R.drawable.pasta, R.drawable.maggie, R.drawable.vegmanchurian, R.drawable.pavbhaji, R.drawable.momo
            , R.drawable.panipuri, R.drawable.burger, R.drawable.pulao, R.drawable.noodels,R.drawable.gulabjamun, R.drawable.kheer, R.drawable.cheesecake, R.drawable.carrot, R.drawable.browni, R.drawable.choclatecake
            , R.drawable.strawbarrycake, R.drawable.venilacake, R.drawable.coconut,R.drawable.chai, R.drawable.coldcoffee, R.drawable.nimbupani, R.drawable.watermelonjuice, R.drawable.amalajuice, R.drawable.lassi
            , R.drawable.cucumberjuice, R.drawable.almondseffornmilk, R.drawable.soup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frecipe);

        blist = findViewById(R.id.blist);
        more = findViewById(R.id.more);


        Myclass dishname = new Myclass(DishNames,DishImage,Frecipe.this);
        blist.setAdapter(dishname);

        blist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("__________________", "onItemClick() returned: " +position);
                String object = DishNames[position];
                startActivity(new Intent(Frecipe.this,Recipeshow.class).putExtra("Dishname",object));
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                PopupMenu popupMenu =new PopupMenu(Frecipe.this,more);
                popupMenu.inflate(R.menu.mymenu);
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.home)
                        {
                            startActivity(new Intent(Frecipe.this,startcooking.class));
                        }
                        else if(item.getItemId() == R.id.logout)
                        {
                            SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
                            SharedPreferences.Editor editor =   preferences.edit();

                            editor.putBoolean("Mystatus",false);
                            editor.apply();
                            startActivity(new Intent(Frecipe.this,LoginPage.class));
                        }
                        return false;
                    }
                });
            }
        });

    }
}



