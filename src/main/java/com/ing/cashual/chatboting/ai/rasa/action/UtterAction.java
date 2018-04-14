package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaActionResponse;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class UtterAction implements ActionProcessor {

	@Autowired
	@Qualifier("utterActionMap")
	private Map<String,List<String>> utterActionMap;

	private Random rand = new Random();

	public boolean supportsAction(String actionName) {
		return utterActionMap.containsKey(actionName);
	}

	@Override
	public RasaActionResponse performAction(RasaNextAction rasaNextAction) {
		List<String> actionResponses = utterActionMap.get(rasaNextAction.getNextAction());
		final int i = rand.nextInt(actionResponses.size());
		return new RasaActionResponse(actionResponses.get(i));
	}
}
