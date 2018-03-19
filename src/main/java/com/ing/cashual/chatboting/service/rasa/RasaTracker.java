package com.ing.cashual.chatboting.service.rasa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class RasaTracker {

    @JsonProperty("sender_id")
    private String senderId;

    private Map<String,String> slots;

    @JsonProperty("latest_message")
    private RasaLatestMessage latestMessage;

    @JsonProperty("latest_event_time")
    private Double latestEventTime;

    private Boolean paused;
    private Object events;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String sender_id) {
        this.senderId = sender_id;
    }

    public Map<String, String> getSlots() {
        return slots;
    }

    public void setSlots(Map<String, String> slots) {
        this.slots = slots;
    }

    public RasaLatestMessage getLatestMessage() {
        return latestMessage;
    }

    public void setLatestMessage(RasaLatestMessage latest_message) {
        this.latestMessage = latest_message;
    }

    public Double getLatestEventTime() {
        return latestEventTime;
    }

    public void setLatestEventTime(Double latest_event_time) {
        this.latestEventTime = latest_event_time;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public Object getEvents() {
        return events;
    }

    public void setEvents(Object events) {
        this.events = events;
    }
}
