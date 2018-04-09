package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaActionResponse;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

import org.springframework.stereotype.Component;

@Component
public class IntroduceBotAction implements ActionProcessor {

	public String getActionName() {
		return "utter_introduce";
	}

	@Override
	public RasaActionResponse performAction(RasaNextAction rasaNextAction) {
		return new RasaActionResponse("I am your OCD assistant BOT. You can ask me stuff about OCD and I can help you keep your OCD green.");
	}
}
