package com.sreenidhi.incident_management.repository;

import com.sreenidhi.incident_management.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByStatus(String status);

    List<Incident> findByPriority(String priority);
    List<Incident> findByTitleContainingIgnoreCase(String title);
}