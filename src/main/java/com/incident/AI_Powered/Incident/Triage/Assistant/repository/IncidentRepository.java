package com.incident.AI_Powered.Incident.Triage.Assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incident.AI_Powered.Incident.Triage.Assistant.model.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
