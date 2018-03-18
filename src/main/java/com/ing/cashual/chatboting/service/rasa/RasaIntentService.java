package com.ing.cashual.chatboting.service.rasa;

import com.ing.cashual.chatboting.model.Intent;
import com.ing.cashual.chatboting.model.IntentEntity;
import com.ing.cashual.chatboting.service.IntentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RasaIntentService implements IntentService {

	@Value("${ai-engine.address}")
	private String aiEngineAddress;

	private final RestTemplate restTemplate;

	public RasaIntentService(RestTemplateBuilder restTemplateBuilder) {

		this.restTemplate = restTemplateBuilder.build();
	}

	public Intent getIntent(String text) {
		String url = aiEngineAddress + "/parse";
		RasaParseBody request = new RasaParseBody();
		request.setQ(text);
		RasaResponse result = restTemplate.postForObject(url, request, RasaResponse.class);

		Intent intent = new Intent();
		intent.setName(result.getIntent().getName());
		for(RasaEntity rasaEntity : result.getEntities()) {
			IntentEntity intentEntity = new IntentEntity();
			intentEntity.setName(rasaEntity.getEntity());
			intentEntity.setValue(rasaEntity.getValue());
			intent.addIntentEntity(intentEntity);
		}
		return intent;
	}
}
