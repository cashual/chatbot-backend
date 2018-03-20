package com.ing.cashual.chatboting.ai.rasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RasaContinueBody {

	@JsonProperty("executed_action")
	private String executedAction;

	private List<RasaEvent> events;

	public String getExecutedAction() {
		return executedAction;
	}

	public void setExecutedAction(String executedAction) {
		this.executedAction = executedAction;
	}

	public List<RasaEvent> getEvents() {
		return events;
	}

	public void setEvents(List<RasaEvent> events) {
		this.events = events;
	}
}
