package com.sreenidhi.incident_management.service;

import com.sreenidhi.incident_management.dto.IncidentRequest;
import com.sreenidhi.incident_management.dto.IncidentResponse;
import com.sreenidhi.incident_management.entity.Incident;
import com.sreenidhi.incident_management.repository.IncidentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IncidentServiceTest {

    @Mock
    private IncidentRepository incidentRepository;

    @InjectMocks
    private IncidentService incidentService;

    @Test
    void testCreateIncident() {

        IncidentRequest request = new IncidentRequest();
        request.setTitle("Printer Issue");
        request.setDescription("Printer not working");
        request.setPriority("HIGH");
        request.setStatus("OPEN");
        request.setAssignedTo("Admin");

        Incident incident = new Incident();
        incident.setId(1L);
        incident.setTitle(request.getTitle());
        incident.setDescription(request.getDescription());
        incident.setPriority(request.getPriority());
        incident.setStatus(request.getStatus());
        incident.setAssignedTo(request.getAssignedTo());

        when(incidentRepository.save(any(Incident.class)))
                .thenReturn(incident);

        IncidentResponse response = incidentService.createIncident(request);

        assertNotNull(response);
        assertEquals("Printer Issue", response.getTitle());

        verify(incidentRepository).save(any(Incident.class));
    }

    @Test
    void testGetAllIncidents() {

        Incident incident = new Incident();
        incident.setId(1L);
        incident.setTitle("Laptop Issue");

        when(incidentRepository.findAll())
                .thenReturn(List.of(incident));

        List<IncidentResponse> list = incidentService.getAllIncidents();

        assertEquals(1, list.size());
        assertEquals("Laptop Issue", list.get(0).getTitle());
    }

    @Test
    void testGetIncidentById() {

        Incident incident = new Incident();
        incident.setId(1L);
        incident.setTitle("Laptop");

        when(incidentRepository.findById(1L))
                .thenReturn(Optional.of(incident));

        IncidentResponse response = incidentService.getIncidentById(1L);

        assertEquals(1L, response.getId());
    }

    @Test
    void testUpdateIncident() {

        Incident existing = new Incident();
        existing.setId(1L);
        existing.setTitle("Old");

        IncidentRequest request = new IncidentRequest();
        request.setTitle("New");
        request.setDescription("Updated");
        request.setPriority("HIGH");
        request.setStatus("CLOSED");
        request.setAssignedTo("Alice");

        when(incidentRepository.findById(1L))
                .thenReturn(Optional.of(existing));

        when(incidentRepository.save(any(Incident.class)))
                .thenAnswer(i -> i.getArgument(0));

        IncidentResponse response =
                incidentService.updateIncident(1L, request);

        assertEquals("New", response.getTitle());
        assertEquals("HIGH", response.getPriority());
    }

    @Test
    void testDeleteIncident() {

        incidentService.deleteIncident(1L);

        verify(incidentRepository).deleteById(1L);
    }

    @Test
    void testGetByStatus() {

        Incident incident = new Incident();
        incident.setStatus("OPEN");

        when(incidentRepository.findByStatus("OPEN"))
                .thenReturn(List.of(incident));

        List<IncidentResponse> list =
                incidentService.getIncidentsByStatus("OPEN");

        assertEquals(1, list.size());
    }

    @Test
    void testGetByPriority() {

        Incident incident = new Incident();
        incident.setPriority("HIGH");

        when(incidentRepository.findByPriority("HIGH"))
                .thenReturn(List.of(incident));

        List<IncidentResponse> list =
                incidentService.getIncidentsByPriority("HIGH");

        assertEquals(1, list.size());
    }

    @Test
    void testSearch() {

        Incident incident = new Incident();
        incident.setTitle("Laptop Issue");

        when(incidentRepository.findByTitleContainingIgnoreCase("Laptop"))
                .thenReturn(List.of(incident));

        List<IncidentResponse> list =
                incidentService.searchByTitle("Laptop");

        assertEquals(1, list.size());
    }

    @Test
    void testPagination() {

        Pageable pageable = PageRequest.of(0,5);

        Page<Incident> page =
                new PageImpl<>(List.of(new Incident()));

        when(incidentRepository.findAll(pageable))
                .thenReturn(page);

        Page<IncidentResponse> result =
                incidentService.getIncidents(pageable);

        assertEquals(1,result.getTotalElements());
    }

    @Test
    void testSorting() {

        when(incidentRepository.findAll(any(Sort.class)))
                .thenReturn(List.of(new Incident()));

        List<IncidentResponse> list =
                incidentService.getSortedIncidents("id");

        assertEquals(1,list.size());
    }
}