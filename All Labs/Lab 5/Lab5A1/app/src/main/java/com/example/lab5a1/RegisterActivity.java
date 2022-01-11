package com.example.lab5a1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email_new);
        password = findViewById(R.id.password_new);
        preferences = getSharedPreferences("accounts",MODE_PRIVATE);
    }

    public void onRegister(View view){
        if(name.getText().toString() == null || email.getText().toString() == null || password.getText().toString() == null){
            Toast.makeText(this,"Fill the form first",Toast.LENGTH_LONG).show();
            return;
        }
        //intent.putExtra("name",name.getText().toString());
        //intent.putExtra("email",email.getText().toString());
        //intent.putExtra("password",password.getText().toString());
        SharedPreferences.Editor editor = preferences.edit();

        StringBuilder sb = new StringBuilder();
        sb.append(name.getText().toString()).append(";");
        sb.append(password.getText().toString());
        editor.putString(email.getText().toString(), sb.toString());
        editor.commit();
        Toast.makeText(this,"Registration successful",Toast.LENGTH_LONG).show();
    }

    public void onLogin(View view){

        setResult(Activity.RESULT_OK);
        finish();
    }
}