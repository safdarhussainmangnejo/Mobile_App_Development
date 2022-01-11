package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent myReceiverIntent = new Intent(this,Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1234,myReceiverIntent,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,100,pendingIntent);
    }
}