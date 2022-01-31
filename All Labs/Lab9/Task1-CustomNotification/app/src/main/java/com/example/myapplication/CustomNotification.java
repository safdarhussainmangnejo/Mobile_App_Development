package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;

public class CustomNotification {
    Notification notification;
    NotificationManager notificationManager;

    public CustomNotification(Notification notification, NotificationManager notificationManager) {
        this.notification = notification;
        this.notificationManager = notificationManager;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public NotificationManager getNotificationManager() {
        return notificationManager;
    }

    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }
}

