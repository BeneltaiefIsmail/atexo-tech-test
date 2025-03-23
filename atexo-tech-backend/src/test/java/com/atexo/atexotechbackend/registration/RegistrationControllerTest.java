package com.atexo.atexotechbackend.registration;

import com.atexo.atexotechbackend.registration.controller.RegistrationController;
import com.atexo.atexotechbackend.registration.service.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RegistrationControllerTest {

    @Mock
    private RegistrationService registrationService; // Simule le service

    @InjectMocks
    private RegistrationController registrationController; // Contrôleur à tester

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialise les mocks
    }
    @Test
    void testCreateRegistrant() {
    }
    @Test
    void testGetRegistrantById() {
    }
    @Test
    void testGetAllRegistrants() {
    }

    @Test
    void testDeleteRegistrant() {
    }

    @Test
    void testUpdateRegistrant() {
    }

    @Test
    void testGetRegistrantById_NotFound() {
    }
}
