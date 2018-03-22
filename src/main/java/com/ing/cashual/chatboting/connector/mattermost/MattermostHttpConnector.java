package com.ing.cashual.chatboting.connector.mattermost;

import com.ing.cashual.chatboting.connector.mattermost.json.LoginRequest;
import com.ing.cashual.chatboting.connector.mattermost.json.LoginResponse;
import com.ing.cashual.chatboting.connector.mattermost.json.PostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by oleg_pupov on 3/21/18.
 */
@Component
public class MattermostHttpConnector {
    private static final Logger log = LoggerFactory.getLogger(MattermostHttpConnector.class);

    @Value("${mattermost.url.login}")
    private String loginUrl;

    @Value("${mattermost.url.post}")
    private String postUrl;

    @Value("${mattermost.bot.login}")
    private String login;

    @Value("${mattermost.bot.password}")
    private String password;

    private String token;

    private void login() {
        System.out.println("i am here");
        LoginRequest loginRequest = new LoginRequest(login, password);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.postForEntity(loginUrl, loginRequest, LoginResponse.class);
        token = responseEntity.getHeaders().getFirst("Token");
        log.info("Token: " + token);
    }

    public void postMessage(String msg) {
        if (null == token) {
            login();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        String message = "{\"file_ids\":[],\"message\":\"new message 5 test\",\"channel_id\":\"rqj148uymjfmud1m6cru51pnew\",\"pending_post_id\":\"qrceuchagtym7krbxry4x9e61h:1521665818904\",\"user_id\":\"qrceuchagtym7krbxry4x9e61h\",\"create_at\":0,\"update_at\":1521665818906}";

        HttpEntity<String> requestHttpEntity = new HttpEntity<String>(message, headers);

        log.info("post body: ", requestHttpEntity.getBody().toString());
        log.info("post headers: ", requestHttpEntity.getHeaders().toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PostResponse> responseEntity = restTemplate.postForEntity(postUrl, requestHttpEntity, PostResponse.class);

        log.info(responseEntity.getBody().toString());

    }

}
