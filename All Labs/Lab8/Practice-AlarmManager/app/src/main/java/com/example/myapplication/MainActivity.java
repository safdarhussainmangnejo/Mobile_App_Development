package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void OnToggleClicked(View view){
        long time;

        if(((ToggleButton) view).isChecked()){
            Toast.makeText(this, "ALRM ON", Toast.LENGTH_SHORT).show();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
            Intent intent=new Intent(this,AlarmReceiver.class);
            pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);

            time = (calendar.getTimeInMillis()-(calendar.getTimeInMillis()%600000));

            if(System.currentTimeMillis()>time){
                if(calendar.AM_PM==0){
                    time = time + (1000*60*60*12);
                }else
                    time = time + (1000*60*60*24);
            }
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,time,100000,pendingIntent);

        }
    }
}