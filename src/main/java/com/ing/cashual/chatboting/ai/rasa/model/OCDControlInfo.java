package com.ing.cashual.chatboting.ai.rasa.model;

import lombok.Setter;
import lombok.Getter;

/**
 * Created by Ovidiu on 22/03/2018.
 */
public class OCDControlInfo {
    String controlId;
    String riskArea;
    String lastUpdated;
    String expiringOn;
    String statusControl;

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getRiskArea() {
        return riskArea;
    }

    public void setRiskArea(String riskArea) {
        this.riskArea = riskArea;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getExpiringOn() {
        return expiringOn;
    }

    public void setExpiringOn(String expiringOn) {
        this.expiringOn = expiringOn;
    }

    public String getStatusControl() {
        return statusControl;
    }

    public void setStatusControl(String statusControl) {
        this.statusControl = statusControl;
    }

    @Override
    public String toString() {
        return "OCDControlInfo{" +
                "controlId='" + controlId + '\'' +
                ", riskArea='" + riskArea + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", expiringOn='" + expiringOn + '\'' +
                ", statusControl='" + statusControl + '\'' +
                '}';
    }
}
