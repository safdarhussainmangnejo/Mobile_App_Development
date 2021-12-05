package com.example.labexamsafdar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class GetValues extends AppCompatActivity {

    EditText user1, user2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user1 = findViewById(R.id.editTextTextPersonName);
        user2 = findViewById(R.id.editTextTextPersonName2);

    }

    public void onClick(View view){
        Intent intent = new Intent();
        startActivity(intent);
    }
}
