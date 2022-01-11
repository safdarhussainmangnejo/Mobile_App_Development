package com.example.lab6task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View v)
    {
        DBHelper helper=new DBHelper(this);
        String username=((EditText) findViewById(R.id.edit1)).getText().toString();
        String phone=((EditText) findViewById(R.id.edit2)).getText().toString();
        String email=((EditText) findViewById(R.id.edit3)).getText().toString();
        String street=((EditText) findViewById(R.id.edit4)).getText().toString();
        String zipcode=((EditText) findViewById(R.id.edit5)).getText().toString();
        boolean checkdata=helper.insert(username,phone,email,street,zipcode);
        if(checkdata==true)
        {
            Toast.makeText(this, "Successfully Insert", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity2.class);
            intent.putExtra("name",username);
            startActivity(intent);
        }
    }
}