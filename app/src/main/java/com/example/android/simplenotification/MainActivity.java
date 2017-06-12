package com.example.android.simplenotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void setNotification(View view){
        notification.setSmallIcon(R.drawable.icon);
        notification.setTicker("this is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("here is the title");
        notification.setContentText("i am the body of the notification");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());






    }
}
