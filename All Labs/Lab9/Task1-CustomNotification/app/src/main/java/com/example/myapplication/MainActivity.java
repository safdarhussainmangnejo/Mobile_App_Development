package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    CustomNotification custom_notification;
    public static final String CHANNEL_ID="ForegroundServiceChannel";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_notification = createNotification();


    }
    public void ShowNotification(View view){
        custom_notification.getNotificationManager().notify(1234,custom_notification.getNotification());
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public CustomNotification createNotification(){

        //Creating notification Manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //Creating notification channel
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,"custom_notification",NotificationManager.IMPORTANCE_DEFAULT);
        //create channel
        notificationManager.createNotificationChannel(notificationChannel);
        //Creating notification custom layout holder
        RemoteViews collapsedView = new RemoteViews(getPackageName(),R.layout.collapse_notification);
        RemoteViews expandedView = new RemoteViews(getPackageName(),R.layout.expand_notification);
        //setting text view and other view values.
//        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello Zeeshan!");
//        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.ds);
        //Creating notification builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Customized notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView);
        //Creating notification
        Notification notification = builder.build();
        CustomNotification custom_notification = new CustomNotification(notification,notificationManager);
        return custom_notification;
    }
}