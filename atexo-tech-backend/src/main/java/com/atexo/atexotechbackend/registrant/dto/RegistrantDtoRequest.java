package com.atexo.atexotechbackend.registrant.dto;

import com.atexo.atexotechbackend.registrant.entity.Registrant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegistrantDtoRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String uniqueIdentifier;


    public static Registrant toEntity (RegistrantDtoRequest registrantDtoRequest) {

        if (registrantDtoRequest == null)
            return null;
        else{
                return Registrant.builder()
                        .firstName(registrantDtoRequest.getFirstName())
                        .lastName(registrantDtoRequest.getLastName())
                        .dateOfBirth(registrantDtoRequest.getBirthDate())
                        .uniqueIdentifier(registrantDtoRequest.getUniqueIdentifier())
                        .build();
            }
    }
}
