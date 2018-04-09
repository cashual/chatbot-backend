package com.ing.cashual.chatboting.ai.rasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RasaEvent {

    @JsonProperty("event")
    private String eventName;

    public RasaEvent(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
