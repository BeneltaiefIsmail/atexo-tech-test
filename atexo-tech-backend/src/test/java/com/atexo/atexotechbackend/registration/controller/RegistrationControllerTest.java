package com.atexo.atexotechbackend.registration.controller;

import com.atexo.atexotechbackend.registration.dto.RegistrationDtoRequest;
import com.atexo.atexotechbackend.registration.dto.RegistrationDtoResponse;
import com.atexo.atexotechbackend.registration.service.RegistrationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDate;

import static org.mockito.Mockito.*;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private RegistrationService registrationService;
    @InjectMocks
    private RegistrationController registrationController;

    @Test
    public void testCreateRegistration() throws Exception {
        RegistrationDtoRequest request = RegistrationDtoRequest.builder()
                .firstName("Ismail")
                .lastName("Beneltaief")
                .birthDate(LocalDate.of(1996, 2, 6))
                .build();
        //Result
        RegistrationDtoResponse response = RegistrationDtoResponse.builder()
                .id(1L)
                .firstName("Ismail")
                .lastName("Beneltaief")
                .birthDate(LocalDate.of(1996, 2, 6))
                .uniqueIdentifier("ABC123")
                .build();
        // Simulation de l'appel au service
        when(registrationService.create(request)).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/registrations")
                .contentType(MediaType.APPLICATION_JSON));
        verify(registrationService, times(1)).create(request);
    }
}
