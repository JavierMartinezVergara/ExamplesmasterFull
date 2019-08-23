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
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


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
        String NOTIFICACION_CHANNEL_ID = getString(R.string.defaultnotification);
    }

    private void showNotificacion(String title, String body) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri defaultsoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        String NOTIFICATION_CHANNEL_ID = getString(R.string.defaultnotification);

        NotificationCompat.Builder notificactionbuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        notificactionbuilder.setContentTitle(title)
                .setColor(rgb(255,160,90))
                .setSmallIcon(R.drawable.ic_action_name)
                .setAutoCancel(true)
                .setVibrate(new long[]{0,1000,500,1000})
                .setSound(defaultsoundUri)
                .setContentInfo("info")
                .setContentText(body);


        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationchannel =
                    new NotificationChannel(NOTIFICATION_CHANNEL_ID, "FirebaseTest", NotificationManager.IMPORTANCE_DEFAULT);
            notificationchannel.setDescription("Descripcion");
            notificationchannel.enableLights(true);
            notificationchannel.setLightColor(Color.BLUE);
            notificationchannel.setVibrationPattern(new long[]{0,1000,500,1000});
            notificationManager.createNotificationChannel(notificationchannel);
        }
        notificationManager.notify(0,notificactionbuilder.build());

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
