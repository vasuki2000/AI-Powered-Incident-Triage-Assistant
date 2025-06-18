package com.incident.AI_Powered.Incident.Triage.Assistant.controller;

import com.incident.AI_Powered.Incident.Triage.Assistant.model.Incident;
import com.incident.AI_Powered.Incident.Triage.Assistant.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incidents")
public class IncidentReportController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public ResponseEntity<Incident> createIncident (@RequestBody Incident incident){
        return  ResponseEntity.ok(incidentService.processIncident(incident));
    }

    @GetMapping
    public ResponseEntity<Iterable<Incident>> getAllIncidents(){
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }

}

