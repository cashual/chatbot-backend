package com.ing.cashual.chatboting.connector.mattermost.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by oleg_pupov on 3/22/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResponse {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "id='" + id + '\'' +
                '}';
    }
}
