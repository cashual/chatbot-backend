package com.ing.cashual.chatboting.resource;

import com.ing.cashual.chatboting.model.Message;
import com.ing.cashual.chatboting.service.IntentService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@RestController
@RequestMapping("/question")
public class QuestionResource {

    @Autowired
    private IntentService intentService;

    @GetMapping
    public String test() {
        return "hello Ahmed";
    }

    @CrossOrigin
    @PostMapping
    public String askQuestion(final @RequestBody String JSON_DATA) throws JSONException{
        final JSONObject obj = new JSONObject(JSON_DATA);
        System.out.println("The question is: " + obj.getString("question"));

        Message message = new Message();
        message.setContent(obj.getString("question"));

        String intent = intentService.getIntent(message);
        return "The question is: " + obj.getString("question") + ". The intent is: " + intent;
    }
}
