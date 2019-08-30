package com.mockup.allexamples.notificaciones;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;

import com.mockup.allexamples.MainActivity;

public class ReplicacionDirectaReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);


        if (remoteInput != null) {
            CharSequence replyText = remoteInput.getCharSequence("key_text_reply");
            Mensajes answer = new Mensajes(replyText, null);
            Notificaciones.MESSAGES.add(answer);

            Notificaciones.envMensaje(context);
        }

    }
}
