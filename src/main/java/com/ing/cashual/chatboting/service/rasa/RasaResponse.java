package com.ing.cashual.chatboting.service.rasa;

import java.util.List;

public class RasaResponse {
	private String text;
	private RasaIntent intent;
	private List<RasaEntity> entities;
	private List<RasaIntent> intent_ranking;

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

	public List<RasaIntent> getIntent_ranking() {
		return intent_ranking;
	}

	public void setIntent_ranking(List<RasaIntent> intent_ranking) {
		this.intent_ranking = intent_ranking;
	}
}
