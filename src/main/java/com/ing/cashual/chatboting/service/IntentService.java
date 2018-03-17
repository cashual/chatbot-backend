package com.ing.cashual.chatboting.service;

import com.ing.cashual.chatboting.model.Message;

public interface IntentService {

	String getIntent(Message message);
}
