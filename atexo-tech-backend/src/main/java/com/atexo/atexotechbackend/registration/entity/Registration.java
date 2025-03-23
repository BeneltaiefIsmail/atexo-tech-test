package com.atexo.atexotechbackend.registration.entity;

import com.atexo.atexotechbackend.common.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "subscriber")
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registration extends AbstractEntity {

    private String firstName ;
    private String lastName ;
    private LocalDate dateOfBirth ;
    private String uniqueIdentifier ;
}
