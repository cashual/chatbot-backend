package com.ing.cashual.chatboting.processor;

import com.ing.cashual.chatboting.model.Intent;

public interface IntentProcessor {

	String getIntentId();

	String processIntent(Intent intent);
}
