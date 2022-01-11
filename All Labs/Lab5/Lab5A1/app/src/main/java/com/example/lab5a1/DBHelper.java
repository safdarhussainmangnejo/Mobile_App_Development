package com.example.lab5a1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class DBHelper extends SQLiteOpenHelper {
    public final static String DBName = "Login";
    public final static int version = 1;

    public DBHelper(Context context){
        super(context,DBName,null,version);
    }


    @Override
    public  void onCreate(SQLiteDatabase db){
        //Create Table Queries
        String query = "CREATE TABLE LOGIN (ID INTEGER, Username TEXT, Password TEXT)";
        db.execSQL(query);

        ContentValues cv = new ContentValues();
        cv.put("ID",1);
        cv.put("Username","Safdar");
        cv.put("Password","123");
        db.insert("Login",null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(int ID, String UName, String Pass){
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        cv.put("ID",ID);
        cv.put("Username",UName);
        cv.put("Password",Pass);
        db.insert("Login",null,cv);
    }

    public Cursor getUserByID(int id){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from Login where ID=id";
        return  db.rawQuery(query,null);
    }


}
