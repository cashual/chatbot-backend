package com.ing.cashual.chatboting.ai.rasa;

import com.ing.cashual.chatboting.ai.rasa.comm.RasaConversationService;
import com.ing.cashual.chatboting.ai.rasa.model.RasaEvent;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import com.ing.cashual.chatboting.ai.ActionProcessor;
import com.ing.cashual.chatboting.processor.DialogProcessor;
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
public class RasaDialogProcessor implements DialogProcessor, ApplicationContextAware {

	private final String DEFAULT_CONVERSATION_ID = "default";
	private final List<RasaEvent> EMPTY_EVENT_LIST = Collections.emptyList();

	@Autowired
	private RasaConversationService conversationService;

	@Autowired
	private final Map<String, ActionProcessor> actionProcessors = new HashMap<>();

	public String getResponse(String text) {
		RasaNextAction nextAction = conversationService.parseConversation(DEFAULT_CONVERSATION_ID, text);

		ActionProcessor actionProcessor = actionProcessors.get(nextAction.getNextAction());

		String responseText = actionProcessor != null ? actionProcessor.performAction(nextAction) : "I don't know what you mean.";

		RasaNextAction continueAction = conversationService.continueConversation(DEFAULT_CONVERSATION_ID, nextAction.getNextAction(), EMPTY_EVENT_LIST);

		return responseText;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Map<String, ActionProcessor> actionBeans = applicationContext.getBeansOfType(ActionProcessor.class);
		actionBeans.values().forEach(bean -> actionProcessors.put(bean.getActionName(), bean));
	}
}
