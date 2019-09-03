package com.mockup.allexamples.notificaciones;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.RemoteInput;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mockup.allexamples.R;

import java.util.ArrayList;
import java.util.List;

import static com.mockup.allexamples.notificaciones.AppNotification.CHANNEL_1_ID;
import static com.mockup.allexamples.notificaciones.AppNotification.CHANNEL_2_ID;
public class Notificaciones extends AppCompatActivity {


    private NotificationManagerCompat notificationManagerCompat;
    private EditText texto, mensaje;
    private Button canal1, canal2;

    private MediaSessionCompat mediaSessionCompat;

    static List<Mensajes> MESSAGES = new ArrayList<>() ;

    public void sendChannel1Notification(View v) {
        envMensaje(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        texto = findViewById(R.id.edit_text_title_notificacion);
        mensaje = findViewById(R.id.edit_text_mensaje_notificacion);
        canal1 = findViewById(R.id.btnCanal1);
        canal2 = findViewById(R.id.btnCanal2);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        mediaSessionCompat = new MediaSessionCompat(this, "tag");

        MESSAGES.add(new Mensajes("Buen Dia!","Javier"));
        MESSAGES.add(new Mensajes("Hola",null));
        MESSAGES.add(new Mensajes("Hola","Sofia"));

    }

    public void envCanal1(View view) {

        String titulo = texto.getText().toString();
        String msg = mensaje.getText().toString();

        Intent intent = new Intent(this, Notificaciones.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMensaje", msg);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap iconolargo = BitmapFactory.decodeResource(getResources(),R.drawable.imagen_notificacion);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)

                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(titulo)
                .setContentText(msg)
                .setLargeIcon(iconolargo)
                .setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(getString(R.string.textolargo_notificacion))
                    .setBigContentTitle("Contenido de Texto")
                    .setSummaryText("Resumen Texto"))
                .setVibrate(new long[]{1000, 500, 1000, 1000})
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setColor(Color.GREEN)
                .addAction(R.drawable.ic_notifications,"Toast", actionIntent)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void envCanal2(View view) {

        String titulo = texto.getText().toString();
        String msg = mensaje.getText().toString();

        Bitmap imagen = BitmapFactory.decodeResource(getResources(),R.drawable.imagen_notificacion);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(titulo)
                .setContentText(msg)
                .setLargeIcon(imagen)
                .addAction(R.drawable.ic_dislike, "Dislike", null)
                .addAction(R.drawable.ic_skip_previous, "Previous", null)
                .addAction(R.drawable.ic_pause, "Pause", null)
                .addAction(R.drawable.ic_skip_next, "Next", null)
                .addAction(R.drawable.ic_like, "Like", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                            .setShowActionsInCompactView(1,2,3)
                            .setMediaSession(mediaSessionCompat.getSessionToken()))
                .setSubText("Player Music")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2, notification);
    }

    public void envCanal3(View view) {
        String titulo = texto.getText().toString();
        String msg = mensaje.getText().toString();

        Intent intent = new Intent(this, Notificaciones.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        Bitmap imagen = BitmapFactory.decodeResource(getResources(),R.drawable.imagencompletenotificacion);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)

                .setSmallIcon(R.drawable.ic_three)
                .setContentTitle(titulo)
                .setContentText(msg)
                .setLargeIcon(imagen)
                .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(imagen)
                                .bigLargeIcon(null)
                        )
                .setVibrate(new long[]{1000, 500, 1000, 1000})
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        notificationManagerCompat.notify(3, notification);
    }

    public static void envMensaje(Context context) {


        Intent activityIntent = new Intent(context, Notificaciones.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, activityIntent, 0);

        RemoteInput remoteInput = new RemoteInput.Builder("key_text_reply")
                .setLabel("Your answer...")
                .build();

        Intent replyIntent;
        PendingIntent replyPendingIntent = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            replyIntent = new Intent(context, ReplicacionDirectaReceiver.class);
            replyPendingIntent = PendingIntent.getBroadcast(context,
                    0, replyIntent, 0);
        } else {
            //start chat activity instead (PendingIntent.getActivity)
            //cancel notification with notificationManagerCompat.cancel(id)
        }

        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_reply,
                "Reply",
                replyPendingIntent
        ).addRemoteInput(remoteInput).build();

        NotificationCompat.MessagingStyle messagingStyle =
                new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group Chat");

        for (Mensajes chatMessage : MESSAGES) {
            NotificationCompat.MessagingStyle.Message notificationMessage =
                    new NotificationCompat.MessagingStyle.Message(
                            chatMessage.getText(),
                            chatMessage.getTimestamp(),
                            chatMessage.getSender()
                    );
            messagingStyle.addMessage(notificationMessage);
        }

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setStyle(messagingStyle)
                .addAction(replyAction)
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(1, notification);
    }
}
