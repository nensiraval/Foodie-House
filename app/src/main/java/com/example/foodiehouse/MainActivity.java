package com.example.foodiehouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("MyData",MODE_PRIVATE);

                Boolean check = preferences.getBoolean("data",false);

                if (check)
                {
                    startActivity(new Intent(MainActivity.this, startcooking.class));
                }
                else {
                    startActivity(new Intent(MainActivity.this, LoginPage.class));
                    finish();
                }
            }
        },2000);
    }
}