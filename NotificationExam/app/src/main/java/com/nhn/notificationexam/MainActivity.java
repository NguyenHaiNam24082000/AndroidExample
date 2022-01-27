package com.nhn.notificationexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Notification";

    private Button createNotificationButton;
    private EditText edtTitle,edtDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitle = findViewById(R.id.edtTitle);
        edtDes = findViewById(R.id.edtDes);
        createNotificationButton = findViewById(R.id.button);

        createNotificationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String title= edtTitle.getText().toString();
                String des = edtDes.getText().toString();
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    CharSequence name ="Notification";
//                    int importance = NotificationManager.IMPORTANCE_DEFAULT;
//
//                    NotificationChannel notificationChannel = new NotificationChannel(TAG,name,importance);
//                    notificationChannel.setDescription(des);
//                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
//                    notificationManager.createNotificationChannel(notificationChannel);
//                }
//                else {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), TAG);
                    builder.setSmallIcon(R.drawable.ic_android_black_24dp);
                    builder.setContentTitle(title);
                    builder.setContentText(des);
                    builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                    NotificationManagerCompat notificationCompat = NotificationManagerCompat.from(getApplicationContext());
                    notificationCompat.notify(102, builder.build());
//                }
            }
        });
    }
}