package com.ing.cashual.chatboting.connector.mattermost.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by oleg_pupov on 3/21/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "email='" + email + '\'' +
                '}';
    }
}
