package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaActionResponse;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

import org.springframework.stereotype.Component;

@Component
public class AskNameAction implements ActionProcessor {

	public String getActionName() {
		return "utter_ask_name";
	}

	@Override
	public RasaActionResponse performAction(RasaNextAction rasaNextAction) {
		return new RasaActionResponse("What is your name?");
	}
}
