package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import org.springframework.stereotype.Component;

@Component
public class GoodbyeAction implements ActionProcessor {

	public String getActionName() {
		return "utter_goodbye";
	}

	@Override
	public String performAction(RasaNextAction rasaNextAction) {
		return "Bye-bye.";
	}
}
