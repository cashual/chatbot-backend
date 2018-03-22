package com.ing.cashual.chatboting.connector.mattermost;


import com.google.gson.Gson;
import com.ing.cashual.chatboting.connector.mattermost.json.MattermostEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by oleg_pupov on 3/22/18.
 */


@Component
public class MattermostWebSocketConnector {

    @Autowired
    private MattermostHttpConnector mattermostHttpConnector;

    private WebsocketClientEndpoint clientEndPoint;

    @Value("${user-we-talk-to}")
    private String userName;

    @PostConstruct
    private void connect() {

        try {
            // open websocket
            clientEndPoint = new WebsocketClientEndpoint(new URI("ws://localhost:8065/api/v4/websocket"));

            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {

                    String[] tokens = message.split(",");

                    String messageString = null;
                    for (String token:tokens) {
                        if (token.contains("\\\"message\\\":")) {
                            messageString = token;
                            messageString = messageString.substring(14,messageString.length()-2);
                            break;
                        }
                    }



                    Gson gson = new Gson();
                    MattermostEvent mattermostEvent = gson.fromJson(message, MattermostEvent.class);

                    if ("posted".equals(mattermostEvent.getEvent())
                            && userName.equals(mattermostEvent.getData().getSender_name())) {

                        mattermostHttpConnector.postMessage("you've just told me: " + messageString);
                    }

                }
            });

            // send message to websocket
            clientEndPoint.sendMessage(
                    "{\n" +
                            "  \"seq\": 1,\n" +
                            "  \"action\": \"authentication_challenge\",\n" +
                            "  \"data\": {\n" +
                            "    \"token\": \"pre3anp4c3dw5n8wubbu9tz4ja\"\n" +
                            "  }\n" +
                            "}");

        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }

    }

    public void addMessageHandler(WebsocketClientEndpoint.MessageHandler messageHandler) {
        clientEndPoint.addMessageHandler(messageHandler);
    }

}