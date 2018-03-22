package com.ing.cashual.chatboting.connector.mattermost.json;

/**
 * Created by oleg_pupov on 3/22/18.
 */
public class Data {
    private String post;
    private String sender_name;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

}
