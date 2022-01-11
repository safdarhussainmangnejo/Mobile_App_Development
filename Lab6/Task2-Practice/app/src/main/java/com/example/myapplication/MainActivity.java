package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView NamesTextViews;
    Button AddButton;
    DBHelper mydb;
    String values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NamesTextViews = (ListView) findViewById(R.id.ContactList);
        AddButton = (Button) findViewById(R.id.button);

        mydb=new DBHelper(this);
        ArrayList<String> arrayList = new ArrayList<>();

        Cursor contactsCursor = mydb.getAllContacts();
        if(contactsCursor!=null){
            contactsCursor.moveToFirst();
            while(contactsCursor.moveToNext()){
                Log.d("Message",contactsCursor.getString(1));
                arrayList.add(contactsCursor.getString(1));
            }
        }
        contactsCursor.close();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.contactlist,arrayList);
        NamesTextViews.setAdapter(arrayAdapter);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddContactIntent = new Intent(getApplicationContext(), AddContactActivity.class);
                startActivity(AddContactIntent);
            }
        });
    }
}