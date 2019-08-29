package com.mockup.allexamples.notificaciones;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String mensaje = intent.getStringExtra("toastMensaje");
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
    }
}
