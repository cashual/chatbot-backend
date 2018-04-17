package com.ing.cashual.chatboting.resource;

import com.ing.cashual.chatboting.ai.DialogProcessor;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionResource.class);

    @Autowired
    private DialogProcessor dialogProcessor;

    @GetMapping
    public String test() {
        return "hello Ahmed";
    }

    @CrossOrigin
    @PostMapping
    public String askQuestion(final @RequestBody String JSON_DATA) throws JSONException{
        final JSONObject obj = new JSONObject(JSON_DATA);
        LOGGER.info("The question is: " + obj.getString("question"));

        String response = dialogProcessor.getResponse(obj.getString("question"));

        LOGGER.info("The question is: " + obj.getString("question") + ". The response is: " + response);

        return response;
    }
}
