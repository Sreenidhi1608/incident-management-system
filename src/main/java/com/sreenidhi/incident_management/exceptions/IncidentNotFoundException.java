package com.sreenidhi.incident_management.exceptions;

public class IncidentNotFoundException extends RuntimeException {

    public IncidentNotFoundException(String message) {
        super(message);
    }
}