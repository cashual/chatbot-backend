package com.ing.cashual.chatboting.ai.rasa;

import com.ing.cashual.chatboting.ai.rasa.model.RasaActionResponse;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

public interface ActionProcessor {

	boolean supportsAction(String actionName);

	RasaActionResponse performAction(RasaNextAction nextAction);
}
