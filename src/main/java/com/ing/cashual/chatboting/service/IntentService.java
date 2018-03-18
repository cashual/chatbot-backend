package com.ing.cashual.chatboting.service;

import com.ing.cashual.chatboting.model.Intent;

public interface IntentService {

	Intent getIntent(String text);
}
