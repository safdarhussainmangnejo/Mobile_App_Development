package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);
        ArrayList<String> array_list = new ArrayList<>();

        Cursor cursor=mydb.getContacts();
        while(cursor.moveToNext())
        {
            array_list.add(cursor.getString(1));
        }
        obj = (ListView)findViewById(R.id.listView1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(getApplicationContext(),DisplayContacts.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }


    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(),DisplayContacts.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putInt("id", 0);
        intent.putExtras(dataBundle);
        startActivity(intent);
    }
}