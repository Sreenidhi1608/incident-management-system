package com.sreenidhi.incident_management.repository;

import com.sreenidhi.incident_management.entity.Incident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IncidentRepositoryTest {

    @Autowired
    private IncidentRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();

        Incident i1 = new Incident();
        i1.setTitle("Laptop Issue");
        i1.setDescription("Laptop not working");
        i1.setPriority("HIGH");
        i1.setStatus("OPEN");
        i1.setAssignedTo("John");

        Incident i2 = new Incident();
        i2.setTitle("Printer Issue");
        i2.setDescription("Printer jam");
        i2.setPriority("LOW");
        i2.setStatus("CLOSED");
        i2.setAssignedTo("Alice");

        repository.save(i1);
        repository.save(i2);
    }

    @Test
    void testFindByStatus() {

        List<Incident> list = repository.findByStatus("OPEN");

        assertEquals(1, list.size());
        assertEquals("Laptop Issue", list.get(0).getTitle());
    }

    @Test
    void testFindByPriority() {

        List<Incident> list = repository.findByPriority("HIGH");

        assertEquals(1, list.size());
        assertEquals("Laptop Issue", list.get(0).getTitle());
    }

    @Test
    void testFindByTitleContainingIgnoreCase() {

        List<Incident> list = repository.findByTitleContainingIgnoreCase("printer");

        assertEquals(1, list.size());
        assertEquals("Printer Issue", list.get(0).getTitle());
    }

    @Test
    void testSaveIncident() {

        Incident incident = new Incident();
        incident.setTitle("Server Down");
        incident.setDescription("Server crashed");
        incident.setPriority("HIGH");
        incident.setStatus("OPEN");
        incident.setAssignedTo("Admin");

        Incident saved = repository.save(incident);

        assertNotNull(saved.getId());
    }

    @Test
    void testFindAll() {

        List<Incident> list = repository.findAll();

        assertEquals(2, list.size());
    }
}