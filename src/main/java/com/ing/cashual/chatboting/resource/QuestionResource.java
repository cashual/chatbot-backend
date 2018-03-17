package com.ing.cashual.chatboting.resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONString;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@RestController
@RequestMapping("/question")
public class QuestionResource {

    @GetMapping
    public String test() {
        return "hello Ahmed";
    }

    @CrossOrigin
    @PostMapping
    public String askQuestion(final @RequestBody String JSON_DATA) throws JSONException{
        final JSONObject obj = new JSONObject(JSON_DATA);
        System.out.println("The question is: " + obj.getString("question"));
        return "The question is: " + obj.getString("question");
    }
}
