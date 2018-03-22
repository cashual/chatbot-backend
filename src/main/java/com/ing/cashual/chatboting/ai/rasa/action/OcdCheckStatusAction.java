package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;
import com.ing.cashual.chatboting.ai.rasa.model.RasaParseBody;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

@Component
public class OcdCheckStatusAction implements ActionProcessor {

    private final String REPLY = "You have got following controls red:." +
            " gCashAPI:." +
            " - CM02.2 Secure code development process as required by Platform Security Minimum Standard?,." +
            " Account Interface:." +
            " - PS02.1 Vulnerability Scanning";

    private final String GCASH_STATUS = "This specific part of control covers the scanning of the source code of the" +
            " application" +
            " If you use  CDAAS for depoyment the secure code review is part of the process." +
            " Part of this control is also the plan for solving issues that have been detected by scanning the " +
            "application." +
            " Exploitable and suspicious issues are usually blocking and need to be adressed to obtain an " +
            " approval for change from the CIO Security team." +
            " The rest of the issues need to be analysed and require a proper risk response (mitigate, accept, " +
            "avoid, or transfer)" +
            "" +
            " there is generic evidence available for this control. I can upload it for you.";

	@Value("${ocd-server.address}")
	private String ocdServerAddress;


	private final RestTemplate restTemplate;

	public OcdCheckStatusAction(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public String getActionName() {
		return "check_status";
	}

	@Override
	public String performAction(RasaNextAction rasaNextAction) {
		String url = ocdServerAddress + "/ocd/info";
//		RasaParseBody request = new RasaParseBody();
//		request.setQ(text);
//		RasaNextAction rasaNextAction = restTemplate.postForObject(url, request, RasaNextAction.class);
        final Map<String, String> slots = rasaNextAction.getTracker().getSlots();
        String applicationName = slots.get("application-name");
        if("OCD".equals(applicationName)) {
            return REPLY;
        }
        else {
            return GCASH_STATUS;
        }
	}
}
