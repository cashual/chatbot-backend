package com.ing.cashual.chatboting.processor.support;

import com.ing.cashual.chatboting.model.Intent;
import com.ing.cashual.chatboting.processor.IntentProcessor;
import org.springframework.stereotype.Component;

@Component
public class GoodbyeProcessor implements IntentProcessor {

	public String getIntentId() {
		return "goodbye";
	}

	@Override
	public String processIntent(Intent intent) {
		return "Bye-bye.";
	}
}
