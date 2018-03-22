package com.ing.cashual.chatboting.ai.rasa.model;

/**
 * Created by Ovidiu on 22/03/2018.
 */
public class OCDControlUpdate {
    String appId;
    String controlId;

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
