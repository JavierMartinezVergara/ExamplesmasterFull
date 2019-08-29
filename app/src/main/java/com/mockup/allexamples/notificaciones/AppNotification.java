package com.mockup.allexamples.notificaciones;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class AppNotification extends Application {

    public static final String CHANNEL_1_ID = "Canal1";
    public static final String CHANNEL_2_ID = "Canal2";
    public static final String CHANNEL_3_ID = "Canal2";

    @Override
    public void onCreate() {

        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1  = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Canal 1",
                    NotificationManager.IMPORTANCE_HIGH
                    );
            channel1.setDescription("Este es el canal 1");

            NotificationChannel channel2  = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Canal 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("Este es el canal 2");

            NotificationChannel channel3  = new NotificationChannel(
                    CHANNEL_3_ID,
                    "Canal 3",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("Este es el canal 2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel2);
            notificationManager.createNotificationChannel(channel3);

        }
    }


}
