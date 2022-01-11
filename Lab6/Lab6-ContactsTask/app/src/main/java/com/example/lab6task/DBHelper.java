package com.example.lab6task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String contactdb="contactDB";
    public DBHelper(@Nullable Context context) {
        super(context,contactdb,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS contacts(" +
                "name VARCHAR," +
                "phone VARCHAR," +
                "email VARCHAR," +
                "street VARCHAR," +
                "zipcode VARCHAR" +
                ");");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists contacts");
    }
    public boolean insert(String name,String phone,String email,String street,String zipcode)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put("name",name);
        content.put("phone",phone);
        content.put("email",email);
        content.put("street",street);
        content.put("zipcode",zipcode);
        long result=db.insert("contacts",null,content);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getData(String text)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select name from contacts where name='"+text+"'",null);
        return cursor;
    }
}
