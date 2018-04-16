package com.ing.cashual.chatboting.ai.rasa;

import com.ing.cashual.chatboting.ai.rasa.comm.RasaConversationService;
import com.ing.cashual.chatboting.ai.rasa.model.RasaActionResponse;
import com.ing.cashual.chatboting.ai.rasa.model.RasaEvent;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import com.ing.cashual.chatboting.ai.DialogProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RasaDialogProcessor implements DialogProcessor {

	private final String ACTION_LISTEN = "action_listen";

	private final String DEFAULT_CONVERSATION_ID = "default";

	@Autowired
	private RasaConversationService conversationService;

	@Autowired
	private List<ActionProcessor> actionProcessors;

	public String getResponse(String text) {

		StringBuilder responseText = new StringBuilder();

		RasaNextAction nextAction = conversationService.parseConversation(DEFAULT_CONVERSATION_ID, text);

		//TODO if next action is listen, reset the conversation and clear all events

		while( ! ACTION_LISTEN.equals(nextAction.getNextAction())) {

			ActionProcessor actionProcessor = getActionProcessor(nextAction);
			RasaActionResponse rasaActionResponse = actionProcessor != null ? actionProcessor.performAction(nextAction) : new RasaActionResponse("I don't know what you mean.");
			if(responseText.length() > 0) {
				responseText.append("\n");
			}
			responseText.append(rasaActionResponse.getResponseText());
			nextAction = conversationService.continueConversation(DEFAULT_CONVERSATION_ID, nextAction.getNextAction(), rasaActionResponse.getEvents());
		}

		return responseText.toString();
	}

	private ActionProcessor getActionProcessor(RasaNextAction nextAction) {
		for(ActionProcessor actionProcessor : actionProcessors) {
			if(actionProcessor.supportsAction(nextAction.getNextAction()))
				return actionProcessor;
		}
		return null;
	}
}
