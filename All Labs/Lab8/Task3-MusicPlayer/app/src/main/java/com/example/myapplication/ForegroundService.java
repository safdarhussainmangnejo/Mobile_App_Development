package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class ForegroundService extends Service {

    public static final String channel_id ="ForegroundServiceChannel";
    public static final String channel_name ="ClickMusic";
    @Override
    public void onCreate(){super.onCreate();}

    public int onStartCommand(Intent intent, int flags, int startId){
        @SuppressLint("RemoteViewLayout") RemoteViews collapsedView = new RemoteViews(getPackageName(),
                R.layout.notification_collapse);
        @SuppressLint("RemoteViewLayout") RemoteViews expandedView = new RemoteViews(getPackageName(),
                R.layout.notification_expended);

        Intent clickIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
                0,clickIntent,0);
        collapsedView.setTextViewText(R.id.text_view_collapsed_1,"This is a message");
        expandedView.setTextViewText(R.id.image_view_expanded,"This is a expanded message");
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded,pendingIntent);
        Intent intent_recording = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent_recording = PendingIntent.getBroadcast(this,
                123,intent_recording,0);

        String forInput = intent.getStringExtra("inputExtra");
        createNotificationChannel();

        Notification notification = new NotificationChannelCompat.Builder(this, channel_id)
                .se
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
