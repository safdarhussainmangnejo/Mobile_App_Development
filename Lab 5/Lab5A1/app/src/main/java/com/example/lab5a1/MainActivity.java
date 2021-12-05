package com.example.lab5a1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    SharedPreferences preferences;
    static boolean login;
    static boolean playing_music;
    DBHelper helper;
    String username;
    String pass;
    int id = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        preferences = getSharedPreferences("accounts",MODE_PRIVATE);
        login = false;
        playing_music = false;
        username = email.getText().toString();
        pass = password.getText().toString();
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();

    }

    public void onRegister(View v){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        helper.insertData(id,username,pass);
        Toast.makeText(this, "Ussername: "+username+" , "+pass+" Inserted", Toast.LENGTH_SHORT).show();
        id++;

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(login){
            //String[] values = preferences.getString(email.getText().toString()," ; ").split(";");
            //Intent intent = new Intent(this,UserActivity.class);
            //intent.putExtra("name",values[0]);
            //startActivity(intent);
            finish();
        }
    }

    public void onLogin(View view){

        //String[] val = preferences.getString(email.getText().toString()," ; ").split(";");
        //Log.d("Login Activity", "onLogin: "+password.getText().toString().equals(val[1]));

        Cursor data = helper.getUserByID(1);
        Toast.makeText(this,"Got Data this: "+data.toString(),Toast.LENGTH_LONG).show();
        if(preferences.getString(email.getText().toString(),null) != null){
            String[] values = preferences.getString(email.getText().toString()," ; ").split(";");
            if(password.getText().toString().equals(values[1])) {
                login = true;
                Intent intent = new Intent(this,UserActivity.class);
                intent.putExtra("name",values[0]);
                startActivity(intent);
                //Toast.makeText(this, "Welcome " + values[0], Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_LONG).show();
            }
        }
        else
            Toast.makeText(this,"Incorrect email or password",Toast.LENGTH_LONG).show();
    }

}