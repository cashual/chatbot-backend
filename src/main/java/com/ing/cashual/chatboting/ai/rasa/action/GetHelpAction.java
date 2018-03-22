package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetHelpAction implements ActionProcessor {

	public String getActionName() {
		return "get_help";
	}

	@Override
	public String performAction(RasaNextAction rasaNextAction) {
		return "I am here to help you.\nYou can ask me about OCD and its controls. I can check their status and update them for you.";
	}
}
