package com.atexo.atexotechbackend.registration.dto;

import com.atexo.atexotechbackend.registration.entity.Registration;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegistrationDtoRequest {
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    @NotNull(message = "the birthdate is Mandatory ")
    @Past(message = "The date must be in the past")
    private LocalDate birthDate;
    //private String uniqueIdentifier;
    public static Registration toEntity (RegistrationDtoRequest registrationDtoRequest) {
                return Registration.builder()
                        .firstName(registrationDtoRequest.getFirstName())
                        .lastName(registrationDtoRequest.getLastName())
                        .dateOfBirth(registrationDtoRequest.getBirthDate())
                       // .uniqueIdentifier(registrationDtoRequest.getUniqueIdentifier())
                        .build();
            }
}
