package com.ing.cashual.chatboting.ai.rasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RasaNextAction {

    @JsonProperty("next_action")
    private String nextAction;

    private RasaTracker tracker;

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String next_action) {
        this.nextAction = next_action;
    }

    public RasaTracker getTracker() {
        return tracker;
    }

    public void setTracker(RasaTracker tracker) {
        this.tracker = tracker;
    }
}
