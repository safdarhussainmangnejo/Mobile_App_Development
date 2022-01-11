package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String database_name = "Friends.db";
    public static final String table_name = "myfriends";
    public static final String name_column = "name";
    public static final String phone_column = "phone";
    public static final int db_version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, database_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table myfriends"+"(id integer primary key, name text, phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS myfriends");
        onCreate(db);
    }


    public boolean insertNumber(String name, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name_column,name);
        contentValues.put(phone_column,phone);
        db.insert(table_name,null,contentValues);
        return true;
    }

    public Cursor getAllContacts(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor response = db.rawQuery("select * from myfriends",null);
        return response;
    }
}
