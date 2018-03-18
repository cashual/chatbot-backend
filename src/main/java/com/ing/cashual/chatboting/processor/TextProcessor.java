package com.ing.cashual.chatboting.processor;

import com.ing.cashual.chatboting.model.Intent;
import com.ing.cashual.chatboting.service.IntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TextProcessor {

	@Autowired
	private IntentService intentService;

	@Autowired
	private List<IntentProcessor> intentProcessors;

	public String getResponse(String text) {
		Intent intent = intentService.getIntent(text);

		for(IntentProcessor intentProcessor : intentProcessors) {
			if(intentProcessor.getIntentId().equals(intent.getName())) {
				return intentProcessor.processIntent(intent);
			}
		}

		return "I don't know what you mean by " + text;
	}
}
