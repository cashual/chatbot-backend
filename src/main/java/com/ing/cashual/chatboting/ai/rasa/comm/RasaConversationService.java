package com.ing.cashual.chatboting.ai.rasa.comm;

import com.ing.cashual.chatboting.ai.rasa.model.RasaContinueBody;
import com.ing.cashual.chatboting.ai.rasa.model.RasaEvent;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import com.ing.cashual.chatboting.ai.rasa.model.RasaParseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RasaConversationService {

	@Value("${ai-engine.address}")
	private String aiEngineAddress;

	private final RestTemplate restTemplate;

	public RasaConversationService(RestTemplateBuilder restTemplateBuilder) {

		this.restTemplate = restTemplateBuilder.build();
	}

	public RasaNextAction parseConversation(String conversationId, String text) {
		String url = aiEngineAddress + "/conversations/" + conversationId + "/parse";
		RasaParseBody request = new RasaParseBody();
		request.setQuery(text);
		RasaNextAction rasaNextAction = restTemplate.postForObject(url, request, RasaNextAction.class);

		return rasaNextAction;
	}

	public RasaNextAction continueConversation(String conversationId, String executedAction, List<RasaEvent> events) {
		String url = aiEngineAddress + "/conversations/" + conversationId + "/continue";
		RasaContinueBody request = new RasaContinueBody();
		request.setExecutedAction(executedAction);
		request.setEvents(events);
		RasaNextAction rasaNextAction = restTemplate.postForObject(url, request, RasaNextAction.class);

		return rasaNextAction;
	}

	public void resetConversation() {

	}

}
