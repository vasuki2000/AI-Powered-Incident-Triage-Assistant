package com.incident.AI_Powered.Incident.Triage.Assistant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String affectedService;


    public void setAiCategory(String aiCategory) {
        this.aiCategory = aiCategory;
    }

    private String aiCategory;

    public void setAiSeverity(String aiSeverity) {
        this.aiSeverity = aiSeverity;
    }

    private String aiSeverity;

    public void setAiSuggestedActions(String aiSuggestedActions) {
        this.aiSuggestedActions = aiSuggestedActions;
    }

    private String aiSuggestedActions;


}
