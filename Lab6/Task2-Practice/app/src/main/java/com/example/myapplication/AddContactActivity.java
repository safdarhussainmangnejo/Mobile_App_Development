package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    EditText name, phone;
    Button Savebutton;
    DBHelper objAddContacts;
    //String name, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        phone = (EditText) findViewById(R.id.editTextPhone);
        Savebutton = (Button) findViewById(R.id.button2);
        objAddContacts=new DBHelper(this);
        Savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields should not be empty", Toast.LENGTH_LONG).show();
                }
                else {
                    if(objAddContacts.insertNumber(name.getText().toString(),
                            phone.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Contact Added", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Contact Didn't Add", Toast.LENGTH_LONG).show();
                    }
                }

                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });
    }

}