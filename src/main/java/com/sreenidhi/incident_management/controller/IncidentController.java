package com.sreenidhi.incident_management.controller;

import com.sreenidhi.incident_management.dto.IncidentRequest;
import com.sreenidhi.incident_management.dto.IncidentResponse;
import com.sreenidhi.incident_management.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public IncidentResponse createIncident(
            @Valid @RequestBody IncidentRequest request) {

        return incidentService.createIncident(request);
    }

    @GetMapping
    public List<IncidentResponse> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public IncidentResponse getIncidentById(@PathVariable Long id) {
        return incidentService.getIncidentById(id);
    }

    @PutMapping("/{id}")
    public IncidentResponse updateIncident(
            @PathVariable Long id,
            @Valid @RequestBody IncidentRequest request) {

        return incidentService.updateIncident(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
    }

    @GetMapping("/status/{status}")
    public List<IncidentResponse> getIncidentsByStatus(
            @PathVariable String status) {

        return incidentService.getIncidentsByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public List<IncidentResponse> getIncidentsByPriority(
            @PathVariable String priority) {

        return incidentService.getIncidentsByPriority(priority);
    }

    @GetMapping("/page")
    public Page<IncidentResponse> getIncidentsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return incidentService.getIncidents(
                PageRequest.of(page, size));
    }

    @GetMapping("/sort")
    public List<IncidentResponse> getSortedIncidents(
            @RequestParam(defaultValue = "id") String field) {

        return incidentService.getSortedIncidents(field);
    }

    @GetMapping("/search")
    public List<IncidentResponse> searchIncidents(
            @RequestParam String title) {

        return incidentService.searchByTitle(title);
    }
}