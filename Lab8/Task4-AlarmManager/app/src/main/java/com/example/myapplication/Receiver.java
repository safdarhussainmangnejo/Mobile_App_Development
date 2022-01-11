package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class Receiver extends BroadcastReceiver {

    String channel_id = "Android_Channel";
    String channel_name = "Android_Channel_Name";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm is on", Toast.LENGTH_SHORT).show();

        //Step 1: create a refeence of notification manager
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //Step2: Create an intent
        Intent intent1 = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent1,0);

        // Step 2,2: Creating action

        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.ic_launcher_background,"OPEN",null);

        //Step 2.3 Build Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channel_id)
                .setContentTitle("Test Notification")
                .setContentText("This is notifcation")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .addAction(action);

        Notification notification = builder.build();

        //Step 3:
        NotificationChannel notificationChannel = new NotificationChannel(channel_id,channel_name,NotificationManager.IMPORTANCE_DEFAULT);
        nm.createNotificationChannel(notificationChannel);


        //Step 4:
        nm.notify(12345,notification);



    }
}
