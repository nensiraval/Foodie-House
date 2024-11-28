package com.example.foodiehouse;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {

    Context context;
    public MyDataBase(@Nullable Context context) {
        super(context, "mytable.db", null, 1);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE usertable (id integer primary key  autoincrement, fname text unique, mail text, pswrd text)";
        db.execSQL(table);
    }

    public Boolean insertdata(String fname, String mail, String pswrd) {

        try{
            String insert = "INSERT INTO usertable(fname, mail, pswrd) VALUES ('" + fname + "','" + mail + "','" + pswrd + "')";
            getWritableDatabase().execSQL(insert);
            Toast.makeText(context, "Data Enter "+fname, Toast.LENGTH_SHORT).show();
            return true;
        }
        catch (Exception e) {
            Log.e("++--------", "insertdata: " + e.getMessage());
            Toast.makeText(context, "Data not "+fname, Toast.LENGTH_SHORT).show();

            return false;
        }
    }
    public Cursor userlogin(String user, String pass) {
        String select = "SELECT * FROM usertable WHERE fname = '" + user + "'AND pswrd = '" + pass + "'";

        Cursor cr = getReadableDatabase().rawQuery(select, null);
        return cr;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
