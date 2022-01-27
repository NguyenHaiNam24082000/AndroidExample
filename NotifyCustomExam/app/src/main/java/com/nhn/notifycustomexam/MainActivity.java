package com.nhn.notifycustomexam;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        showNotification();
    }

    private static final String CHANNEL_ID = "TEST_CHANNEL";

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);
            String description = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

//    private PendingIntent onButtonNotificationClick(@IdRes int id) {
//        Intent intent = new Intent(ACTION_NOTIFICATION_BUTTON_CLICK);
//        intent.putExtra(EXTRA_BUTTON_CLICKED, id);
//        return PendingIntent.getBroadcast(this, id, intent, 0);
//    }

    private void showNotification() {

        RemoteViews notificationLayout =
                new RemoteViews(getPackageName(), R.layout.custom_notification);

//        notificationLayout.setOnClickPendingIntent(R.id.btnAccept,
//                onButtonNotificationClick(R.id.btnAccept));
//        notificationLayout.setOnClickPendingIntent(R.id.btnDenied,
//                onButtonNotificationClick(R.id.btnDenied));

        Notification
                notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setCustomContentView(notificationLayout)
                .build();
        NotificationManager notificationManager =
                (android.app.NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}