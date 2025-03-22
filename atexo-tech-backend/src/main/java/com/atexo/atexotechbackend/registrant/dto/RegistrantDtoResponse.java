package com.atexo.atexotechbackend.registrant.dto;

import com.atexo.atexotechbackend.registrant.entity.Registrant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class RegistrantDtoResponse {

    private Long id ;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String uniqueIdentifier;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static RegistrantDtoResponse fromEntity (Registrant registrant) {

        if (registrant == null)
            return null;
        else {
            return RegistrantDtoResponse.builder()
                    .id(registrant.getId())
                    .firstName(registrant.getFirstName())
                    .lastName(registrant.getLastName())
                    .birthDate(registrant.getDateOfBirth())
                    .uniqueIdentifier(registrant.getUniqueIdentifier())
                    .createdAt(registrant.getCreatedAt())
                    .updatedAt(registrant.getUpdatedAt())
                    .build();
        }
    }

}
