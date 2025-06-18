package com.incident.AI_Powered.Incident.Triage.Assistant.service;

import com.incident.AI_Powered.Incident.Triage.Assistant.model.Incident;
import com.incident.AI_Powered.Incident.Triage.Assistant.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class IncidentService {
    @Autowired
    private IncidentRepository repository;

    public Incident processIncident(Incident incident){
        Map<String,String> aiResult = callAIService(incident);

        incident.setAiCategory(aiResult.get("ai_category"));
        incident.setAiSeverity(aiResult.get("ai_severity"));
        incident.setAiSuggestedActions(aiResult.get("ai_suggested_actions"));

        return repository.save(incident);

    }

    public Iterable<Incident> getAllIncidents(){
        return repository.findAll();
    }

    private Map<String, String> callAIService(Incident incident) throws RestClientException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:5001/analyze";

        return restTemplate.postForObject(url, incident, Map.class);
    }
}
