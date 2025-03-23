package com.atexo.atexotechbackend.registration.dto;

import com.atexo.atexotechbackend.registration.entity.Registration;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegistrationDtoRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    //private String uniqueIdentifier;


    public static Registration toEntity (RegistrationDtoRequest registrationDtoRequest) {

        if (registrationDtoRequest == null)
            return null;
        else{
                return Registration.builder()
                        .firstName(registrationDtoRequest.getFirstName())
                        .lastName(registrationDtoRequest.getLastName())
                        .dateOfBirth(registrationDtoRequest.getBirthDate())
                       // .uniqueIdentifier(registrationDtoRequest.getUniqueIdentifier())
                        .build();
            }
    }
}
