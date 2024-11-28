package com.example.foodiehouse;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPage extends AppCompatActivity {
    Button register; TextView login; EditText fname,mail,pswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        fname = findViewById(R.id.fname);
        mail = findViewById(R.id.mail);
        pswrd = findViewById(R.id.pswrd);

        MyDataBase db = new MyDataBase(RegisterPage.this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =  mail.getText().toString();
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    mail.setError("Please enter a valid email address");
                    return;
                }

                //number required check
                String number = pswrd.getText().toString();
                if (number.isEmpty())
                {
                    pswrd.setError("number if required");
                } else if (number.length() != 4) //number 10 digit na j ave ana mate
                {
                    pswrd.setError("Limited Digits 4");
                    return;
                }

                Boolean n = db.insertdata(fname.getText().toString(), mail.getText().toString(), pswrd.getText().toString());
                if (n)
                {
                    startActivity(new Intent(RegisterPage.this, LoginPage.class));
                    finish();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterPage.this, LoginPage.class));
            }
        });
    }
}