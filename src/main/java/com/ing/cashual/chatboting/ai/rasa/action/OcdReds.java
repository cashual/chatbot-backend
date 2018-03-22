package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.OCDControlInfo;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class OcdReds implements ActionProcessor {

	public static String APP_ID = "application-name";

	@Value("${ocd-server.address}")
	private String ocdServerAddress;


	private final RestTemplate restTemplate;

	public OcdReds(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public String getActionName() {
		return "utter_status";
	}

	@Override
	public String performAction(RasaNextAction rasaNextAction) {
		String appId = rasaNextAction.getTracker().getSlots().get(APP_ID);
		String url = ocdServerAddress + "/reds/" + appId;
		OCDControlInfo[] response = restTemplate.getForObject(url, OCDControlInfo[].class);
		if(response.length == 0) {
			return "All is well";
		} else {
			return "Your reds are: \n" + Arrays.stream(response).map(OCDControlInfo::toString).collect(Collectors.joining("\n"));
		}
	}
}
