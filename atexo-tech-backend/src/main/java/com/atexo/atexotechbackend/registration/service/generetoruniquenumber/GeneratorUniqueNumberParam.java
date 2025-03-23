package com.atexo.atexotechbackend.registration.service.generetoruniquenumber;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GeneratorUniqueNumberParam {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
