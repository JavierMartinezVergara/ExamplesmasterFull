package com.mockup.allexamples.Firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mockup.allexamples.MainActivity;
import com.mockup.allexamples.R;

import java.util.Map;

import static android.graphics.Color.rgb;

public class MyFirebaseMgsService extends FirebaseMessagingService {

    public MyFirebaseMgsService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if(remoteMessage.getData().isEmpty())
        showNotificacion(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        else showNotificacion(remoteMessage.getData());



        if(remoteMessage.getData().size() >0){

        }
    }


    private void showNotificacion(Map<String, String> data) {
        String title = data.get("title").toString();
        String body = data.get("body").toString();
        String NOTIFICACION_CHANNEL_ID = "";
    }



    private void showNotificacion(String title, String body) {


    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
    }

    @Override
    public void onSendError(String s, Exception e) {
        super.onSendError(s, e);
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }
}
