package com.mockup.allexamples.notificaciones;

public class Mensajes {

    private CharSequence text;
    private long timestamp;
    private CharSequence sender;

    public Mensajes(CharSequence text, CharSequence sender) {
        this.text = text;
        this.sender = sender;
        timestamp = System.currentTimeMillis();
    }

    public CharSequence getText() {
        return text;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public CharSequence getSender() {
        return sender;
    }
}
