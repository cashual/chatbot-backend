package com.ing.cashual.chatboting.ai.rasa.comm;

import com.ing.cashual.chatboting.ai.rasa.model.RasaContinueBody;
import com.ing.cashual.chatboting.ai.rasa.model.RasaEvent;
import com.ing.cashual.chatboting.ai.rasa.model.RasaLatestMessage;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import com.ing.cashual.chatboting.ai.rasa.model.RasaParseBody;
import com.ing.cashual.chatboting.ai.rasa.model.RasaTracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RasaConversationService {

	@Value("${ai-engine.address}")
	private String aiEngineAddress;

	private final RestTemplate restTemplate;

	public RasaConversationService(RestTemplateBuilder restTemplateBuilder) {

		this.restTemplate = restTemplateBuilder.build();
	}

	public RasaNextAction parseConversation(String conversationId, String text) {
//		String url = aiEngineAddress + "/conversations/" + conversationId + "/parse";
		String url = aiEngineAddress + "/parse";
		RasaParseBody request = new RasaParseBody();
		request.setQ(text);
		RasaLatestMessage rasaLatestMessage = restTemplate.postForObject(url, request, RasaLatestMessage.class);

		RasaNextAction rasaNextAction = new RasaNextAction();
		RasaTracker rasaTracker = new RasaTracker();
		rasaTracker.setLatestMessage(rasaLatestMessage);
		rasaNextAction.setTracker(rasaTracker);
		rasaNextAction.setNextAction(rasaLatestMessage.getIntent().getName());

		Map<String,String> slots = new HashMap<>();

		rasaLatestMessage.getEntities().forEach(e -> slots.put(e.getEntity(), e.getValue()));
		rasaTracker.setSlots(slots);

		return rasaNextAction;
	}

	public RasaNextAction continueConversation(String conversationId, String executedAction, List<RasaEvent> events) {
//		String url = aiEngineAddress + "/conversations/" + conversationId + "/continue";
//		RasaContinueBody request = new RasaContinueBody();
//		request.setExecutedAction(executedAction);
//		request.setEvents(events);
//		RasaNextAction rasaNextAction = restTemplate.postForObject(url, request, RasaNextAction.class);
//
//		return rasaNextAction;
		return null;
	}

}
