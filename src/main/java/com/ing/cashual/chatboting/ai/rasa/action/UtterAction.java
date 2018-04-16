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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UtterAction implements ActionProcessor {

	@Autowired
	@Qualifier("utterActionMap")
	private Map<String,List<String>> utterActionMap;

	private static final Random RANDOM = new Random();
	private static final Pattern PATTERN = Pattern.compile("\\$\\{([^}]*)\\}");

	public boolean supportsAction(String actionName) {
		return utterActionMap.containsKey(actionName);
	}

	@Override
	public RasaActionResponse performAction(RasaNextAction rasaNextAction) {
		List<String> actionResponses = utterActionMap.get(rasaNextAction.getNextAction());
		final int i = RANDOM.nextInt(actionResponses.size());
		String actionResponse = actionResponses.get(i);

		// substitute {entity-name} with "" or entity-value
		Matcher matcher = PATTERN.matcher(actionResponse);
		StringBuilder responseText = new StringBuilder(actionResponse.length());
		while(matcher.find()) {
			String propertyName = matcher.group(1);
			matcher.appendReplacement(responseText, Matcher.quoteReplacement(getPropertyValue(rasaNextAction, propertyName)));
		}
		matcher.appendTail(responseText);
		return new RasaActionResponse(responseText.toString());
	}

	private String getPropertyValue(RasaNextAction rasaNextAction, String propertyName) {

		String propertyValue = rasaNextAction.getTracker().getSlots().get(propertyName);

		return propertyValue == null ? "" : propertyValue;
	}

}
