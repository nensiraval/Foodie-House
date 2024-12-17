package com.example.foodiehouse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {

    Button Login1; EditText user,password;
    TextView registr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Login1 = findViewById(R.id.Login1);
        registr = findViewById(R.id.registr);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);

        MyDataBase db = new MyDataBase (LoginPage.this);


                String UserName = user.getText().toString();
                startActivity(new Intent(LoginPage.this,Frecipe.class).putExtra("Username",UserName));

        Login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MyData", MODE_PRIVATE);
                SharedPreferences.Editor editor =preferences.edit();

                editor.putBoolean("data",true);
                editor.apply();

                String number = password.getText().toString();
                if (number.isEmpty())
                {
                    password.setError("number if required");
                } else if (number.length() != 4) //number 10 digit na j ave ana mate
                {
                    password.setError("Limited Digits 4");
                    return;
                }
                Cursor data =  db.userlogin(user.getText().toString(), password.getText().toString());
                Log.e("========", "onClick: "+data);
                while (data.moveToNext())
                {
                    Log.e("+++++", "name : "+data.getInt(0));
                    Log.e("+++++", "password : "+data.getInt(1));

                    startActivity(new Intent(LoginPage.this, startcooking.class));
                    finish();
                }
            }
        });
        registr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, RegisterPage.class));
            }
        });

    }

}