package com.ing.cashual.chatboting.ai.rasa.action;

import com.ing.cashual.chatboting.ai.rasa.ActionProcessor;
import com.ing.cashual.chatboting.ai.rasa.model.RasaNextAction;

import org.springframework.stereotype.Component;

@Component
public class UploadEvidenceAction implements ActionProcessor {

	public String getActionName() {
		return "upload_evidence";
	}

	@Override
	public String performAction(RasaNextAction rasaNextAction) {
		return "generic evidence was uploaded for cm2.2 Account_interface\n" +
				"- cool, I’ve updated it in the OCD.";
	}
}
