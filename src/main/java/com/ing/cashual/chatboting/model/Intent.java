package com.ing.cashual.chatboting.model;

import java.util.ArrayList;
import java.util.List;

public class Intent {

	private String name;
	private List<IntentEntity> entities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IntentEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<IntentEntity> entities) {
		this.entities = entities;
	}

	public void addIntentEntity(IntentEntity intentEntity) {
		if (entities == null) {
			entities = new ArrayList<>();
		}
		entities.add(intentEntity);
	}
}
