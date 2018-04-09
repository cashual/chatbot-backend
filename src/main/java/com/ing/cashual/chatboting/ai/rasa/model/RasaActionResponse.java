package com.ing.cashual.chatboting.ai.rasa.model;

import java.util.ArrayList;
import java.util.List;

public class RasaActionResponse {

    private final String responseText;
    private final List<RasaEvent> events = new ArrayList<>();

    public RasaActionResponse(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseText() {
        return responseText;
    }

    public List<RasaEvent> getEvents() {
        return events;
    }

    public void addEvent(RasaEvent rasaEvent) {
        events.add(rasaEvent);
    }
}