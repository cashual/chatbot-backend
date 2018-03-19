package com.ing.cashual.chatboting.service.rasa;

import com.ing.cashual.chatboting.model.Intent;
import com.ing.cashual.chatboting.model.IntentEntity;
import com.ing.cashual.chatboting.service.ConversationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RasaConversationService implements ConversationService {

	@Value("${ai-engine.address}")
	private String aiEngineAddress;

	private final RestTemplate restTemplate;

	public RasaConversationService(RestTemplateBuilder restTemplateBuilder) {

		this.restTemplate = restTemplateBuilder.build();
	}

	public Intent parseConversation(String conversationId, String text) {
		String url = aiEngineAddress + "/conversations/" + conversationId + "/parse";
		RasaParseBody request = new RasaParseBody();
		request.setQuery(text);
		RasaNextAction result = restTemplate.postForObject(url, request, RasaNextAction.class);

		Intent intent = new Intent();
		intent.setName(result.getNextAction());
//		for(RasaEntity rasaEntity : result.getEntities()) {
//			IntentEntity intentEntity = new IntentEntity();
//			intentEntity.setName(rasaEntity.getEntity());
//			intentEntity.setValue(rasaEntity.getValue());
//			intent.addIntentEntity(intentEntity);
//		}
		return intent;
	}
}
