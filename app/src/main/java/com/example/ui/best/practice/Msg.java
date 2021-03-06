package com.example.ui.best.practice;

public class Msg {
    public static final int TYPE_RECEIVED = 0;

    public static final int TYPE_SEND = 1;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    private String content;

    private int type;


}
