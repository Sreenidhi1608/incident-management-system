package com.sreenidhi.incident_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sreenidhi.incident_management.dto.IncidentRequest;
import com.sreenidhi.incident_management.dto.IncidentResponse;
import com.sreenidhi.incident_management.service.IncidentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(IncidentController.class)
class IncidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IncidentService incidentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateIncident() throws Exception {

        IncidentRequest request = new IncidentRequest();
        request.setTitle("Printer Issue");
        request.setDescription("Printer not working");
        request.setPriority("HIGH");
        request.setStatus("OPEN");
        request.setAssignedTo("Admin");

        IncidentResponse response = new IncidentResponse();
        response.setId(1L);
        response.setTitle("Printer Issue");
        response.setDescription("Printer not working");
        response.setPriority("HIGH");
        response.setStatus("OPEN");
        response.setAssignedTo("Admin");

        when(incidentService.createIncident(any(IncidentRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/incidents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Printer Issue"));
    }

    @Test
    void testGetAllIncidents() throws Exception {

        IncidentResponse response = new IncidentResponse();
        response.setId(1L);
        response.setTitle("Laptop Issue");

        when(incidentService.getAllIncidents())
                .thenReturn(List.of(response));

        mockMvc.perform(get("/api/incidents"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Laptop Issue"));
    }

    @Test
    void testGetIncidentById() throws Exception {

        IncidentResponse response = new IncidentResponse();
        response.setId(1L);
        response.setTitle("Laptop Issue");

        when(incidentService.getIncidentById(1L))
                .thenReturn(response);

        mockMvc.perform(get("/api/incidents/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Laptop Issue"));
    }

    @Test
    void testUpdateIncident() throws Exception {

        IncidentRequest request = new IncidentRequest();

        request.setTitle("Updated");
        request.setDescription("Updated Description");
        request.setPriority("HIGH");
        request.setStatus("OPEN");
        request.setAssignedTo("Admin");

        IncidentResponse response = new IncidentResponse();

        response.setId(1L);
        response.setTitle("Updated");
        response.setDescription("Updated Description");
        response.setPriority("HIGH");
        response.setStatus("OPEN");
        response.setAssignedTo("Admin");

        when(incidentService.updateIncident(any(Long.class), any(IncidentRequest.class)))
                .thenReturn(response);

        mockMvc.perform(put("/api/incidents/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated"));
    }

    @Test
    void testDeleteIncident() throws Exception {

        doNothing().when(incidentService).deleteIncident(1L);

        mockMvc.perform(delete("/api/incidents/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testStatus() throws Exception {

        IncidentResponse response = new IncidentResponse();
        response.setStatus("OPEN");

        when(incidentService.getIncidentsByStatus("OPEN"))
                .thenReturn(List.of(response));

        mockMvc.perform(get("/api/incidents/status/OPEN"))
                .andExpect(status().isOk());
    }

    @Test
    void testPriority() throws Exception {

        IncidentResponse response = new IncidentResponse();
        response.setPriority("HIGH");

        when(incidentService.getIncidentsByPriority("HIGH"))
                .thenReturn(List.of(response));

        mockMvc.perform(get("/api/incidents/priority/HIGH"))
                .andExpect(status().isOk());
    }

    @Test
    void testSearch() throws Exception {

        IncidentResponse response = new IncidentResponse();
        response.setTitle("Laptop Issue");

        when(incidentService.searchByTitle("Laptop"))
                .thenReturn(List.of(response));

        mockMvc.perform(get("/api/incidents/search")
                        .param("title", "Laptop"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Laptop Issue"));
    }

    @Test
    void testPagination() throws Exception {

        Page<IncidentResponse> page =
                new PageImpl<>(List.of(new IncidentResponse()), PageRequest.of(0,5),1);

        when(incidentService.getIncidents(any()))
                .thenReturn(page);

        mockMvc.perform(get("/api/incidents/page"))
                .andExpect(status().isOk());
    }

    @Test
    void testSorting() throws Exception {

        when(incidentService.getSortedIncidents("id"))
                .thenReturn(List.of(new IncidentResponse()));

        mockMvc.perform(get("/api/incidents/sort"))
                .andExpect(status().isOk());
    }
}