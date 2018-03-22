package com.ing.cashual.chatboting.connector.mattermost;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

/**
 * Created by oleg_pupov on 3/22/18.
 */


@Component
public class MattermostWebSocketConnector {

    public void connect() {
        WebSocketClient client = new StandardWebSocketClient();

        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        stompClient.connect("ws://localhost:8065/api/v4/websocket", sessionHandler);

        new Scanner(System.in).nextLine(); // Don't close immediately.
    }

}
