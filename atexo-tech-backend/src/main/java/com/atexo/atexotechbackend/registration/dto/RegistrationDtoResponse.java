package com.atexo.atexotechbackend.registration.dto;

import com.atexo.atexotechbackend.registration.entity.Registration;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class RegistrationDtoResponse {

    private Long id ;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String uniqueIdentifier;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static RegistrationDtoResponse fromEntity (Registration registration) {

        if (registration == null)
            return null;
        else {
            return RegistrationDtoResponse.builder()
                    .id(registration.getId())
                    .firstName(registration.getFirstName())
                    .lastName(registration.getLastName())
                    .birthDate(registration.getDateOfBirth())
                    .uniqueIdentifier(registration.getUniqueIdentifier())
                    .createdAt(registration.getCreatedAt())
                    .updatedAt(registration.getUpdatedAt())
                    .build();
        }
    }

}
