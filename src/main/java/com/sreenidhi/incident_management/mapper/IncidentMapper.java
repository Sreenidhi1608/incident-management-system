package com.sreenidhi.incident_management.mapper;

import com.sreenidhi.incident_management.dto.IncidentRequest;
import com.sreenidhi.incident_management.dto.IncidentResponse;
import com.sreenidhi.incident_management.entity.Incident;

public class IncidentMapper {

    public static Incident toEntity(IncidentRequest request) {

        Incident incident = new Incident();

        incident.setTitle(request.getTitle());
        incident.setDescription(request.getDescription());
        incident.setPriority(request.getPriority());
        incident.setStatus(request.getStatus());
        incident.setAssignedTo(request.getAssignedTo());

        return incident;
    }

    public static IncidentResponse toResponse(Incident incident) {

        IncidentResponse response = new IncidentResponse();

        response.setId(incident.getId());
        response.setTitle(incident.getTitle());
        response.setDescription(incident.getDescription());
        response.setPriority(incident.getPriority());
        response.setStatus(incident.getStatus());
        response.setAssignedTo(incident.getAssignedTo());
        response.setCreatedAt(incident.getCreatedAt());

        return response;
    }
}