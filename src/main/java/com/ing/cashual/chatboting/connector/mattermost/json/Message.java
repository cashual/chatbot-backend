package com.ing.cashual.chatboting.connector.mattermost.json;

/**
 * Created by oleg_pupov on 3/22/18.
 */
public class Message {



    private String from;
    private String text;

    public String getText() {
        return text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setText(String text) {
        this.text = text;
    }

}