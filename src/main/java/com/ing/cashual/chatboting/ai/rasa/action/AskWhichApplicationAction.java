package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

import org.springframework.stereotype.Component;

@Component
public class AskWhichApplicationAction implements ActionProcessor {

	public String getActionName() {
		return "utter_ask_which_application";
	}

	@Override
	public String performAction(RasaNextAction rasaNextAction) {
		return "Which application?";
	}
}
