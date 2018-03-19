package com.ing.cashual.chatboting.service;

import com.ing.cashual.chatboting.model.Intent;

public interface ConversationService {

	Intent parseConversation(String conversationId, String text);
}
