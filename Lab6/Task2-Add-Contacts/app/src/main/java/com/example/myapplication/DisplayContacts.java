package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DisplayContacts extends  MainActivity{
    int index=0;
    private DBHelper mydb;

    TextView name ;
    TextView phone;
    TextView email;
    TextView street;
    TextView place;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        email = (TextView) findViewById(R.id.editTextStreet);
        street = (TextView) findViewById(R.id.editTextEmail);
        place = (TextView) findViewById(R.id.editTextCity);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int value = extras.getInt("id");

            if(value>0){
                Cursor cv = mydb.getContacts();
                id_To_Update = value;
                cv.moveToFirst();

                String nam = cv.getString(cv.getColumnIndexOrThrow(DBHelper.COLUMN_NAME));
                String phon = cv.getString(cv.getColumnIndexOrThrow(DBHelper.COLUMN_PHONE));
                String emai = cv.getString(cv.getColumnIndexOrThrow(DBHelper.COLUMN_EMAIL));
                String stree = cv.getString(cv.getColumnIndexOrThrow(DBHelper.COLUMN_STREET));
                String plac = cv.getString(cv.getColumnIndexOrThrow(DBHelper.COLUMN_CITY));

                if(!cv.isClosed()){
                    cv.close();
                }
                Button b = (Button)findViewById(R.id.button1);
                //b.setVisibility(View.INVISIBLE);

                name.setText((CharSequence)nam);
                name.setFocusable(false);
                name.setClickable(false);

                phone.setText((CharSequence)phon);
                phone.setFocusable(false);
                phone.setClickable(false);

                email.setText((CharSequence)emai);
                email.setFocusable(false);
                email.setClickable(false);

                street.setText((CharSequence)stree);
                street.setFocusable(false);
                street.setClickable(false);

                place.setText((CharSequence)plac);
                place.setFocusable(false);
                place.setClickable(false);

            }
        }
    }

    public void run(View view){
        /*Bundle extras = getIntent().getExtras();
        if(extras!=null){
            int value = extras.getInt("id");
            if(value>0){
                if(mydb.updateContact(id_To_Update, name.getText().toString(),
                        phone.getText().toString(), email.getText().toString(),
                        street.getText().toString(), place.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();

                }
            }
            else{*/
                if(mydb.insertContact(name.getText().toString(),
                        phone.getText().toString(),
                        email.getText().toString(),
                        street.getText().toString(),
                        place.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "not Inserted", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
}

