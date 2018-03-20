package com.ing.cashual.chatboting.ai.rasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RasaLatestMessage {
	private String text;
	private RasaIntent intent;
	private List<RasaEntity> entities;
	@JsonProperty("intent_ranking")
	private List<RasaIntent> intentRanking;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public RasaIntent getIntent() {
		return intent;
	}

	public void setIntent(RasaIntent intent) {
		this.intent = intent;
	}

	public List<RasaEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<RasaEntity> entities) {
		this.entities = entities;
	}

	public List<RasaIntent> getIntentRanking() {
		return intentRanking;
	}

	public void setIntentRanking(List<RasaIntent> intent_ranking) {
		this.intentRanking = intent_ranking;
	}
}
