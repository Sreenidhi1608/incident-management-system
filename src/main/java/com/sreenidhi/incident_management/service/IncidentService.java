package com.sreenidhi.incident_management.service;

import com.sreenidhi.incident_management.dto.IncidentRequest;
import com.sreenidhi.incident_management.dto.IncidentResponse;
import com.sreenidhi.incident_management.entity.Incident;
import com.sreenidhi.incident_management.exceptions.IncidentNotFoundException;
import com.sreenidhi.incident_management.mapper.IncidentMapper;
import com.sreenidhi.incident_management.repository.IncidentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    // CREATE
    public IncidentResponse createIncident(IncidentRequest request) {

        Incident incident = IncidentMapper.toEntity(request);

        Incident savedIncident = incidentRepository.save(incident);

        return IncidentMapper.toResponse(savedIncident);
    }

    // GET ALL
    public List<IncidentResponse> getAllIncidents() {

        return incidentRepository.findAll()
                .stream()
                .map(IncidentMapper::toResponse)
                .toList();
    }

    // GET BY ID
    public IncidentResponse getIncidentById(Long id) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() ->
                        new IncidentNotFoundException(
                                "Incident not found with id: " + id));

        return IncidentMapper.toResponse(incident);
    }

    // UPDATE
    public IncidentResponse updateIncident(Long id, IncidentRequest request) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() ->
                        new IncidentNotFoundException(
                                "Incident not found with id: " + id));

        incident.setTitle(request.getTitle());
        incident.setDescription(request.getDescription());
        incident.setPriority(request.getPriority());
        incident.setStatus(request.getStatus());
        incident.setAssignedTo(request.getAssignedTo());

        Incident updated = incidentRepository.save(incident);

        return IncidentMapper.toResponse(updated);
    }

    // DELETE
    public void deleteIncident(Long id) {

        incidentRepository.deleteById(id);
    }

    // STATUS
    public List<IncidentResponse> getIncidentsByStatus(String status) {

        return incidentRepository.findByStatus(status)
                .stream()
                .map(IncidentMapper::toResponse)
                .toList();
    }

    // PRIORITY
    public List<IncidentResponse> getIncidentsByPriority(String priority) {

        return incidentRepository.findByPriority(priority)
                .stream()
                .map(IncidentMapper::toResponse)
                .toList();
    }

    // PAGINATION
    public Page<IncidentResponse> getIncidents(Pageable pageable) {

        return incidentRepository.findAll(pageable)
                .map(IncidentMapper::toResponse);
    }

    public Page<IncidentResponse> getAllIncidents(int page, int size) {

        return incidentRepository.findAll(PageRequest.of(page, size))
                .map(IncidentMapper::toResponse);
    }

    // SORT
    public List<IncidentResponse> getSortedIncidents(String field) {

        return incidentRepository.findAll(
                        Sort.by(Sort.Direction.ASC, field))
                .stream()
                .map(IncidentMapper::toResponse)
                .toList();
    }

    // SEARCH
    public List<IncidentResponse> searchByTitle(String title) {

        return incidentRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(IncidentMapper::toResponse)
                .toList();
    }
}