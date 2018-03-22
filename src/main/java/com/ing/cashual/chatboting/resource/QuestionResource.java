package com.ing.cashual.chatboting.resource;

import com.ing.cashual.chatboting.ai.DialogProcessor;
import com.ing.cashual.chatboting.connector.mattermost.MattermostHttpConnector;
import com.ing.cashual.chatboting.connector.mattermost.MattermostWebSocketConnector;
import com.ing.cashual.chatboting.connector.mattermost.WebsocketClientEndpoint;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/question")
public class QuestionResource {

    @Autowired
    private DialogProcessor dialogProcessor;

    @Autowired
    private MattermostHttpConnector mattermostHttpConnector;

    @Autowired
    private MattermostWebSocketConnector mattermostWebSocketConnector;

    @GetMapping
    public String test() {
        mattermostHttpConnector.postMessage("hjkhk");

        return "hello Ahmed";
    }

    @GetMapping(path = "/websocket")
    public String testSocket() {

        try {
            // open websocket
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://localhost:8065/api/v4/websocket"));

            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);
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

            // wait 10 seconds for messages from websocket
            Thread.sleep(10000);

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }

        return "hello Ahmed";
    }


    @CrossOrigin
    @PostMapping
    public String askQuestion(final @RequestBody String JSON_DATA) throws JSONException{
        final JSONObject obj = new JSONObject(JSON_DATA);
        System.out.println("The question is: " + obj.getString("question"));

        String response = dialogProcessor.getResponse(obj.getString("question"));

        System.out.println("The question is: " + obj.getString("question") + ". The response is: " + response);

        return response;
    }
}
