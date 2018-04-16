package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaActionResponse;
import com.ing.cashual.chatboting.ai.rasa.model.RasaEventRestart;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

import org.springframework.stereotype.Component;

@Component
public class RestartAction implements ActionProcessor {

	private static final String ACTION="action_restart";

	public boolean supportsAction(String actionName) {
		return ACTION.equals(actionName);
	}

	@Override
	public RasaActionResponse performAction(RasaNextAction rasaNextAction) {
		RasaActionResponse response = new RasaActionResponse("Conversation restarted.");
		response.addEvent(new RasaEventRestart());
		return response;
	}
}
