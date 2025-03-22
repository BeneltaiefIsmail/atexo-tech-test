package com.atexo.atexotechbackend.registrant;

import com.atexo.atexotechbackend.registrant.controller.RegistrantController;
import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoRequest;
import com.atexo.atexotechbackend.registrant.dto.RegistrantDtoResponse;
import com.atexo.atexotechbackend.registrant.service.RegistrantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.AssertionErrors;

public class RegistrantControllerTest {

    @Mock
    private RegistrantService registrantService; // Simule le service

    @InjectMocks
    private RegistrantController registrantController; // Contrôleur à tester

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
