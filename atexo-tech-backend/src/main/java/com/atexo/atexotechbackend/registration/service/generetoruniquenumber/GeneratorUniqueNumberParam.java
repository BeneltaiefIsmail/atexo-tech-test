package com.atexo.atexotechbackend.registration.service.generetoruniquenumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorUniqueNumberParam {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
