package com.ing.cashual.chatboting.connector.mattermost.json;

/**
 * Created by oleg_pupov on 3/21/18.
 */
public class LoginRequest {
    private final String login_id;
    private final String password;

    public LoginRequest(String login_id, String password) {
        this.login_id = login_id;
        this.password = password;
    }

    public String getLogin_id() {
        return login_id;
    }

    public String getPassword() {
        return password;
    }
}
