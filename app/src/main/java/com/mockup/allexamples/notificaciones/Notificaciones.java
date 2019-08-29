package com.mockup.allexamples.notificaciones;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mockup.allexamples.R;
import static com.mockup.allexamples.notificaciones.AppNotification.CHANNEL_1_ID;
import static com.mockup.allexamples.notificaciones.AppNotification.CHANNEL_2_ID;
public class Notificaciones extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private EditText texto, mensaje;
    private Button canal1, canal2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        texto = findViewById(R.id.edit_text_title_notificacion);
        mensaje = findViewById(R.id.edit_text_mensaje_notificacion);
        canal1 = findViewById(R.id.btnCanal1);
        canal2 = findViewById(R.id.btnCanal2);

        notificationManagerCompat = NotificationManagerCompat.from(this);
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



        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(titulo)
                .setContentText(msg)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Linea 1").addLine("Linea 2").addLine("Linea 3").addLine("Linea 4").addLine("Linea 5").addLine("Linea 6")
                        .setBigContentTitle("Contenido de Texto")
                        .setSummaryText("Resumen Texto")
                        )

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
}
