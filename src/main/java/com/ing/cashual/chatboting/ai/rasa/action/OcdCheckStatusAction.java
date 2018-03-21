package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import com.ing.cashual.chatboting.ai.rasa.model.RasaParseBody;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OcdCheckStatusAction implements ActionProcessor {

	@Value("${ocd-server.address}")
	private String ocdServerAddress;


	private final RestTemplate restTemplate;

	public OcdCheckStatusAction(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public String getActionName() {
		return "utter_ocd_status";
	}

	@Override
	public String performAction(RasaNextAction rasaNextAction) {
		String url = ocdServerAddress + "/ocd/info";
//		RasaParseBody request = new RasaParseBody();
//		request.setQuery(text);
//		RasaNextAction rasaNextAction = restTemplate.postForObject(url, request, RasaNextAction.class);
		return "Your OCD is fine";
	}
}
